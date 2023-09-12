package com.hcl.testrunner;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hcl.api.endpoints.UserEndPoints;

import io.restassured.response.Response;

public class RestAssuredTest {
	
	int createdUserId = 0;
	
	//GET for https://gorest.co.in/public/v2/users
	
	@Test
	public void createUserFromGoRestAPI() {
		
		UserEndPoints endPoints = new UserEndPoints();
		
		Response res = endPoints.createUser();
		res.then().log().all();
		
		Assert.assertEquals(res.statusCode(), 201);
		
		createdUserId = res.path("id");
		System.out.println("successfully reterived the user id "+createdUserId);
		
		// Extract the user id once we create the user
		
		// Get the user by id
		
		
	}
	
	public void deleteUserByID() {
		
		
		
	}

	
	
}
