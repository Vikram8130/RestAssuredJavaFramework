package api.testexecute;

import java.util.List;

import org.testng.TestNG;
import org.testng.collections.Lists;

import api.tests.TestBaseClass;
import api.utility.ConfigDataJsonParser;

public class TestSuiteRunner {

	public static void main(String[] args) {
		try {
			
			String xmlPath = ConfigDataJsonParser.getTestData("$.endpoint-config.testNgxml");
			TestNG testNg= new TestNG();
			List<String> suite = Lists.newArrayList();
			suite.add(TestBaseClass.cDir+xmlPath);
			//testNg.setUseDefaultListeners(false);
			testNg.setTestSuites(suite);
			testNg.run();
		}catch(Exception ex) {
			
			ex.printStackTrace();
		}

	}

}
