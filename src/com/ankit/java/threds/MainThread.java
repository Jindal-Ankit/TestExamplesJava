package com.ankit.java.threds;

import java.util.concurrent.CountDownLatch;

public class MainThread {
	public static void main(String[] args) throws InterruptedException {
		CountDownLatch latch = new CountDownLatch(3);

		Runnable waiter = new Waiter(latch);
		
		Runnable decrementer = new Decrementer(latch);

		new Thread(waiter).start();
		new Thread(decrementer).start();

		Thread.sleep(4000);
	}
	}
	
