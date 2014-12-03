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
			 // ���ر��̳߳أ�����ͻ�һֱ��������״̬������main�����Ƴ����̳߳�Ҳ�����Լ��ر�
			Thread.sleep(10*1000);
			//pool.shutdown();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void getStackInfo() {
		//����ϵͳ�����е������߳�
		for (Map.Entry<Thread, StackTraceElement[]> stackTrace : Thread.getAllStackTraces().entrySet()) {
			//��ȡ�߳�
			Thread thread = (Thread)stackTrace.getKey();
			// ��ȡ�̵߳Ķ�ջ��Ϣ
			StackTraceElement[] stack = (StackTraceElement[])stackTrace.getValue();
			// ���Ե�ǰ�߳�
			if (thread.equals(Thread.currentThread())) {
				continue;
			}
			System.out.println("�̣߳�" + thread.getName());
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












































