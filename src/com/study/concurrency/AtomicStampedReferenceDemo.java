package com.study.concurrency;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author huang.lehao@hand-china.com
 * @Description: 测试AtomicStampedReference
 * @date 2020/4/8 20:37
 */
public class AtomicStampedReferenceDemo {
    static AtomicStampedReference<Integer> money=new AtomicStampedReference<Integer>(19,0);

    public static void main(String[] args) {
        int stamp=money.getStamp();
        //多个线程充值，由于stamp，
        for(int i=0;i<10;i++){
            System.out.println("生产者 stamp="+stamp);
            new Thread(){
                @Override
                public void run() {
                    while (true){
                        while (true){
                            Integer m=money.getReference();
                            System.out.println("生产者 m="+m);
                            if(m<20){
                                if (money.compareAndSet(m,m+20,stamp,stamp+1)){
                                    System.out.println("少于20，充值成功，余额："+money.getReference()+"元");
                                    break;
                                }
                            }else {
                                System.out.println("余额大于20，不需要充值");
                                break;
                            }
                        }
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }.start();
        }

        for(int i=0;i<1;i++){
            new Thread(){
                @Override
                public void run() {
                    while (true){
                        while (true){
                            Integer m=money.getReference();
                            int stamp=money.getStamp();
                            System.out.println("消费者：m="+m+",stamp="+stamp);
                            if(m>10){
                                if (money.compareAndSet(m,m-10,stamp,stamp+1)){
                                    System.out.println("成功消费10元，余额："+money.getReference()+"元");
                                    break;
                                }
                            }else {
                                System.out.println("没有足够的金额");
                                break;
                            }
                        }
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }.start();
        }

    }
}
