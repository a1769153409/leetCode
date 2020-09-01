package com.study.reentrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author huang.lehao@hand-china.com
 * @Description: 测试ReentrantLock
 * @date 2020/4/10 19:18
 */
public class ReentrantLockDemo implements Runnable {
    private static ReentrantLock reentrantLock = new ReentrantLock();
    private static int index = 0;

    @Override
    public void run() {

        for (int i = 0; i < 100000; i++) {
            reentrantLock.lock();
            reentrantLock.lock();
            try {
                index++;
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantLockDemo reentrantLockDemo = new ReentrantLockDemo();
        Thread thread1 = new Thread(reentrantLockDemo);
        Thread thread2 = new Thread(reentrantLockDemo);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(index);

    }

}
