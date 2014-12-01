/**  
 * @Project: javaAPIStudy
 * @Title: javaIOTest.java
 * @Package com.qiansheng.io
 * @Description: TODO
 * @author qsdepth@foxmail.com
 * @date 2014-11-28 下午2:41:30
 * @Copyright: 2014 
 * @version V1.0  
 */

package com.qiansheng.io;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

/**
 * @ClassName javaIOTest
 * @Description TODO
 * @author qsdepth@foxmail.com
 * @date 2014-11-28
 */

public class javaIOTest {
	
	private javaIO io = new javaIO();
	/** 
	 * @Title: setUp 
	 * @Description: TODO
	 * @param @throws java.lang.Exception     
	 * @return void     
	 * @throws 
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Test method for {@link com.qiansheng.io.javaIO#createFile()}.
	 */
	@Test
	public void testCreateFile() {
		io.createFile();
	}
	
	@Test
	public void testCreateDir(){
		io.createDir();
	}
	
	@Test
	public void testListDir() {
		io.listDir();
	}
	
	@Test
	public void testWriteStrToFile() throws IOException {
			io.writeStrToFile();
	}

	@Test
	public void testAppendStrToFile() throws IOException {
		io.appendStrToFile();
	}
	
	@Test
	public void testReadFileContent() throws IOException {
		io.readFileContent();
	}
	
	@Test
	public void testReadNotknownFileSize() throws IOException {
		io.readNotknownFileSize();
	}
	
	@Test
	public void testWriteStrToFileByCharStream() throws IOException {
		io.writeStrToFileByCharStream();
	}
	
	@Test
	public void testcopyFile() throws IOException {
		io.copyFile();
	}
	
	@Test
	public void testByteStreamToCharStream() throws IOException {
		io.byteOutputStreamToCharOutputStream();
	}
	
	@Test
	public void testByteInputStreamToCharInputStream() throws IOException {
		io.byteInputStreamToCharInputStream();
	}
	
	@Test
	public void testByteArrayInputOrOutoutStream() throws IOException {
		io.ByteArrayInputOrOutoutStream();
	}
	
	@Test
	public void validatePipedStream() {
		Send send = new Send();
		Recive recive = new Recive();
		//管道连接
		try {
			send.getOut().connect(recive.getInput());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new Thread(send).start();
		new Thread(recive).start();
	}
	
	@Test
	public void testPrintStream() {
		io.printStream();
	}
	
	@Test
	public void testOutputStreamToPreem() {
		io.outputStreamToPreem();
	}
}































