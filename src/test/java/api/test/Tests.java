package api.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.payload.User;
import api.userendpoints.HttpRequests;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Tests {
	String id;
	Faker faker;
	User payload;
	
	@BeforeClass
	public void setData() {
		
		faker = new Faker();
		payload = new User();
		
		payload.setFirstname(faker.name().firstName());
		payload.setLastname(faker.name().lastName());
		payload.setUsername(faker.name().username());
		payload.setLocation(faker.name().title());
		
		
	}
	
	@Test(priority=1)
	public void testPostRequest() {
		
		Response response=HttpRequests.postRequest(payload);
		JsonPath jsonPath = response.jsonPath();
	    id = jsonPath.get("id").toString();
	    System.out.println("id is - " + id);
	    response.then().log().all();
		
		
		
	}
	
	@Test(priority=2)
	public void testGetRequest() {
		
		Response response =HttpRequests.getRequest(id);
		response.then().log().body();
		response.then().log().all();
		
	}
	
	@Test(priority=3)
	public void testPutRequest() {
		payload.setFirstname(faker.name().firstName());
		payload.setLastname(faker.name().lastName());
		
		Response response =HttpRequests.putRequest(id, payload);
		response.then().log().body();
		response.then().log().all();
	}
	
	@Test(priority=4)
	public void testDelete() {
		
		Response response=HttpRequests.deleteRequest(id);
		response.then().log().body();
		response.then().log().all();		
	}
	
	
	
	
	
	
	
	
	
	
	

}
