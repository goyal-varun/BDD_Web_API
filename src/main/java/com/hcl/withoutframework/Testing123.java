package com.hcl.withoutframework;

public class Testing123 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str = "Backup session 23/45 6 started";
		
		String sub = str.substring(str.indexOf(" 23"), str.indexOf(" started"));
		String name = "Varun";
		System.out.println(sub);
		System.out.println(" "+name+" ");
	}
}
