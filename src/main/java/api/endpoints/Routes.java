package api.endpoints;

import api.tests.TestBaseClass;
import api.utility.ConfigDataJsonParser;
import api.utility.PropertyConfig;

public class Routes{
	
	static PropertyConfig propsUserRoutes = new PropertyConfig(
			ConfigDataJsonParser.getTestData("$.endpoint-config.testProperty.routes.fileName"),
			ConfigDataJsonParser.getTestData("$.endpoint-config.testProperty.routes.filePath"));

	
	
	static String baseUrl=ConfigDataJsonParser.getTestData("$.environment-config." + TestBaseClass.testEnv + ".base_url");
	
	
	//User module
	public static String get_all_users_url=baseUrl+propsUserRoutes.getPropertyValue("Get_All_Users");
	public static String get_single_user_url=baseUrl+propsUserRoutes.getPropertyValue("Get_Single_User");
	public static String post_create_user_url=baseUrl+propsUserRoutes.getPropertyValue("Post_Create_User");
	
	//
	
	
	
	//
	
	
	//
	

}
