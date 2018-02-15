package com.ankit.practice.problems;

import java.io.InputStream;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

public class AverageOfStream {

	private  BlockingQueue<Integer>  queue = new ArrayBlockingQueue<Integer>(5);
	
	public static void main(String[] args) {
		AverageOfStream avg =  new AverageOfStream();
		Thread streamProducer = new Thread(avg.new IntStream(avg.queue));
		Thread streamConsumer = new Thread(avg.new CalculateAvg(avg.queue));
		streamConsumer.start();
		streamProducer.start();
	}
// thread to create stream of integer
	class IntStream implements Runnable{

		private BlockingQueue<Integer> queue = null;
		public IntStream(BlockingQueue<Integer> queue) {
			this.queue = queue;
		}
		@Override
		public void run() {
			int i = 0;
			while(true){
				try {
					queue.put(++i);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	class CalculateAvg implements Runnable{
		private int count = 0;
		private int sum = 0;
		private BlockingQueue<Integer> queue = null;
		public CalculateAvg(BlockingQueue<Integer> queue) {
				this.queue = queue;
		}
		@Override
		public void run() {
			while(true){
				try {
					sum += queue.take();
					++count;
					float avg = (float) sum /count;
					Thread.sleep(1000);
					System.out.println("Avg "+ avg);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}
