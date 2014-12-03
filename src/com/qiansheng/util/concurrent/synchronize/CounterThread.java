package com.qiansheng.util.concurrent.synchronize;

public class CounterThread extends Thread{
	
	protected Counter counter = null;
	
	public CounterThread(Counter counter) {
		this.counter = counter;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			counter.add(i);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
