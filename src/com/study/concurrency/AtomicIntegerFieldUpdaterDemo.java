package com.study.concurrency;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @author huang.lehao@hand-china.com
 * @Description: 测试AtomicIntegerFieldUpdater
 * @date 2020/4/8 21:53
 */
public class AtomicIntegerFieldUpdaterDemo {
    private static class Candidate{
        int id;
        volatile int score;
    }

    public final static AtomicIntegerFieldUpdater<Candidate> scoreUpdater = AtomicIntegerFieldUpdater.newUpdater(Candidate.class, "score");
    //检查Updater是否正确
    public static AtomicInteger a = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {
        final Candidate c = new Candidate();
        Thread[]t=new Thread[1000];
        for (int i=0;i<1000;i++){
            t[i]=new Thread(){
                @Override
                public void run() {
                    if(Math.random()>0.4){
                        scoreUpdater.incrementAndGet(c);
                        a.incrementAndGet();
                    }
                }
            };
            t[i].start();
        }
        for (int i=0;i<1000;i++){
            t[i].join();
        }
        System.out.println(c.score);
        System.out.println(a);

    }
}
