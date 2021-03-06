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
import utility.locators;

public class basicflow {
	public String caseno = "123000005";
	public String name = "gopinathN";
	WebDriver driver;
	deQC qc;
	dataentry dentry;

	@BeforeTest
	public void start() {
		System.setProperty("webdriver.firefox.marionette", "/home/ganesh/Desktop/gopinath/driver/geckodriver");
		driver = new FirefoxDriver();
		driver.get("http://192.168.2.17:99/Login.aspx");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
// ********************login page*******************************
	@Test(enabled = true, priority = 1)
	public void login() throws InterruptedException {
		driver.findElement(By.id(locators.Uname)).sendKeys("gopi");
		driver.findElement(By.id(locators.pass)).sendKeys("gopi$123");
		driver.findElement(By.id(locators.button)).click();
		Thread.sleep(500);
		boolean result = driver.findElement(By.id("ctl00_hlnkPasswordChange")).isDisplayed();
		assertTrue(result, "login failed check login details");
	}
// ******************data entry qc *********************************
	@Test(enabled = false, priority = 2, dependsOnMethods = "login")
	public void dataentryqc() throws InterruptedException {
		qc = new deQC(driver);
		qc.dataentryQC(caseno, name);
		Thread.sleep(1000);
	}
//  **************************** data entry*********************
	@Test(enabled = false, priority = 3)
	public void dataentry() throws InterruptedException {
		dentry = new dataentry(driver);
		dentry.entry(caseno, 2);
		List<String> Listcheck = new ArrayList<String>();
		Listcheck = dentry.getallchecks();
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
			case "Addresss":
				Address.click(driver);
				break;
			case "Education":
				// for selecting education type
				Education.click(driver);
				break;
			case "Employment":
				Employement.click(driver);
				break;
			case "Reference":
				Reference.click(driver);
				break;
			case "DataBase":
				DataBase.click(driver);
				break;
			case "Criminal":
				Criminal.click(driver);
				break;
			case "Credit":
				Credit.click(driver);
				break;
			case "Court":
				Court.click(driver);
				break;
			case "ID":
				Id.click(driver);
				break;
			default:
				break;
			}
		} 
	}
	@Test(enabled = true, priority = 4)
	public void dataentryQC() {
		
	}
	@AfterTest
	public void close() throws InterruptedException {
		Thread.sleep(6000);
		//driver.close();
	}
}
