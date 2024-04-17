package api.userendpoints;

import static io.restassured.RestAssured.given;

import api.payload.User;
import api.test.Tests;
import io.restassured.response.Response;

public class HttpRequests{
	
	public static Response postRequest(User payload) {
		
		Response response =
		given()
			.body(payload)
			.when()
				.post(Routes.post_url);
		
		return response;
		
	}
	
	public static Response getRequest(String id) {
		
		Response response=
		given()
			.pathParam("id", id)
		.when()
			.get(Routes.get_url);
		
		return response;
		
	}
	
	
	public static Response putRequest(String id, User payload) {
		Response response =
		given()
			.pathParam("id", id)
			.body(payload)
		.when()
			.put(Routes.put_url);
		return response;
	}
	
	public static Response deleteRequest(String id) {
		Response response =
		given()
			.pathParam("id", id)
			.when()
			.delete(Routes.delete_url);
		return response;
	}
	
	

}
