package com.qiansheng.util.concurrent.tools;


//引用不是线程安全的！
//重要的是要记住，即使一个对象是线程安全的不可变对象，指向这个对象的引用也可能不是线程安全的

//Calculator类持有一个指向ImmutableValue实例的引用。
//注意，通过setValue()方法和add()方法可能会改变这个引用。因此，即使Calculator类内部使用了一个不可变对象，
//但Calculator类本身还是可变的，因此Calculator类不是线程安全的。换句话说：ImmutableValue类是线程安全的，
//但使用它的类不是。当尝试通过不可变性去获得线程安全时，这点是需要牢记的。
//要使Calculator类实现线程安全，将getValue()、setValue()和add()方法都声明为同步方法即可。
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























