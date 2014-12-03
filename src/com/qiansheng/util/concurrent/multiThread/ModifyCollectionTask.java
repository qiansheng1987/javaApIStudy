package com.qiansheng.util.concurrent.multiThread;

import java.util.Collection;
import java.util.concurrent.locks.Lock;

public class ModifyCollectionTask implements Runnable{

	Collection<Integer> list;
	Lock lock = null;
	
	public ModifyCollectionTask(Collection<Integer> slist, Lock lock) {
		this.list = slist;
		this.lock = lock;
	}
	
	@Override
	public void run() {
		
		// 遍历列表
		for (Integer num : list) {
			System.out.println("线程"+ Thread.currentThread().getName() + "数据为：" + num);
		}
		
		//向列表中添加元素
		list.add(40);
	}
}

































