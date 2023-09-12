package com.hcl.withoutframework;

import java.util.regex.Pattern;

public class StringFunctions {

	static String message = "My Name is Varun. \n I live in Panchkula. \nI am staying in PGI Enclave";
	static String[] stringParts;

	public String[] splitStringExtract(String text, String pattern) {
		stringParts = text.split(Pattern.quote(pattern));
		return stringParts;
		//System.out.println("Original String: "+message.trim());
		//System.out.println("Size of Parts: "+stringParts.length);
		//System.out.println("Extracted String: "+stringParts[0]);
	}

	static String ProductTypes = "Laptops,Phones, Monitors";
	static String Products = "Sony vaio i5: MacBook Pro,	Samsung galaxy s6: Iphone 6 32gb, 	Apple monitor 24";
	static String quantities= "2:3,1:2,3";

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		StringFunctions obj = new StringFunctions();
		obj.splitStringExtract(message, "\n");

		String[] productTyp = obj.splitStringExtract(ProductTypes.trim(), ",");
		String[] productNm = obj.splitStringExtract(Products.trim(), ",");
		String[] quanty = obj.splitStringExtract(quantities.trim(), ",");
		for (int i=0;i<productTyp.length;i++) { 
			System.out.println(productTyp[i].trim());
			String[] prodcts = obj.splitStringExtract(productNm[i], ":");
			String[] productQty = obj.splitStringExtract(quanty[i], ":");
			if(prodcts.length>1) {
				for(int j=0;j<prodcts.length;j++) {
					System.out.println(prodcts[j].trim());
					System.out.println(productQty[j].trim());
				}
			}
			else { 
				System.out.println(prodcts[0].trim());
				System.out.println(productQty[0].trim());
			}
		}
	}
}
