package com.hcl.withoutframework;

/**
 * @author gvaru
 *
 */
public class ChildDemoClass extends ParentDemoClass {

	String name = "Class - Variable ** Child Class **";
	int a;
	//ParentDemoClass pdd = new ParentDemoClass();
	
	
	  public ChildDemoClass() { 
		  super("Varun"); 
		  System.out.println(super.name +" ** called in constructor **");
		  System.out.println("Child Class Constructor"); }
	 
	
	public ChildDemoClass(String str) {
		super("Varun");
		//System.out.println(super.name + " ** called in constructor **");
		System.out.println("Child Class Constructor -> "+str);
	}
	  
	  public void getData() {
	  
	  // System.out.println(super.name); String name = "name - Child Class";
	  
	  // super.getData(); System.out.println(super.name); System.out.println(name);
	  
	  }
	 

	public void getThisData() {
		int a = 3;
		String name = "Method - Variable ** Child Class **";
		
		System.out.println("\n\n'this' keyword implementation");
		System.out.println("-----------------------------");
		
		
		System.out.println(name);
		System.out.println(this.name);
		System.out.println(a);		// 3
		this.a = a;
		System.out.println(this.a);	// 2
		//System.out.println(super.name);
	}

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ChildDemoClass cd;
		System.out.println("Im in Main");
		cd = new ChildDemoClass();
		//cd.getData();
		
		//cd.getThisData();

		// ParentDemoClass pdc = new ChildDemoClass(); //pdc.getData();

		//ParentDemoClass pdd = new ParentDemoClass();
		//pdd.getData();
	}

}
