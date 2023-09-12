package com.hcl.withoutframework;

public class StaticConcept {

	String name;
	String address;
	static int i,j;
	static String city,country;
	static {
		j=0;
		city= "Chandigarh";
		country = "India";
	}
	public StaticConcept(String name, String address, String city) {
		this.name = name;
		this.address = address;
		StaticConcept.city = city;
		i++;
		j++;
		System.out.println(i+"  "+j);
		city = "panchkula";
		System.out.println("City Name "+city);
		System.out.println("StaticConcept - City Name "+StaticConcept.city);
	}
	
	public void getAddress() {
		System.out.println(address+" "+city+" "+country);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		StaticConcept obj = new StaticConcept("Bob","Sector 1","Panipat");
		StaticConcept obj1 = new StaticConcept("John","Sector 2","Karnal");
		obj.getAddress();
		obj1.getAddress();
		
	}

}
