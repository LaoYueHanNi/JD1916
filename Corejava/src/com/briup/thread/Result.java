package com.briup.thread;

public class Result {
	private int value;
	//是否有等待的线程
	private boolean iswait=false;
	public boolean isIswait() {
		return iswait;
	}
	public void setIswait(boolean iswait) {
		this.iswait = iswait;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value=value;
	}
	 
}
