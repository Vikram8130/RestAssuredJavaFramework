package api.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.github.javafaker.Faker;
import api.endpoints.UserEndPoints;
import api.payload.UserPayload;
import api.reports.ExtentTestManager;
import io.restassured.response.Response;

public class UserTests {
	
	Faker faker;
	UserPayload userPayload;
	
	@BeforeClass
	public void setupData(){
		
		faker =new Faker();
		userPayload=new UserPayload();
		
		userPayload.setUsername(faker.name().username());
		userPayload.setJobname(faker.name().title());
		
	}
	
	
	@Test(priority=1)
	public void testGetAllUsers() {
		ExtentTestManager.getTest().log(Status.INFO, "Test Case Name - "+"GetAllUsers");
		Response response = UserEndPoints.getAllUsers();
		response.then().log().all();
		ExtentTestManager.getTest().log(Status.INFO, "API response code - "+response.getStatusCode());
		ExtentTestManager.getTest().log(Status.INFO, "API response StatusLine- "+response.getStatusLine());
		ExtentTestManager.getTest().log(Status.INFO, "API response Body- "+response.getBody().asPrettyString());
		Assert.assertEquals(response.getStatusCode(), 200);
		ExtentTestManager.getTest().log(Status.PASS, "API response is as expected");
	}
	
	@Test(priority=2)
	public void testGetSingleUser() {
		ExtentTestManager.getTest().log(Status.INFO, "Test Case Name - "+"GetSingleUser");
		Response response = UserEndPoints.getSingleUser();
		response.then().log().all();
		ExtentTestManager.getTest().log(Status.INFO, "API response code - "+response.getStatusCode());
		ExtentTestManager.getTest().log(Status.INFO, "API response StatusLine- "+response.getStatusLine());
		ExtentTestManager.getTest().log(Status.INFO, "API response Body- "+response.getBody().asPrettyString());
		Assert.assertEquals(response.getStatusCode(), 200);
		ExtentTestManager.getTest().log(Status.PASS, "API response is as expected");
	}
	
	@Test(priority=3)
	public void testPostCreateUser() {
		ExtentTestManager.getTest().log(Status.INFO, "Test Case Name - "+"PostCreateUser");
		Response response = UserEndPoints.createUser(userPayload);
		response.then().log().all();
		ExtentTestManager.getTest().log(Status.INFO, "API response code - "+response.getStatusCode());
		ExtentTestManager.getTest().log(Status.INFO, "API response StatusLine- "+response.getStatusLine());
		ExtentTestManager.getTest().log(Status.INFO, "API response Body- "+response.getBody().asPrettyString());
		Assert.assertEquals(response.getStatusCode(), 201);
		ExtentTestManager.getTest().log(Status.PASS, "API response is as expected");
	}
	
	

}
