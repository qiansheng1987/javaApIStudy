package com.qiansheng.util.concurrent.multiThread;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MultiThreadListTest {

	/** 
	 * @Title: main 
	 * @Description: TODO
	 * @param @param args     
	 * @return void     
	 * @throws 
	 */

	public static void main(String[] args) {
		/***************************************************/
		//Collection<Integer> list = new ArrayList<Integer>();////�׳��쳣��java.util.ConcurrentModificationException 
		
		
		/***************************************************/
		//ʹ��java.util.concurrent���е�ConcurrentLinkedQueue��Ч��ͬ������
		Collection<Integer> list = new ConcurrentLinkedQueue<Integer>(); //û���׳��쳣
		
		
		list.add(6);
        list.add(3);
        list.add(43);
        list.add(88);
        list.add(1);
        Lock lock = new ReentrantLock();
        //����100���̣߳��ڶ��߳��²��Լ��ϵ�ͬ������
        for (int i = 0; i < 100; i++) {
			new Thread(new ModifyCollectionTask(list, lock)).start();
		}
	}
	
	
	/**
	 * ���õļ�����ArrayList��Map���ڶ��̲߳���ͬһ����ʱ�ᷢ����ͬ�����̶߳�������ݶ�ȡ��д�����
	 * ͨ�����ǲ���synchronized���η���Lock����Щ������������ȷ��������ִ��ʱ���ᱻ�����̴߳��š� 
	 * ��������Ȼ����������������⣬�����ڲ����Է��渶���˸���Ĵ��ۣ���Ϊ�ڵ����ڼ���ס����List�����������̣߳�ʹ�����ںܳ�һ��ʱ���ڲ��ܷ�������б� 
	 */

}


















