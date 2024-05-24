package api.reports;

import java.util.Arrays;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

/**
 * The Class TestListeners.
 */
public class TestListeners implements ITestListener {


	/*
	 * @see org.testng.ITestListener#onTestStart(org.testng.ITestResult)
	 */
	@Override
	public void onTestStart(ITestResult result) {
		String className = result.getTestClass().getName();
		String[] classArray = className.split("\\.");

		ExtentTestManager.startTest(classArray[classArray.length - 1] + " :: " + result.getMethod().getMethodName());
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.testng.ITestListener#onTestSuccess(org.testng.ITestResult)
	 */
	@Override
	public void onTestSuccess(ITestResult result) {
		String logText = "<b>Test Method " + result.getMethod().getMethodName() + " Successful</b>";
		Markup markup = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		ExtentTestManager.getTest().log(Status.PASS, markup);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.testng.ITestListener#onTestFailure(org.testng.ITestResult)
	 */
	@Override
	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		String exceptionHeading = result.getThrowable().getMessage();
		String exceptionMessage = Arrays.toString(result.getThrowable().getStackTrace());
		ExtentTestManager.getTest().fail("<details><summary><b><font color=red>" + "Execption Occured, click to see the details:"+ "</font></b></summary>" + exceptionHeading + "<br>" + exceptionMessage.replace(",", "<br>")+ "</details> \n");
		String logText = "<b>Test Method " + methodName + " Failed</b>";
		Markup markup = MarkupHelper.createLabel(logText, ExtentColor.RED);
		ExtentTestManager.getTest().log(Status.FAIL, markup);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.testng.ITestListener#onTestSkipped(org.testng.ITestResult)
	 */
	@Override
	public void onTestSkipped(ITestResult result) {
		String logText = "<b>Test Method " + result.getMethod().getMethodName() + " Skipped</b>";
		Markup markup = MarkupHelper.createLabel(logText, ExtentColor.AMBER);
		ExtentTestManager.getTest().log(Status.SKIP, markup);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.testng.ITestListener#onTestFailedButWithinSuccessPercentage(org.testng.
	 * ITestResult)
	 */
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.testng.ITestListener#onStart(org.testng.ITestContext)
	 */
	@Override
	public void onStart(ITestContext context) {

		System.out.println("Test Suite started");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.testng.ITestListener#onFinish(org.testng.ITestContext)
	 */
	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Test Suite ended");
		ExtentTestManager.endTest();

	}

}