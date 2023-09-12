package com.hcl.withoutframework;

import org.testng.Assert;

public class StringCompare {

	public void compare() {
		String str1 = "SignaUp";
		String str2 = "SignIn";
		if(str1.compareTo(str2) >0) 
			System.out.println("Strings displayed in sorted order: \n"+str2+"\n"+str1);
		else
			System.out.println("Strings displayed in sorted order: \n"+str1+"\n"+str2);
	
		Assert.assertEquals(str1, str2);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		StringCompare obj = new StringCompare();
		obj.compare();
	}

}
