package com.qiansheng.util.concurrent.tools;

public class RunInstance implements Runnable {

	private int x = 0;
	/*@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(x++);
		}
	}*/
	
	{
		System.out.println("in Runnable non-static block:x=" + x);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("in Runnable run : x=" + ++x);
	}
}



























