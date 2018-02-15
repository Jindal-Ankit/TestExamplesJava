package com.ankit.practice.problems;

import java.io.Console;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ReverseEncodeSave {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String filePath = "C:/BT/learning_projects/Test/encodedStrings.txt";
		
		BlockingQueue<String> rawStringQueue = new ArrayBlockingQueue<String>(1000);
		BlockingQueue<String> reversedStringQueue = new ArrayBlockingQueue<String>(1000);
		
		Runnable stringRevTh = new StringreverseThread(rawStringQueue, reversedStringQueue);
		Runnable encoderSave = new EncoderThread(reversedStringQueue, filePath);
		
		
		Thread stringRevThread = new Thread(stringRevTh);
		Thread stringRevThread2 = new Thread(stringRevTh);
		
		Thread encoderSStringSaveThead = new Thread(encoderSave);
		 new Thread(encoderSave).start();;
		
		stringRevThread.start();
		encoderSStringSaveThead.start();
		
		// Reading string from console
		while(true) {
			String str = sc.nextLine();
			try {
				rawStringQueue.put(str);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	
		
	}

}
