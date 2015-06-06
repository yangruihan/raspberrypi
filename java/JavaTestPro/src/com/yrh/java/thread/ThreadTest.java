package com.yrh.java.thread;

public class ThreadTest extends Thread {
	
	@Override
	public void run() {
		super.run();
		
		System.out.println("线程开始");
		
		int count = 0;
		boolean keepRunning = true;
		while (keepRunning) {
			System.out.println(this.getName() + " " + (++count));
			
			// 休眠一下
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if (count >= 100) {
				keepRunning = false;
			}
		}
		
		System.out.println("线程结束");
	}
	
	public static void main(String[] args) {
		Thread thread = new ThreadTest();
		thread.start();
	}
}
