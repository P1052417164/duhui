package threadTest.controller;

import java.util.concurrent.locks.ReentrantLock;

import utils.HelloWord;

public class RunnableTest1 implements Runnable {

    private int i = 0;
    final ReentrantLock lock = new ReentrantLock();
    private HelloWord h;
    final int dd = 0;

    @Override
    public void run() {
       // synchronized (this) {
            //count();
            // 
             //System.out.println(Thread.currentThread().getName());
            // System.out.println("before");
             lock.lock();
             
            try {
                h.say();
            } catch (Exception e) {

            } finally {
                 lock.unlock();

            }
       // }
        // System.out.println("center");

        // System.out.println("after");

    }

    public HelloWord getH() {
        return h;
    }

    public void setH(HelloWord h) {
        this.h = h;
    }

    public void count() {

        // System.out.println(Thread.currentThread().getName());
        i = i + 1;
        System.out.println(i);

    }

    public int getI() {
        return i;
    }
}
