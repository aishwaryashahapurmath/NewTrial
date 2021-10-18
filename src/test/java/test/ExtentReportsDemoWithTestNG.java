package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportsDemoWithTestNG {
	
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	
	WebDriver driver;
		
	   @BeforeSuite
		public void setUp() {
	        htmlReporter = new ExtentHtmlReporter("extent.html");
	        extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);
	        }
	   
	   @BeforeTest
		public void setUpTest() {
			
			String projectPath = System.getProperty("user.dir");
			System.setProperty("webdriver.chrome.driver", projectPath+ "/drivers/chromedriver/chromedriver.exe");
			driver = new ChromeDriver();
		}
		
	   @Test
		public void test1() throws Exception {
		   
		   
		   ExtentTest test = extent.createTest("MyFirstTest", "Sample description");
		   driver.get("https://google.com");
		   test.pass("Navigated to google.com");
		   
		   // log(Status, details)
	        test.log(Status.INFO, "This step shows usage of log(status, details)");
	        // info(details)
	        test.info("This step shows usage of info(details)");
	        
	        // log with snapshot
	        test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
	        
	        // test with snapshot
	        test.addScreenCaptureFromPath("screenshot.png");
			
		}
	   
	   @Test
		public void test2() throws Exception {
		   ExtentTest test1 = extent.createTest("MyFirstTest", "Sample description");
		   
		   // log(Status, details)
	        test1.log(Status.INFO, "This step shows usage of log(status, details)");
	        // info(details)
	        test1.info("This step shows usage of info(details)");
	        
	        // log with snapshot
	        test1.pass("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
	        
	        // test with snapshot
	        test1.addScreenCaptureFromPath("screenshot.png");
			}
	   
	   @AfterTest
		public void tearDownTest() {
			//close browser
			driver.close();
			driver.quit();
					
			System.out.println("Test Completed Successfully");
					
			
		}
	   
		@AfterSuite
		public void tearDemo() {
			
			// calling flush writes everything to the log file
	        extent.flush();
		}

	}

	
