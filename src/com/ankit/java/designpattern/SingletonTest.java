package com.ankit.java.designpattern;

import static org.junit.Assert.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

import org.junit.Test;

public class SingletonTest {

	
	@Test
	public void testSimple() {
		Singleton obj1 = Singleton.getSingletonInstance();
		Singleton obj2 = Singleton.getSingletonInstance();
		assertTrue(obj1 == obj2);

	}

	@Test
	public void testWithThread() throws InterruptedException, ExecutionException {
		boolean sameAll = false;
		// Thread th1 = new Thread(createSingleton);
		ExecutorService threadPool = Executors.newFixedThreadPool(4);
		Set<Future<Singleton>> futureSet = new HashSet<Future<Singleton>>();
		for (int i = 0; i < 10; i++) {
			Callable<Singleton> createSingleton = new CreateSingleton();
			Future<Singleton> future = threadPool.submit(createSingleton);
			futureSet.add(future);
		}
		Iterator<Future<Singleton>> itr = futureSet.iterator();

		Singleton singletonLast = itr.next().get();
		while (itr.hasNext()) {
			Future<Singleton> future = (Future<Singleton>) itr.next();
			Singleton singleton = future.get();
			sameAll = singletonLast == singleton;
			if (sameAll == false)
				break;
		}
		threadPool.shutdown();
		assertTrue(sameAll);
	}
	
	@Test
	public void testWithReflection() throws InstantiationException, IllegalAccessException {
		Constructor<Singleton>[] arr = (Constructor<Singleton>[]) Singleton.class.getDeclaredConstructors();
		
		Constructor constr = arr[0];
		constr.setAccessible(true);
		Singleton singl1 = null;
		String error = "Illegal Object Creation";
		String msg = null;
		try {
			singl1 = (Singleton) constr.newInstance();
		} catch (InvocationTargetException e){
			msg = e.getTargetException().getMessage();
		}
		/*for (Constructor constructor : arr) {
			System.out.println(constructor);
		}*/
		Singleton singl2 = Singleton.getSingletonInstance();
		//System.out.println(singl1);
		System.out.println(singl2);
		assertTrue(error.equals(msg) || singl1 == singl2);

	}

	private class CreateSingleton implements Callable<Singleton> {

		@Override
		public Singleton call() throws Exception {
			Singleton instance = Singleton.getSingletonInstance();
			return instance;
		}
	}
}
