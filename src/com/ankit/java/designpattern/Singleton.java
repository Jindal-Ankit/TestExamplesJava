package com.ankit.java.designpattern;

import java.lang.reflect.ReflectPermission;
import java.security.AccessController;

public class Singleton {

	private static Singleton instance;

	private Singleton() {
		if (subclass.instance != null) {
			throw new IllegalStateException("Illegal Object Creation");
		}
		System.out.println("Singleton Created BY " + Thread.currentThread().getName());
	}
	/*
	 * public static Singleton getSingletonInstance(){ if(instance == null){
	 * instance = new Singleton(); } return instance; }
	 */
	/*
	 * public static synchronized Singleton getSingletonInstance(){ if(instance
	 * == null){ instance = new Singleton(); } return instance; }
	 */

	/*
	 * public static Singleton getSingletonInstance() { if (instance == null) {
	 * synchronized (Singleton.class) { if (instance == null) { instance = new
	 * Singleton(); } } } return instance; }
	 */

	private static class subclass {
		static Singleton instance = new Singleton();
	}

	public static Singleton getSingletonInstance() {
		return subclass.instance;
	}

}
