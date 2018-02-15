package com.ankit.practice.problems;

import java.security.cert.CollectionCertStoreParameters;
import java.util.Collections;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;

public class StringreverseThread  implements Runnable{

	private BlockingQueue<String> rawStringQueue;
	private BlockingQueue<String> reversedStringQueue;	
	public StringreverseThread(BlockingQueue<String> rawStringQueue, BlockingQueue<String> reversedStringQueue) {
		this.rawStringQueue = rawStringQueue;
		this.reversedStringQueue = reversedStringQueue;
	}
	@Override
	public void  run() {
		
		while(true){
		String str = null;
		try {
			str = rawStringQueue.take();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		StringBuilder sbd = new StringBuilder(str); 
		String revString = sbd.reverse().toString();
		
		try {
			reversedStringQueue.put(revString);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
				
		}
	}

}
