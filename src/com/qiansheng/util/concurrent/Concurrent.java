package com.qiansheng.util.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Concurrent {
	
	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(2);
		for (int i = 0; i < 4; i++) {
			Runnable run = new Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					System.out.println("thread start" + Thread.currentThread().getName());
				}
			};
			service.execute(run);
		}
		
		service.shutdown();
		try {
			service.awaitTermination((long)1000*4, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("all thread compelete");
	}
}










































