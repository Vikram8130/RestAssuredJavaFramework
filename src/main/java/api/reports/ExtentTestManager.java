package api.reports;

import java.util.HashMap;
import java.util.Map;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

/**
 * The Class ExtentTestManager.
 */
public class ExtentTestManager {
	
	/** The extent. */
	static ExtentReports extent = ExtentManager.createInstance();
	
	/** The extent test map. */
	static Map<Integer, ExtentTest> extentTestMap = new HashMap<Integer, ExtentTest>();
	
	/**
	 * Gets the test.
	 *
	 * @return the test
	 */
	public static synchronized ExtentTest getTest() {
		return (ExtentTest) extentTestMap.get((int) (long) (Thread.currentThread().getId()));
	}


	 
	/**
	 * End test.
	 */
	public static synchronized void endTest() {
		if(extent!=null) {
		extent.flush();
		}
	}
	
	

	/**
	 * Start test.
	 *
	 * @param testName the test name
	 * @return the extent test
	 */
	public static synchronized ExtentTest startTest(String testName) {
		ExtentTest test = extent.createTest(testName);
		extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);
		return test;
	}

}
