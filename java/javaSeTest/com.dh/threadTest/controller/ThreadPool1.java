package threadTest.controller;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

import utils.HelloWord;

public class ThreadPool1 {

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        ExecutorService cachePool = Executors.newCachedThreadPool();

        CallabledTest1 r1 = new CallabledTest1();
        Thread t = new Thread();

        FutureTask<Integer> result = new FutureTask<>(r1);
        Future<Integer> dd = cachePool.submit(r1);
        Future<?> dd2 = cachePool.submit(result);

        new Thread(result).start();
        cachePool.submit(r1);
        try {
            int ii = dd.get();
            Object ii2 = dd2.get();
            int ii3 = result.get();
            System.out.println(ii);
            System.out.println(ii3);
        } catch (InterruptedException | ExecutionException e) {
            // 
            e.printStackTrace();
        }
        RunnableTest1 d = new RunnableTest1();
        RunnableTest1 d2 = new RunnableTest1();
        RunnableTest3 d3 = new RunnableTest3();
        cachePool.execute(d3);
        cachePool.execute(d3);
        HelloWord ddd = new HelloWord();
        HelloWord ddd2 = new HelloWord();
        d.setH(ddd);
        d2.setH(ddd);
        for (int i = 1; i <= 50; i++) {
            //cachePool.execute(d);
            //S cachePool.execute(d2);

        }
        Integer j = 44;

        int ij2 = 44;
        System.out.println(j == ij2);
        String s2="ddd";
        String s = new String("ddd");
        char[] schar = s.toCharArray();
        String hh = schar.toString();
        System.out.println(s == s2);
    }
}
