package com.qiansheng.util.concurrent.tools;

public class MyThread extends Thread {
	
	public int x = 0;
	
	/*@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(10);
				System.out.println(x++);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}*/
	
	
	public int count = 1;
	{
		System.out.println("in MyThread non-static block:x=" + count++);
	}
	
	@Override
	public void run() {
		System.out.println("in MyThread run:x=" + ++x);
	}
}



























