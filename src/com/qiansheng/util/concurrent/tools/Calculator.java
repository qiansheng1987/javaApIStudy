package com.qiansheng.util.concurrent.tools;


//���ò����̰߳�ȫ�ģ�
//��Ҫ����Ҫ��ס����ʹһ���������̰߳�ȫ�Ĳ��ɱ����ָ��������������Ҳ���ܲ����̰߳�ȫ��

//Calculator�����һ��ָ��ImmutableValueʵ�������á�
//ע�⣬ͨ��setValue()������add()�������ܻ�ı�������á���ˣ���ʹCalculator���ڲ�ʹ����һ�����ɱ����
//��Calculator�౾���ǿɱ�ģ����Calculator�಻���̰߳�ȫ�ġ����仰˵��ImmutableValue�����̰߳�ȫ�ģ�
//��ʹ�������಻�ǡ�������ͨ�����ɱ���ȥ����̰߳�ȫʱ���������Ҫ�μǵġ�
//ҪʹCalculator��ʵ���̰߳�ȫ����getValue()��setValue()��add()����������Ϊͬ���������ɡ�
public class Calculator {
	
	private ImmutableValue currentValue = null;
	public ImmutableValue getValue() {
		return currentValue;
	}
	
	public void setValue(ImmutableValue newValue) {
		this.currentValue = newValue;
	}
	
	public void add(int newValue) {
		this.currentValue = this.currentValue.add(newValue);
	}
}























