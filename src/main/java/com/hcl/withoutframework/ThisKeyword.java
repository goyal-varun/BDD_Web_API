package com.hcl.withoutframework;

public class ThisKeyword {

	int a = 0;
	
	public ThisKeyword(int a) {
		this.a = a;
	}
	
	public void getData() {
		//int a= 2;
		System.out.println(a);
		System.out.println(this.a);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ThisKeyword obj = new ThisKeyword(3);
		obj.getData();
	}

}
