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
		
		// �����б�
		for (Integer num : list) {
			System.out.println("�߳�"+ Thread.currentThread().getName() + "����Ϊ��" + num);
		}
		
		//���б������Ԫ��
		list.add(40);
	}
}

































