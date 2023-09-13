package com.hcl.api.endpoints;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.util.HashMap;

import org.json.JSONObject;

import com.github.javafaker.Faker;
import com.hcl.api.pojo.StudentData;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class StudentsEndPoints {

	Response response = null;
	String studentsBaseURI = "http://localhost:3000";
	String studentsEndpoint = "/students";

	public Response getStudentRequest() {

		response = 	given()
						.baseUri(studentsBaseURI)
						.get(studentsEndpoint);

		response.then()
					.log()
					.body();

		return response;
	}

	public void postStudentRequest() {

		StudentData data = new StudentData();
		// HashMap<String, Comparable> body = new HashMap<String, Comparable>();
		String[] courses = new String[2];
		Faker fakeData = new Faker();
		// File jsonfile = new File("D:\\Automation\\Selenium Course\\REST
		// API\\PayLoad.json");

		data.setId(fakeData.number().numberBetween(1, 1000));
		data.setName(fakeData.name().firstName());
		courses[0] = "Python " + Integer.toString(fakeData.number().numberBetween(10, 100));
		courses[1] = "Java " + Integer.toString(fakeData.number().numberBetween(10, 100));
		data.setCourses(courses);

		System.out.println("POST Body Student ID: "+data.getId());
		
		response =  given()
						.header("Content-Type", ContentType.JSON)
						.baseUri(studentsBaseURI)
						.body(data)
					.when()
						.post(studentsEndpoint);
					//.then()
					//	.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("createStudentJsonSchema.json"));
		//.body(JsonSchemaValidator.matchesJsonSchema(new File("src/test/resources/createStudentJsonSchema.json")));
		response.then().log().body();
		
		JSONObject responseJ = new JSONObject(response.asString());
        System.out.println("response json " + responseJ);



		//return response;
	}

	public Response putStudentRequest() {

		HashMap<String, Comparable> body = new HashMap<String, Comparable>();
		// File jsonfile = new File("payLoad.json");
		StudentData data = new StudentData();
		// HashMap<String, Comparable> body = new HashMap<String, Comparable>();
		String[] courses = new String[2];

		data.setId(2);
		data.setName("Rana Naidu");
		courses[0] = "Python 2";
		courses[1] = "Java 2";
		data.setCourses(courses);

		response = 	given()
						.header("Content-Type", ContentType.JSON)
						.baseUri(studentsBaseURI)
						.body(data)
						.pathParam("id", 5)
					.when()
						.put(studentsEndpoint + "/{id}");

		response.then().log().body();

		return response;
	}

}
