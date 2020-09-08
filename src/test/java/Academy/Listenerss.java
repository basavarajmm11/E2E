package Academy;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Acadmy.Base;
import Acadmy.ExtentReportss;

public class Listenerss extends Base implements ITestListener{

	
	ExtentReports extent=ExtentReportss.getReportObject();
	ExtentTest test;
	
	ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();

	
	
	

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) 
	{
		test.fail(result.getThrowable());
		WebDriver driver=null;
		String testMethodName = result.getMethod().getMethodName();
		
		try {
			driver=(WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e1)
		{
		}
		try
		{
			extentTest.get().addScreenCaptureFromPath(getScreenshotPath(testMethodName, driver), result.getMethod().getMethodName());
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extentTest.set(test);
		
	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestStart(ITestResult result) {
		
			test = extent.createTest(result.getMethod().getMethodName());
			extentTest.set(test);
		
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test Passed");
		extentTest.set(test);
		
	}

	public void onFinish(ITestContext context) {
		extent.flush();
		
		
		}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}
}
