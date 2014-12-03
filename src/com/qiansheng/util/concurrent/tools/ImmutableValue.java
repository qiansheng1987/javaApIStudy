package com.qiansheng.util.concurrent.tools;

public class ImmutableValue {
	
	private int value = 0;
	
	public ImmutableValue(int value) {
		this.value = value;
	}
	
	/*
	 * 请注意ImmutableValue类的成员变量value是通过构造函数赋值的，并且在类中没有set方法。
	 * 这意味着一旦ImmutableValue实例被创建，value变量就不能再被修改，
	 * 这就是不可变性。但你可以通过getValue()方法读取这个变量的值。
	 * */
	public int getValue() {
		return this.value;
	}
	
	//如果你需要对ImmutableValue类的实例进行操作，可以通过得到value变量后创建一个新的实例来实现.
	public ImmutableValue add(int valueToAdd) {
		return new ImmutableValue(this.value + valueToAdd);
	}
	
	//引用不是线程安全的！
	//重要的是要记住，即使一个对象是线程安全的不可变对象，指向这个对象的引用也可能不是线程安全的
}






















