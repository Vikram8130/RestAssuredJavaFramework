package api.reports;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import api.tests.TestBaseClass;

/**
 * The Class ExtentManager.
 */
public class ExtentManager {

	/** The extent. */
	private static ExtentReports extent;

	/** The folder name. */
	public static String folderName;

	/**
	 * Creates the instance.
	 *
	 * @return the extent reports
	 */
	public static ExtentReports createInstance() {
		String fileName = getReportName();
		folderName = getFolderName();
		String directory = TestBaseClass.cDir + "/test-reports/" + folderName + "/HTMLReports/";
		new File(directory).mkdirs();
		String path = directory + fileName;
		ExtentSparkReporter htmlReporter = new ExtentSparkReporter(path);
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle("API Automation Reports");
		htmlReporter.config().setReportName("API Automation Test Reports");
		htmlReporter.config().setTheme(Theme.DARK);

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Organization", "REQRES");
		extent.setSystemInfo("Test Environment", TestBaseClass.testEnv);
		return extent;
	}

	/**
	 * Gets the report name.
	 *
	 * @return the report name
	 */
	public static String getReportName() {
		Date date = new Date();
		String fileName = "Report_" + date.toString().replace(":", "_").replace(",", "_") + ".html";
		return fileName;
	}

	/**
	 * Gets the folder name.
	 *
	 * @return the folder name
	 */
	public static String getFolderName() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddhhmmss");
		String folderName = "Report_" + formatter.format(date);
		return folderName;

	}

}
