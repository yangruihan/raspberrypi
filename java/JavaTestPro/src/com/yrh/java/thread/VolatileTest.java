package com.yrh.java.thread;

public class VolatileTest {

	public static int count = 0;
	public static Object lock = new Object();

	public static synchronized void inc() {
//		synchronized (lock) {
//			count++;
//		}

//		try {
//			Thread.sleep(1);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		 count++;
	}

	public static void test() {
		// 同时启动1000个线程，去进行i++计算，看看实际结果

		for (int i = 0; i < 1000; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					VolatileTest.inc();
				}
			}).start();
		}

		// 这里每次运行的值都有可能不同，可能为1000，即使使用了 volatile 修饰符，结果还不一定是1000
		System.out.println("运行结果:Counter.count=" + VolatileTest.count);
	}

	public static void main(String[] args) {

		for (int i = 0; i < 100; i++) {
			VolatileTest.test();
			VolatileTest.count = 0;
		}

	}

}
