package com.yy.example.java8;

import java.util.Comparator;

public class LambdaTest {

	Runnable r1 = () -> { System.out.println(this); };
	Runnable r2 = () -> { System.out.println(toString()); };

	Runnable r3 = new Runnable() {
		@Override
		public void run() {
			System.out.println(this);
		}
	};

	Runnable r4 = new Runnable() {
		@Override
		public void run() {
			System.out.println(toString());
		}
	};

	public String toString() {  return "Hello, world"; }

	public static void main(String[] args) {
		Runnable r = new Runnable() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName());
			}
		};

		Runnable run2 = () -> System.out.println("run2:"+Thread.currentThread().getName());
		//run2.run();//显示的调用run方法，只是把run当成一个普通的方法，不会新创建线程,还是用主线程走的，此时没有并发存在
		new Thread(run2).start();//这样才会并发

		System.out.println("Done!");

		Runnable run = () -> {
			System.out.println(new Thread().getName());
		}; 
		//run.run();
		
		

		Comparator<String> c1 = (String s1, String s2) -> {
			return s1.compareToIgnoreCase(s2);
		};

		System.out.println(c1.compare("11","22"));

		// 类型推断机制
		Comparator<String> c2 = (s1, s2) -> {
			return s1.compareToIgnoreCase(s2);
		};

		new LambdaTest().r1.run();
		new LambdaTest().r2.run();
		new LambdaTest().r3.run();
		new LambdaTest().r4.run();
	}

}
