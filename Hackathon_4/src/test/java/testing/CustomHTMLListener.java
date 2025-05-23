package testing;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import util.ScreenShot;

public class CustomHTMLListener implements ITestListener{
	public  ExtentSparkReporter htmlreporter;
	public  ExtentReports extent;
	public 	ExtentTest test;
	
	  public void onFinish(ITestContext context) {
	    extent.flush();
	  }
	  
	  public void onStart(ITestContext context) {
		  htmlreporter = new ExtentSparkReporter(System.getProperty("user.dir")+"\\report\\Reports.html");
		  extent = new ExtentReports();
		  extent.attachReporter(htmlreporter);
		  
		  htmlreporter.config().setDocumentTitle("Coursera Automation");
		  htmlreporter.config().setReportName("Automation Report");
	      htmlreporter.config().setTheme(Theme.DARK);
		  extent.setSystemInfo("Computer Name","Local Host");
		  extent.setSystemInfo("Environment","QA");
		  extent.setSystemInfo("Tester Name","Sowmiya");
		  extent.setSystemInfo("os","Windows10");
		  extent.setSystemInfo("Browser","Edge");
	  }
	  
	  public void onTestSuccess(ITestResult result) {
	      test = extent.createTest(result.getName());
	      test.log(Status.PASS , "Test case passed results : "+result.getName());
	      
	      
		  test.info("Test Completed");
	  }
	  
	  public void onTestFailure(ITestResult result) {
		  test = extent.createTest(result.getName());
		  test.log(Status.FAIL, "Test case failed results : "+result.getThrowable());
		  
		  ScreenShot.takeScreenshot(result.getName());
		  test.info("Test interrupted");
	  }
 
	  public void onTestSkipped(ITestResult result) {
			  test = extent.createTest(result.getName());
			  test.log(Status.SKIP, "Test case skipped results : "+result.getName());
		  test.info("Test skipped");
	  }
}
