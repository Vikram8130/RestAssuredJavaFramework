package api.endpoints;

import static io.restassured.RestAssured.*;

import com.aventstack.extentreports.Status;

import api.payload.UserPayload;
import api.reports.ExtentTestManager;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPoints {


	public static Response getAllUsers() {
		ExtentTestManager.getTest().log(Status.INFO, "getAllUsers API - "+Routes.get_all_users_url);
		return given()
				.when()
					.get(Routes.get_all_users_url);

	}

	public static Response getSingleUser() {
		ExtentTestManager.getTest().log(Status.INFO, "getSingleUser API - "+Routes.get_single_user_url);
		return given()
				.when()
					.get(Routes.get_single_user_url);

	}
	
	public static Response createUser(UserPayload payload) {
		ExtentTestManager.getTest().log(Status.INFO, "createUser API - "+Routes.post_create_user_url);
		ExtentTestManager.getTest().log(Status.INFO, "Username - "+payload.getUsername());
		ExtentTestManager.getTest().log(Status.INFO, "Jobname - "+payload.getJobname());
		return given()
				.contentType(ContentType.JSON) // Set content type to JSON
                .body(payload)
				.when()
					.post(Routes.post_create_user_url);

	}
}
