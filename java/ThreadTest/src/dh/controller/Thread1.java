package dh.controller;

public class Thread1 {

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		RunnableTest1 testq1 = new RunnableTest1();
		int i = 0;

		Thread d = new Thread(testq1);
		Thread d2 = new Thread(testq1);
		d.start();
		d2.start();
	}

}
