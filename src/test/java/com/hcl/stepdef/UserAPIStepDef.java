package com.hcl.stepdef;

import org.testng.Assert;

import com.hcl.api.endpoints.UserEndPoints;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class UserAPIStepDef {
	
	Response response = null;
	int createdUserId = 0;
	
	@When("User send the post api for creating the user")
	public void user_send_the_post_api_for_creating_the_user() {
		UserEndPoints endPoints = new UserEndPoints();
		
		response = endPoints.createUser();
		response.then().log().all();
	}

	@Then("validate the response is {int}")
	public void validate_the_response_is(Integer int1) {
		Assert.assertEquals(response.statusCode(), 201);
		
		createdUserId = response.path("id");
		System.out.println("successfully reterived the user id "+createdUserId);
	}
	

}
