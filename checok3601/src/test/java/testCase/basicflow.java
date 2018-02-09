package testCase;

import static org.testng.Assert.assertTrue;

import stages.dataentry;
import stages.deQC;
import pages.Address;
import pages.Court;
import pages.Credit;
import pages.Criminal;
import pages.DataBase;
import pages.Education;
import pages.Employement;
import pages.Id;
import pages.Reference;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utility.locators;

public class basicflow {
	public String caseno = "123000013";
	public String name = "gopinathN";
	WebDriver driver;
	deQC qc;
	dataentry dentry;
	ExtentReports extent;
	ExtentTest logger;
	

	@BeforeTest
	public void start() {
		extent = new ExtentReports ("/home/ganesh/git/checok3601/reports/STMExtentReport.html", true);
		extent
        .addSystemInfo("Host Name", "check360")
        .addSystemInfo("Environment", "Automation Testing")
        .addSystemInfo("User Name", "gopinath N");
		System.setProperty("webdriver.firefox.marionette", "/home/ganesh/Desktop/gopinath/driver/geckodriver");
		  extent.loadConfig(new File("/home/ganesh/git/checok3601/reports/extent-config.xml"));
		  logger = extent.startTest("start");
		driver = new FirefoxDriver();
		logger.log(LogStatus.PASS, "browser starting");
		driver.get("http://192.168.2.17:99/Login.aspx");
		logger.log(LogStatus.PASS, "application starting");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
// ********************login page*******************************
	@Test(enabled = true, priority = 1)
	public void login() throws InterruptedException {
		logger = extent.startTest("login");
		logger.log(LogStatus.PASS, "logging in");
		driver.findElement(By.id(locators.Uname)).sendKeys("gopi");
		driver.findElement(By.id(locators.pass)).sendKeys("gopi$123");
		driver.findElement(By.id(locators.button)).click();
		Thread.sleep(500);
		boolean result = driver.findElement(By.id("ctl00_hlnkPasswordChange")).isDisplayed();
		
		assertTrue(result, "login failed check login details");
		logger.log(LogStatus.PASS, "login successfull");

	}
// ******************data entry qc *********************************
	@Test(enabled = false, priority = 2, dependsOnMethods = "login")
	public void dataentryqc() throws InterruptedException {
		qc = new deQC(driver);
		qc.dataentryQC(caseno, name);
		Thread.sleep(1000);

	}
//  **************************** data entry*********************
	@Test(enabled = true, priority = 3)
	public void dataentry() throws InterruptedException {
		logger = extent.startTest("dataentry");
		logger.log(LogStatus.PASS, "moves to data entry");
		dentry = new dataentry(driver);
		dentry.entry(caseno);
		List<String> Listcheck = new ArrayList<String>();
		logger.log(LogStatus.PASS, "getting all checks");
		Listcheck = dentry.getallchecks();
		// driver.findElement(By.xpath("//*[text()='"+Listcheck.get(0)+"']")).click();
		List<WebElement> ele = driver.findElements(By.tagName("iframe"));
	    System.out.println("Number of frames in a page :" + ele.size());
	    for(int i=0;i<ele.size();i++){
	        String na = ele.get(i).getAttribute("src");
	        	 System.out.println("the source "+i+ ":"+ na);
	    }
	    driver.switchTo().defaultContent();
	    Thread.sleep(500);
	    System.out.println("check data : "+Listcheck);
	    
	    
	    //********* swiching address frame************************
	    
	    
	    for (int i = 0; i < Listcheck.size(); i++) {
			switch (Listcheck.get(i)) {
			case "Address":
				logger.log(LogStatus.PASS, "Address Check started");
				Address.click(driver);
				logger.log(LogStatus.PASS, "Address Check Passed");
				break;
			case "Education":
				// for selecting education type
				logger.log(LogStatus.PASS, "Education Check started");
				Education.click(driver);
				logger.log(LogStatus.PASS, "Education Check Passed");
				break;
			case "Employment":
				logger.log(LogStatus.PASS, "Employment Check started");
				Employement.click(driver);
				logger.log(LogStatus.PASS, "Employment Check Passed");
				break;
			case "Reference":
				logger.log(LogStatus.PASS, "Reference Check started");
				Reference.click(driver);
				logger.log(LogStatus.PASS, "Reference Check Passed");
				break;
			case "DataBase":
				logger.log(LogStatus.PASS, "DataBase Check started");
				DataBase.click(driver);
				logger.log(LogStatus.PASS, "DataBase Check Passed");
				break;
			case "Criminal":
				logger.log(LogStatus.PASS, "Criminal Check started");
				Criminal.click(driver);
				logger.log(LogStatus.PASS, "Address Check Passed");
				break;
			case "Credit":
				logger.log(LogStatus.PASS, "Credit Check started");
				Credit.click(driver);
				logger.log(LogStatus.PASS, "Credit Check Passed");
				break;
			case "Court":
				logger.log(LogStatus.PASS, "Court Check started");
				Court.click(driver);
				logger.log(LogStatus.PASS, "Court Check Passed");
				break;
			case "ID":
				logger.log(LogStatus.PASS, "Id Check started");
				Id.click(driver);
				logger.log(LogStatus.PASS, "Id Check Passed");
				break;
			default:
				break;
			}
		}
	    
	}
	@AfterTest
	public void close() throws InterruptedException {
		Thread.sleep(6000);
		  extent.flush();
		  //extent.close();
		//driver.close();
	}
}
