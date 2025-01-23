import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListenerClass extends Checkbox implements ITestListener{
	

	  public void onTestStart(ITestResult result) {
		   System.out.println("Test started");
		  }
	  public void onTestSuccess(ITestResult result) {
		  System.out.println("Successful");
	  }
	  public void onTestFailure(ITestResult result) {
		  System.out.println("Failure");
		  try {
			  UtilityClass.getMeScreenshot(driver);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  
		  
		  }
	  public void onTestSkipped(ITestResult result) {
		  System.out.println("Skipped");
		  }
	  public void onStart(ITestContext context) {
		  System.out.println("Started");
		  }
	  public void onFinish(ITestContext context) {
		  System.out.println("Finished");
		  }
}
