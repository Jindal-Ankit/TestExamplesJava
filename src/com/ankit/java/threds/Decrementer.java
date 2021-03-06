package com.ankit.java.threds;

import java.util.concurrent.CountDownLatch;

class Decrementer implements Runnable {

	CountDownLatch latch = null;

	public Decrementer(CountDownLatch latch) {
		this.latch = latch;
	}

	public void run() {

		try {
			Thread.sleep(1000);
			this.latch.countDown();

			Thread.sleep(1000);
			this.latch.countDown();

			Thread.sleep(1000);
			this.latch.countDown();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}