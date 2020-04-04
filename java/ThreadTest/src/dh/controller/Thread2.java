package dh.controller;

public class Thread2 extends Thread {
	private static boolean flag = false;
	public void run() {
		while (!flag) {
			System.out.println(flag);
		} ;
	}
	public static void main(String[] args) throws Exception {
		new Thread2().start();
		Thread.sleep(2);
		flag = true;
	}
}
