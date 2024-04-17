package api.test;

import org.testng.annotations.Test;

import api.payload.User;
import api.userendpoints.HttpRequests;
import api.utilities.DataProviders;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TestDDT {
	String id;
	User payload;
	
	@Test(priority=1,dataProvider = "Data", dataProviderClass = DataProviders.class)
	public void setData(String FirstName, String LastName, String UserName, String Location) {
		
		payload=new User();
		
		payload.setFirstname(FirstName);
		payload.setLastname(LastName);
		payload.setUsername(UserName);
		payload.setLocation(Location);
		
	}
	
	@Test(priority=2)
	public void testPostRequest1() {
		
		Response response = HttpRequests.postRequest(payload);
		
		JsonPath jsonpath =response.jsonPath();
		id=jsonpath.get("id").toString();
		System.out.println("generated id is - "+id);
		response.then().log().body();
		response.then().log().all();
		
	}
	
	@Test(priority=3)
	public void testGetRequest1() {
		
		Response response = HttpRequests.getRequest(id);
		response.then().log().all();
		response.then().log().body();
		
		
	}
	
	@Test(priority=4,dataProvider="UserNameData",dataProviderClass=DataProviders.class)
	public void testPutRequest(String UserName) {
		
		payload.setUsername(UserName);
		Response response=HttpRequests.putRequest(id, payload);
		response.then().log().all();
		response.then().log().body();
		
		
	}
	
	@Test(priority=5)
	public void testDeleteRequest() {
		
		Response response =HttpRequests.deleteRequest(id);
		response.then().log().all();
		response.then().log().body();
	}
	
	
	
	
	
	
	
	
	
	
	

}
