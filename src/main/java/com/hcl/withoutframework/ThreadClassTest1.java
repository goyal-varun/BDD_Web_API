package com.hcl.withoutframework;

public class ThreadClassTest1 {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ThreadClassTest.getValue();
		//ThreadClassTest.threadLocal.get();
		//System.out.println(ThreadClassTest.threadLocal.get());
		//System.out.println(ThreadClassTest.threadLocalValue);
		
		ThreadClassTest2 threadClassTest2 = new ThreadClassTest2();
		threadClassTest2.ThreadValue();
	}

}
