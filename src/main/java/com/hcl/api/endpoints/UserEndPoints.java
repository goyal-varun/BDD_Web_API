package com.hcl.api.endpoints;

import static io.restassured.RestAssured.given;

import com.github.javafaker.Faker;
import com.hcl.api.pojo.UserData;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPoints {
	
	Response response = null;
	static String usersBaseURI = "https://gorest.co.in";
	static String usersEndPoint = "/public/v2/users";
	static String usersBearerToken = "Bearer 9f33a2e244d16558635ca44c9ad37489ee30140c73e0af602a2ba11edfe8063d";
	
	public Response createUser() {
		// POST request

		//File jsonData = new File("sample.json");
		
		Faker fakeData = new Faker();
		
		UserData dataVals = new UserData();
		dataVals.setEmail(fakeData.internet().emailAddress());
		dataVals.setGender("male");
		dataVals.setName(fakeData.name().fullName());
		dataVals.setStatus("active");

		response =	given()
						.header("Content-Type", ContentType.JSON).header("Authorization", usersBearerToken)
						.body(dataVals)
						.baseUri(usersBaseURI)
					.when()
						.post(usersEndPoint);
		
		return response;
	}

}
