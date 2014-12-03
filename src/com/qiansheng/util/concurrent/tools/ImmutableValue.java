package com.qiansheng.util.concurrent.tools;

public class ImmutableValue {
	
	private int value = 0;
	
	public ImmutableValue(int value) {
		this.value = value;
	}
	
	/*
	 * ��ע��ImmutableValue��ĳ�Ա����value��ͨ�����캯����ֵ�ģ�����������û��set������
	 * ����ζ��һ��ImmutableValueʵ����������value�����Ͳ����ٱ��޸ģ�
	 * ����ǲ��ɱ��ԡ��������ͨ��getValue()������ȡ���������ֵ��
	 * */
	public int getValue() {
		return this.value;
	}
	
	//�������Ҫ��ImmutableValue���ʵ�����в���������ͨ���õ�value�����󴴽�һ���µ�ʵ����ʵ��.
	public ImmutableValue add(int valueToAdd) {
		return new ImmutableValue(this.value + valueToAdd);
	}
	
	//���ò����̰߳�ȫ�ģ�
	//��Ҫ����Ҫ��ס����ʹһ���������̰߳�ȫ�Ĳ��ɱ����ָ��������������Ҳ���ܲ����̰߳�ȫ��
}






















