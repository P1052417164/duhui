package com.sanhui.synitil.workflow.controller;

public class TestObject {

	private int sd;
	private String df;
	public int getSd() {
		return sd;
	}
	public void setSd(int sd) {
		this.sd = sd;
	}
	public String getDf() {
		return df;
	}
	public void setDf(String df) {
		this.df = df;
	}
	public class dh {
		public TestObject initC() {
			return new TestObject();

		}
	}
	public TestObject getInstance() {
		dh t = new dh();
		return t.initC();
	}
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		TestObject d = new TestObject();
		dh f = d.new dh();
	}
}
