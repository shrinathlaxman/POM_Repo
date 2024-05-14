package utilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.mla.base.BaseTest;

public class Listeners extends BaseTest implements ITestListener {

	ExtentReports extent = ExtentReportsManager.getReportObj();
	ExtentTest test;
	WebDriver driver;

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test = extent.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.PASS, "Test Case Pass");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		test.fail(result.getThrowable());
		/*
		 * try { driver=(WebDriver)
		 * result.getTestClass().getRealClass().getField("driver").get(result.
		 * getInstance()); } catch (IllegalArgumentException e) { // TODO Auto-generated
		 * catch block e.printStackTrace(); } catch (IllegalAccessException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); } catch (NoSuchFieldException
		 * e) { // TODO Auto-generated catch block e.printStackTrace(); } catch
		 * (SecurityException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } String filePath = null;
		 * 
		 * 
		 * try { filePath = getScreenShot(result.getMethod().getMethodName(),driver); }
		 * catch (IOException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } test.addScreenCaptureFromPath(filePath,
		 * result.getMethod().getMethodName());
		 */
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();

	}

}
