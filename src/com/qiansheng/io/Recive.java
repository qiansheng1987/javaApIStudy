package com.qiansheng.io;

import java.io.IOException;
import java.io.PipedInputStream;

public class Recive implements Runnable {

	private PipedInputStream input = null;
	public Recive() {
		// TODO Auto-generated constructor stub
		this.input = new PipedInputStream();
	}
	
	public PipedInputStream getInput() {
		return this.input;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		byte[] b = new byte[1000];
		int len = 0;
		try {
			len = this.input.read(b);
			input.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("接受的内容为："+ (new String(b, 0, len)));
	}

}
