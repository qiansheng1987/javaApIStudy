package com.qiansheng.io;

import java.io.IOException;
import java.io.PipedOutputStream;

public class Send implements Runnable {

	private PipedOutputStream out = null;
	public Send() {
		// TODO Auto-generated constructor stub
		out = new PipedOutputStream();
	}
	
	public PipedOutputStream getOut() {
		return this.out;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		String message = "hello Rolean";
		try {
			out.write(message.getBytes());
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

























