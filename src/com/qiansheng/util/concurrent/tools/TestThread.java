package com.qiansheng.util.concurrent.tools;

public class TestThread {
	
	public static void main(String[] args) throws InterruptedException {
		/*MyThread mt = new MyThread();
		mt.start();
		try {
			mt.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Thread.sleep(3000);
		//mt.start();//ͨ��Threadʵ����start()��һ��Thread��ʵ��ֻ�ܲ���һ���߳�  �ᱨ�쳣java.lang.IllegalThreadStateException
		System.out.println("1001");*/
		
		
		
		
		
		/*��һ��Runnableʵ����Thread�����ΰ�װ�����ǾͿ��Կ�������ʵ������ͬһʵ���������߳�*/
		/*RunInstance r = new RunInstance();
		for (int i = 0; i < 10; i++) {
			new Thread(r).start();
		}*/
		
		
		/*for (int i = 0; i < 10; i++) {
			Thread t = new MyThread();
			t.start();
		}
		Thread.sleep(10000);*/
		
		//ͬһ��ʵ���Ķ��߳�
		/*RunInstance r = new RunInstance();
		for (int i = 0; i < 10; i++) {
			Thread t = new Thread(r);
			t.start();
		}*/
		
		
		int x = 1;
		RunInstance r = new RunInstance();
		for (int i = 0; i < 10; i++) {
			Thread t = new Thread(r);
			t.start();
		}

		
	}
}









































