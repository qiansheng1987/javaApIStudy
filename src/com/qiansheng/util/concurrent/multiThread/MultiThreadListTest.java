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
		//Collection<Integer> list = new ArrayList<Integer>();////抛出异常：java.util.ConcurrentModificationException 
		
		
		/***************************************************/
		//使用java.util.concurrent包中的ConcurrentLinkedQueue高效的同步集合
		Collection<Integer> list = new ConcurrentLinkedQueue<Integer>(); //没有抛出异常
		
		
		list.add(6);
        list.add(3);
        list.add(43);
        list.add(88);
        list.add(1);
        Lock lock = new ReentrantLock();
        //启动100个线程，在多线程下测试集合的同步问题
        for (int i = 0; i < 100; i++) {
			new Thread(new ModifyCollectionTask(list, lock)).start();
		}
	}
	
	
	/**
	 * 常用的集合类ArrayList、Map等在多线程操作同一对象时会发生不同步的线程而造成数据读取和写入错误；
	 * 通常都是采用synchronized修饰符或Lock将那些方法括起来来确保它们在执行时不会被其他线程打扰。 
	 * 这样做虽然解决了数据争用问题，但是在并发性方面付出了更多的代价，因为在迭代期间锁住整个List会阻塞其他线程，使它们在很长一段时间内不能访问这个列表。 
	 */

}


















