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
		//mt.start();//通过Thread实例的start()，一个Thread的实例只能产生一个线程  会报异常java.lang.IllegalThreadStateException
		System.out.println("1001");*/
		
		
		
		
		
		/*把一个Runnable实例给Thread对象多次包装，我们就可以看到它们实际是在同一实例上启动线程*/
		/*RunInstance r = new RunInstance();
		for (int i = 0; i < 10; i++) {
			new Thread(r).start();
		}*/
		
		
		/*for (int i = 0; i < 10; i++) {
			Thread t = new MyThread();
			t.start();
		}
		Thread.sleep(10000);*/
		
		//同一个实例的多线程
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









































