package com.qiansheng.util.concurrent.synchronize;

public class TestThread {

	public static void main(String[] args) {
		Counter counter = new Counter();
		Thread threadA = new CounterThread(counter);
		Thread threadB = new CounterThread(counter);
		threadA.start();
		threadB.start();
	}
}
