package com.ankit.practice.problems;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.concurrent.BlockingQueue;

public class EncoderThread implements Runnable{
	private BlockingQueue<String> reversedStringQueue;	
	private Writer writer ;
	public EncoderThread(BlockingQueue<String> reversedStringQueue, String filePath) {
		this.reversedStringQueue = reversedStringQueue;
		try {
			writer = new BufferedWriter(new FileWriter(filePath, true));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		while(true){
			String reversedStr = null;;
			try {
				reversedStr = reversedStringQueue.take();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			Encoder encoder = Base64.getEncoder();
			String encoded = encoder.encodeToString(reversedStr.getBytes());
			try {
				writer.write(encoded + System.lineSeparator());
				
				writer.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
/*	private void saveToFile(String str){
		
	}
*/
}
