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
 * �����ֽ������ַ���������
 * ʵ�����ֽ����ڲ�����ʱ�����ǲ����õ��������ģ����ļ������ֱ�Ӳ����ģ�
 * �����ַ����ڲ����� ʱ���º��ǻ��õ��������ģ���ͨ���������������ļ��ġ�
 * ���߿������Ž�������ֽ������ַ����ĳ�������һ�йر��ļ��Ĵ���ע�͵���
 * Ȼ�����г��򿴿�����ͻᷢ��ʹ���ֽ����Ļ����ļ����Ѿ��������ݣ�
 * ����ʹ���ַ�����ʱ���ļ��л���û�����ݵģ����ʱ���Ҫˢ�»�������
 * 
 * ʹ���ֽ����û����ַ�������?
 * �����ֽ�����������ΪӲ���ϵ������ļ��������ֽڵ���ʽ���д�����߱���ģ�����ͼƬ�����ݣ������ַ�
 * ֻ�����ڴ��вŻ��γɵģ������ڿ����У��ֽ���ʹ�ù㷺��
 * 
 * OutputStreramWriter ��InputStreamReader��
 * ����IO������ֽ������ַ����������ֽں��ַ�ת����
 * outputStreamWriter��������ַ���ת��Ϊ�ֽ���
 * InputStreamReader��������ֽ���ת��Ϊ�ַ���
 * ���ǲ�����β�������������ֽڵ���ʽ�������ļ��еġ�
 * 
 * 
 * ǰ���оٵ�������붼�����ļ����еģ������������ڴ�Ϊ�������Ŀ�ĵأ�ʹ���ڴ������
 *  ByteArrayInputStream ��Ҫ������д���ڴ�
 *  ByteArrayOutputStream  ��Ҫ�����ݴ��ڴ����
 *  ע�⣺���ݲ�����һ��ʹ��������һЩ��ʱ��Ϣ���õģ��������Ա���ɾ�����鷳��
 *  
 *  �ܵ���
 *  �ܵ�����Ҫ���Խ��������߳�֮���ͨ��
 *  PipedOutputStream�ܵ������
 *  PipeInputStream�ܵ�������
 *  
 *  ��ӡ��
 *  ʹ��PrintStream�������
 * 
 * */
public class javaIO {
	
	private static String FILE_NAME = "D:" + File.separator + "hello.txt";
	private static String COPYTO_FILE_NAME = "D:" + File.separator + "copyToHello.txt";
	
	public void createFile() {

		File file = new File("d:" + File.separator + "hello.txt");
		try {
			System.out.println(File.separator); // ����� \
			System.out.println(File.pathSeparator); //�����;
			System.out.println(file.getParent());
			Boolean result = file.createNewFile();
			if (result) {
				System.out.println("�����ɹ���");
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
	* @Description: �ֽ���    ���ļ���д���ַ���
	* @param      
	* @return void     
	* @throws
	 */
	public void writeStrToFile() throws IOException {
		String fileName = "D:" + File.separator + "hello.txt";
		File f = new File(fileName);
		OutputStream out = new FileOutputStream(f);
		String str = "���";
		byte[] bt = str.getBytes();
		out.write(bt);
		out.flush();
		out.close();
	}
	
	
	/**
	 * 
	* @Title: appendStrToFile 
	* @Description: ���ļ���׷��������
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
	* @Description: ���ļ�����,��ʡ�ռ�
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
			System.out.println("�ļ�����Ϊ"+ f.length());
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
	* @Description: ��ȡ��֪���ļ������ļ�����
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
	
	/*****************************�ַ��� *******************************************/
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
		String str = "Ǯʤ";
		out.write(str);
		out.flush();
		out.close();
	}
	
	
	/**
	* @throws IOException 
	* @Title: copyFile 
	* @Description: �ļ��ĸ���  ��һ���ļ���ȡ��д�뵽�����ļ�
	* @param      
	* @return void     
	* @throws
	 */
	public void copyFile() throws IOException {
		File file1 = new File(FILE_NAME);
		File file2 = new File(COPYTO_FILE_NAME);
		
		if (!file1.exists()) {
			System.out.println("�����Ƶ��ļ������ڣ�");
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
	
	
	/***********************���ֽ������ת��Ϊ�ַ������**********************************/
	
	/**
	 * @throws IOException 
	* @Title: byteStreamToCharStream 
	* @Description: ���ֽ������ת��Ϊ�ַ������
	* @param      
	* @return void     
	* @throws
	 */
	public void byteOutputStreamToCharOutputStream() throws IOException {
		File file = new File (FILE_NAME);
		try {
			Writer out = new OutputStreamWriter(new FileOutputStream(file));//���ֽ������ת��Ϊ�ַ������
			out.write("hello qiansheng ");
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/***********************���ֽ���������Ϊ�ַ������� **********************************/
	/**
	 * 
	* @Title: byteInputStreamToCharInputStream 
	* @Description: ���ֽ���������Ϊ�ַ�������
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
	
	
	/***********************ʹ���ڴ��������һ����д��ĸת��ΪСд��ĸ *****************************/
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
	
	
	/***********************��ӡ��*************************/
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


















































