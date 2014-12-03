package com.qiansheng.util.concurrent.tools;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadStack {
	
	public static void main(String[] args) {
		ExecutorService pool = Executors.newFixedThreadPool(20);
		for (int i = 0; i < 30; i++) {
			MyThread myThread = new MyThread();
			Thread thread = new Thread(myThread);
			thread.setName("qianshengThread "  + i);
			pool.execute(thread);
		}
		ThreadStack threadStack = new ThreadStack();
		threadStack.getStackInfo();
		
		try {
			 // 不关闭线程池，程序就会一直处于运行状态，计算main函数推出，线程池也不会自己关闭
			Thread.sleep(10*1000);
			//pool.shutdown();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void getStackInfo() {
		//遍历系统中运行的所有线程
		for (Map.Entry<Thread, StackTraceElement[]> stackTrace : Thread.getAllStackTraces().entrySet()) {
			//获取线程
			Thread thread = (Thread)stackTrace.getKey();
			// 获取线程的堆栈信息
			StackTraceElement[] stack = (StackTraceElement[])stackTrace.getValue();
			// 忽略当前线程
			if (thread.equals(Thread.currentThread())) {
				continue;
			}
			System.out.println("线程：" + thread.getName());
			for (StackTraceElement element : stack) {
				System.out.println(element);
			}
		}
	}
	
	
	static class MyThread implements Runnable {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				Thread.sleep(1000);
				System.out.println(Thread.currentThread().getName() + " is running..... ");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}












































