package threadTest.controller;

import java.util.concurrent.locks.ReentrantLock;

public class RunnableTest1 implements Runnable {

	private volatile int i = 0;
	final ReentrantLock lock = new ReentrantLock();
    final int dd=0;
	@Override
	public void run() {
		// 
		// System.out.println(Thread.currentThread().getName());
		// System.out.println("before");
		lock.lock();
		try {
			count();
		} catch (Exception e) {

		} finally {
			lock.unlock();

		}
		// System.out.println("center");

		// System.out.println("after");

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
