package com.qiansheng.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Reader;
import java.io.Writer;

/**
 * 
 * @ClassName javaIO
 * @Description TODO
 * @author qsdepth@foxmail.com
 * @date 2014-11-28
 */

/**
 * 关于字节流和字符流的区别
 * 实际上字节流在操作的时候本身是不会用到缓冲区的，是文件本身的直接操作的，
 * 但是字符流在操作的 时候下后是会用到缓冲区的，是通过缓冲区来操作文件的。
 * 读者可以试着将上面的字节流和字符流的程序的最后一行关闭文件的代码注释掉，
 * 然后运行程序看看。你就会发现使用字节流的话，文件中已经存在内容，
 * 但是使用字符流的时候，文件中还是没有内容的，这个时候就要刷新缓冲区。
 * 
 * 使用字节流好还是字符流好呢?
 * 答案是字节流，首先因为硬盘上的所有文件都是以字节的形式进行传输或者保存的，包括图片等内容，但是字符
 * 只是在内存中才会形成的，所以在开发中，字节流使用广泛。
 * 
 * OutputStreramWriter 和InputStreamReader类
 * 整个IO类除了字节流和字符流还包括字节和字符转换流
 * outputStreamWriter将输出的字符流转化为字节流
 * InputStreamReader将输入的字节流转换为字符流
 * 但是不管如何操作，最后都是以字节的形式保存在文件中的。
 * 
 * 
 * 前面列举的输出输入都是以文件进行的，现在我们以内存为输出输入目的地，使用内存操作流
 *  ByteArrayInputStream 主要将内容写入内存
 *  ByteArrayOutputStream  主要将内容从内存输出
 *  注意：内容操作流一般使用来生成一些临时信息采用的，这样可以避免删除的麻烦。
 *  
 *  管道流
 *  管道流主要可以进行两个线程之间的通信
 *  PipedOutputStream管道输出流
 *  PipeInputStream管道输入流
 *  
 *  打印流
 *  使用PrintStream进行输出
 * 
 * */
public class javaIO {
	
	private static String FILE_NAME = "D:" + File.separator + "hello.txt";
	private static String COPYTO_FILE_NAME = "D:" + File.separator + "copyToHello.txt";
	
	public void createFile() {

		File file = new File("d:" + File.separator + "hello.txt");
		try {
			System.out.println(File.separator); // 结果： \
			System.out.println(File.pathSeparator); //结果：;
			System.out.println(file.getParent());
			Boolean result = file.createNewFile();
			if (result) {
				System.out.println("创建成功！");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
	public void createDir() {
			
		File file = new File("d:" + File.separator + "hello");
		file.mkdir();
	}
	
	public void listDir() {
		
		File file = new File("d:" + File.separator);
		String[] fileStr = file.list();
		for (String str : fileStr) {
			System.out.println(str + "\n");
		}
	}
	
	
	/**
	 * @throws IOException 
	 * @throws FileNotFoundException 
	* @Title: writeStrToFile 
	* @Description: 字节流    向文件中写入字符串
	* @param      
	* @return void     
	* @throws
	 */
	public void writeStrToFile() throws IOException {
		String fileName = "D:" + File.separator + "hello.txt";
		File f = new File(fileName);
		OutputStream out = new FileOutputStream(f);
		String str = "你好";
		byte[] bt = str.getBytes();
		out.write(bt);
		out.flush();
		out.close();
	}
	
	
	/**
	 * 
	* @Title: appendStrToFile 
	* @Description: 向文件中追加新内容
	* @param @throws IOException     
	* @return void     
	* @throws
	 */
	public void appendStrToFile() throws IOException {
		String fileName = "D:" + File.separator + "hello.txt";
		File f = new File(fileName);
		try {
			OutputStream out = new FileOutputStream(f, true);
			String str = "qiansheng";
			byte[] b = str.getBytes();
			for (int i = 0; i < b.length; i++) {
				out.write(b[i]);
			}
			out.flush();
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/**
	 * @throws IOException 
	* @Title: readFileContent 
	* @Description: 读文件内容,节省空间
	* @param  void   
	* @return void     
	* @throws
	 */
	public void readFileContent() throws IOException {
		
		String fileName = "D:" + File.separator + "hello.txt";
		File f = new File(fileName);
		try {
			InputStream in = new FileInputStream(f);
			byte[] b = new byte[(int)f.length()];
			in.read(b);
			System.out.println("文件长度为"+ f.length());
			in.close();
			System.out.println(new String(b));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/**
	 * @throws IOException 
	* @Title: readNotknownFileSize 
	* @Description: 读取不知道文件多大的文件内容
	* @param      
	* @return void     
	* @throws
	 */
	public void readNotknownFileSize() throws IOException{
		File f = new File(FILE_NAME);
		try {
			InputStream in = new FileInputStream(f);
			byte[] b = new byte[1024];
			int temp = 0;
			int count = 0;
			while((temp=in.read())!=(-1)){
	            b[count++]=(byte)temp;
	        }
			in.close();
			System.out.println(new String(b));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*****************************字符流 *******************************************/
	/**
	 * 
	* @Title: writeStrToFileByCharStream 
	* @Description: TODO
	* @param @throws IOException     
	* @return void     
	* @throws
	 */
	public void writeStrToFileByCharStream() throws IOException {
		File f = new File(FILE_NAME);
		Writer out = new FileWriter(f);
		String str = "钱胜";
		out.write(str);
		out.flush();
		out.close();
	}
	
	
	/**
	* @throws IOException 
	* @Title: copyFile 
	* @Description: 文件的复制  从一个文件读取，写入到其他文件
	* @param      
	* @return void     
	* @throws
	 */
	public void copyFile() throws IOException {
		File file1 = new File(FILE_NAME);
		File file2 = new File(COPYTO_FILE_NAME);
		
		if (!file1.exists()) {
			System.out.println("被复制的文件不存在！");
		}
		
		try {
			InputStream in = new FileInputStream(file1);
			OutputStream out = new FileOutputStream(file2);
			if ((in != null) && (out != null)) {
				int temp = 0;
				while ((temp = in.read()) != -1) {
					out.write(temp);
				}
			}
			in.close();
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/***********************将字节输出流转化为字符输出流**********************************/
	
	/**
	 * @throws IOException 
	* @Title: byteStreamToCharStream 
	* @Description: 将字节输出流转化为字符输出流
	* @param      
	* @return void     
	* @throws
	 */
	public void byteOutputStreamToCharOutputStream() throws IOException {
		File file = new File (FILE_NAME);
		try {
			Writer out = new OutputStreamWriter(new FileOutputStream(file));//将字节输出流转化为字符输出流
			out.write("hello qiansheng ");
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/***********************将字节输入流变为字符输入流 **********************************/
	/**
	 * 
	* @Title: byteInputStreamToCharInputStream 
	* @Description: 将字节输入流变为字符输入流
	* @param @throws IOException     
	* @return void     
	* @throws
	 */
	public void byteInputStreamToCharInputStream() throws IOException {
		File file = new File (FILE_NAME);
		try {
			Reader reader = new InputStreamReader(new FileInputStream(file));
			char[] b = new char[100];
			int len = reader.read(b);
			System.out.println(new String(b,0, len));
			reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/***********************使用内存操作流将一个大写字母转化为小写字母 *****************************/
	/**
	 * 
	* @Title: ByteArrayInputOrOutoutStream 
	* @Description: TODO
	* @param @throws IOException     
	* @return void     
	* @throws
	 */
	public void ByteArrayInputOrOutoutStream() throws IOException {
		String str = "qiansheng user bytearray";
		ByteArrayInputStream input = new ByteArrayInputStream(str.getBytes());
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		int temp = 0;
		while ((temp = input.read()) != -1) {
			char ch = (char)temp;
			output.write(Character.toUpperCase(ch));
		}
		String outStr = output.toString();
		input.close();
		output.close();
		System.out.println(outStr);
	}
	
	
	/***********************打印流*************************/
	public void printStream() {
		try {
			PrintStream print = new PrintStream(new FileOutputStream(new File(FILE_NAME)));
			print.print(true);
			print.println("Rollean");
			print.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void outputStreamToPreem() {
		OutputStream out = System.out;
		try {
			out.write("hello".getBytes());
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}


















































