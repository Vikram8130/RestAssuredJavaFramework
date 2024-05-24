package api.tests;


import api.utility.ConfigDataJsonParser;

public class TestBaseClass {
	
	//Getting test environment value from config file
	public static String testEnv = ConfigDataJsonParser.getTestData("$.endpoint-config.testEnvironment").toLowerCase();
	
	//Getting test environment value from environment variable
	//public static String testEnv = System.getProperty("env");
		
	
	// Getting Current Working directory
	public static String cDir = System.getProperty("user.dir");

}
