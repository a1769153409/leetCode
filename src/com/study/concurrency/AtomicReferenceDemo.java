package com.study.concurrency;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author huang.lehao@hand-china.com
 * @Description: 测试AtomicReference
 * @date 2020/4/8 21:16
 */
public class AtomicReferenceDemo {
    static AtomicReference<String> s = new AtomicReference<>("abc");

    public static void main(String[] args) {
        for(int i=0;i<10;i++){
            new Thread(){
                @Override
                public void run() {
                    try {
                        Thread.sleep((long) Math.abs(Math.random()*100));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (s.compareAndSet("abc","bcd")){
                        System.out.println("成功修改成bcd");
                    }else{
                        System.out.println("修改失败");
                    }
                }
            }.start();
        }
    }
}
