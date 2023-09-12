package com.hcl.withoutframework;

public class ThreadClassTest {

	public static ThreadLocal<String> threadLocal = new ThreadLocal<String>();
	public static String  threadLocalValue = "Varun";
	
	public static void getValue() {
		threadLocal.set("Hello ThreadLocal");
		//System.out.println("Thread ID: "+Thread.currentThread().getId());
		//System.out.println(" "+threadLocal.get());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		

		//set thread-local value
		threadLocal.set("Hello ThreadLocal");
		System.out.println("Thread ID: "+Thread.currentThread().getId());
		System.out.println(" "+threadLocal.get());
		
		threadLocal.set("Hello ThreadLocal");
		System.out.println("Thread ID: "+Thread.currentThread().getId());
		System.out.println(" "+threadLocal.get());

		//get thread-local value
		threadLocalValue = threadLocal.get();

		threadLocal.set(threadLocalValue);
		
		//remove thread-local value for the current thread
//		threadLocal.remove();
		
		 
	}

}
