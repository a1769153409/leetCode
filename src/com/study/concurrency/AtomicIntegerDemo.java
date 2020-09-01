package com.study.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author huang.lehao@hand-china.com
 * @Description: 测试AtomicInteger
 * @date 2020/4/8 20:16
 */
public class AtomicIntegerDemo {
    static AtomicInteger atomicInteger = new AtomicInteger();
    public static class MyTread implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 100000; i++) {
                int andIncrement = atomicInteger.getAndIncrement();
            }
        }
    }
        public static void main(String[] args) throws InterruptedException {
            Thread[] t = new Thread[10];
            for (int i=0;i<10;i++){
                t[i] = new Thread(new MyTread());
            }
            for (int i=0;i<10;i++){ t[i].start(); }
            for (int i=0;i<10;i++){ t[i].join(); }
            System.out.println(atomicInteger);
        }
}
