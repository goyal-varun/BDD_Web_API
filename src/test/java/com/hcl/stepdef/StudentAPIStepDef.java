package com.hcl.stepdef;

import org.testng.Assert;

import com.hcl.api.endpoints.StudentsEndPoints;
import com.hcl.api.endpoints.UserEndPoints;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class StudentAPIStepDef {
	
	Response response = null;
	int studentId = 0;
	StudentsEndPoints endPoints = null;
	
	@When("User send the GET api to fetch the student details")
	public void user_send_the_GET_api_to_fetch_the_student_details() {
		
		endPoints = new StudentsEndPoints();
		response = endPoints.getStudentRequest();
	}

	@Then("validate the student response is {int}")
	public void validate_the_student_response (Integer Code) {
		Assert.assertEquals((Integer)response.statusCode(), Code);
		
		//studentId = response.path("id");
		//System.out.println("successfully reterived the user id "+studentId);
	}
	
	@When("User send the POST api to add the student details")
	public void user_send_the_POST_api_to_add_the_student_details() {
		endPoints = new StudentsEndPoints();
		endPoints.postStudentRequest();
	}
	
	
	@When("User send the PUT api to update the student details")
	public void User_send_the_put_api_to_update_the_student_details() {
		endPoints = new StudentsEndPoints();
		response = endPoints.putStudentRequest();
	}

}
