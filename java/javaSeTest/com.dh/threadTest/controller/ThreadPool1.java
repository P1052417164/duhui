package threadTest.controller;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class ThreadPool1 {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		ExecutorService cachePool = Executors.newCachedThreadPool();

		CallabledTest1 r1 = new CallabledTest1();
		new Thread();
		FutureTask<Integer> result = new FutureTask<>(r1);

		new Thread(result).start();
		try {
			int ii = result.get();
		} catch (InterruptedException | ExecutionException e) {
			// 
			e.printStackTrace();
		}
		RunnableTest1 d = new RunnableTest1();
		for (int i = 1; i <= 50; i++) {
			cachePool.execute(d);

		}
	}
}
