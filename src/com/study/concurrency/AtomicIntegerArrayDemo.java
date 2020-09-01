package com.study.concurrency;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * @author huang.lehao@hand-china.com
 * @Description: 测试AtomicIntegerArray
 * @date 2020/4/8 21:24
 */
public class AtomicIntegerArrayDemo {
    static AtomicIntegerArray arr=new AtomicIntegerArray(10);

    public static class AddThread implements Runnable {
        @Override
        public void run() {
            for(int i=0;i<100000;i++){
                arr.getAndIncrement(i % arr.length());//找到第i%arr.length()进行+1操作
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] t = new Thread[10];
        for (int i=0;i<10;i++){
            t[i] = new Thread(new AddThread());
        }
        for (int i=0;i<10;i++){ t[i].start(); }
        for (int i=0;i<10;i++){ t[i].join(); }
        System.out.println(arr);
    }
}
