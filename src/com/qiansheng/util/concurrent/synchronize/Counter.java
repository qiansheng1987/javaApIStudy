package com.qiansheng.util.concurrent.synchronize;

public class Counter {
	int count = 0;
	public synchronized void add(long value) {
		this.count += value;
		System.out.println(Thread.currentThread().getName() + "count:==== "+count);
	}
}
