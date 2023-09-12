package com.hcl.baseframework;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.util.Map;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ApiUtils {
	
	static String baseURI = "https://gorest.co.in";
	//static String usersEndPoint = "/public/v2/users";
	static String bearerToken = "Bearer 9f33a2e244d16558635ca44c9ad37489ee30140c73e0af602a2ba11edfe8063d";

	public static Response invokeGETRequest(String endPoint) {
		Response response = given()
				.header("Authorization", bearerToken)
				.baseUri(baseURI)
				.when().get(endPoint);

		return response;
	}

	public static Response invokePOSTRequest(String endPoint, Map<String, String> data) {

		Response response = given().header("Content-Type", ContentType.JSON)
				.header("Authorization", bearerToken)
				.body(data)
				.baseUri(baseURI)

				.when().post(endPoint);

		return response;

	}

	public Response invokePOSTRequest(File data) {

		Response response = given().header("Content-Type", ContentType.JSON)
				.header("Authorization", "Bearer 9f33a2e244d16558635ca44c9ad37489ee30140c73e0af602a2ba11edfe8063d")
				.body(data)

				.when().post("https://gorest.co.in/public/v2/users");

		return response;

	}
}
