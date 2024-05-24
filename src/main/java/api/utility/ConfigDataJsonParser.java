package api.utility;

import java.io.File;

import com.jayway.jsonpath.JsonPath;

public class ConfigDataJsonParser {

	
	public static File jsonFile = new File(
			"../RestAssuredJavaFramework/src/main/resources/config/restProject-config-data.json");

	
	public static String getTestData(String jsonPath) {
		String testDataProperty = null;
		try {
			testDataProperty = JsonPath.read(jsonFile, jsonPath).toString();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return testDataProperty;
	}
	
}
