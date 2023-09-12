package com.hcl.withoutframework;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hcl.api.pojo.UserData;
import com.hcl.baseframework.ApiUtils;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RestAssuredTest {

	// GET for https://gorest.co.in/public/v2/users

	@Test(priority=1, enabled=false)
	public void getUsersViaToken() {
		Response res = ApiUtils.invokeGETRequest("/public/v2/users");
		
		Assert.assertEquals(res.statusCode(), 200);
		Assert.assertEquals(res.body().jsonPath().getInt("id"), "test");
			
	}
	
	@Test(priority=0)
	public void createUserViaToken() {
		// Request body - POST
		
		/*
		// HashMap
		HashMap<String, String> data = new HashMap<String, String>();
		
		data.put("name", "varun12345");
		data.put("gender", "male");
		data.put("email", "v.12345@gmail.com");
		data.put("status", "active");
		*/
		
		// Using pojo
		// Load the user data for POST request
		UserData data = new UserData();
		
		data.setName("varun123454");
		data.setGender("male");
		data.setEmail("v.123456@gmail.com");
		data.setStatus("active");
		
		System.out.println(data.name);
		
		given()
			.header("Content-Type", ContentType.JSON)
			.header("Authorization", "Bearer 9f33a2e244d16558635ca44c9ad37489ee30140c73e0af602a2ba11edfe8063d")
			.body(data)
		
		.when()
			.post("https://gorest.co.in/public/v2/users")
			
		.then()
			.log().all()
			.statusCode(201)
			.body("message[0]", equalTo("has already been taken"));
		
	}

}
