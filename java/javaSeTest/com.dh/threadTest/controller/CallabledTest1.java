package threadTest.controller;

import java.util.concurrent.Callable;

public class CallabledTest1 implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		// 
		return 1;
	}

}
