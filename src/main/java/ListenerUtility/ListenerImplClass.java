package ListenerUtility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import GenericWebDriverUtility.WebDriverUtility;

public class ListenerImplClass implements ITestListener, ISuiteListener {
	
	
	public void onStart(ISuite suite) {
		System.out.println("Report configuration");
		
	}
	
	public void onFinish(ISuite suite) {
		System.out.println("Report backUP");

	}
	
	public void onTestStart(ITestResult result) {
		//Displays name of the TestCase On console
		System.out.println("======"+ result.getMethod().getMethodName() +"====START====");
		Reporter.log("Execution Done", true);

	}
	public void onTestSuccess(ITestResult result) {
		System.out.println("======"+ result.getMethod().getMethodName()+"====END====");

	}
	
	
	public void onTestFailure(ITestResult result) {
		String TESTNAME =result.getMethod().getMethodName();
		TakesScreenshot ts= (TakesScreenshot)BaseClass.sdriver;
				File temp=ts.getScreenshotAs(OutputType.FILE);
				
		String time		= new Date().toString().replace(' ', '-').replace(':', ' ');
				File trg = new File("./Screenshot/"+TESTNAME+" "+time+".png");
				try {
					FileHandler.copy(temp, trg);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
   }
			
	}

