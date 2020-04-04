package pxoryTest.controller;

public class ProxyDhTest {
	public void sayHello(DhTestImpl dh) {
		System.out.println("start");
		dh.sayHello();
		System.out.println("end");
	}
	public static void main(String[] args) {
		ProxyDhTest pd = new ProxyDhTest();
		pd.sayHello(new DhTestImpl());
	}
}
