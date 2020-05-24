package threadTest.controller;

import java.util.concurrent.Callable;

public class CallabledTest1 implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        // 
        // System.out.print("future");
        return 1;
    }

}
