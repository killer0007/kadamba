package testCase;

import static org.testng.Assert.assertTrue;

import stages.dataentry;
import stages.deQC;
import pages.Address;

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
import utility.locators;

public class basicflow {
	public String caseno = "123000009";
	public String name = "gopinathN";
	WebDriver driver;
	deQC de;
	dataentry dee;

	@BeforeTest
	public void start() {
		System.setProperty("webdriver.firefox.marionette", "/home/ganesh/Desktop/gopinath/driver/geckodriver");
		driver = new FirefoxDriver();
		driver.get("http://192.168.2.17:99/Login.aspx");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test(enabled = true, priority = 1)
	public void login() throws InterruptedException {
		driver.findElement(By.id(locators.Uname)).sendKeys("gopi");
		driver.findElement(By.id(locators.pass)).sendKeys("gopi$123");
		driver.findElement(By.id(locators.button)).click();
		Thread.sleep(500);
		boolean result = driver.findElement(By.id("ctl00_hlnkPasswordChange")).isDisplayed();
		assertTrue(result, "login failed check login details");

	}

	@Test(enabled = false, priority = 2, dependsOnMethods = "login")
	public void dataentryqc() throws InterruptedException {
		de = new deQC(driver);
		de.dataentryQC(caseno, name);
		Thread.sleep(1000);
		// String result = driver.findElement(By.xpath(".//*[text()='empone' AND
		// @selected='selected']")).getText();
		// System.out.println(result);
		// Assert.assertEquals(name, result);

	}

	@Test(enabled = true, priority = 3)
	public void dataentry() throws InterruptedException {
		dee = new dataentry(driver);
		dee.entry(caseno);
		List<String> Listcheck = new ArrayList<String>();
		Listcheck = dee.getallchecks();
		// driver.findElement(By.xpath("//*[text()='"+Listcheck.get(0)+"']")).click();
		List<WebElement> ele = driver.findElements(By.tagName("iframe"));
	    System.out.println("Number of frames in a page :" + ele.size());
	    for(int i=0;i<ele.size();i++){
	        String na = ele.get(i).getAttribute("src");
	        	 System.out.println("the source "+i+ ":"+ na);
	    }
	    driver.switchTo().defaultContent();
	    Thread.sleep(500);
	    driver.findElement(By.xpath("//*[text()='Address']")).click();
	    driver.switchTo().frame(0);
	    Thread.sleep(2000);
	   Address.add(driver);

	}
	@AfterTest
	public void close() throws InterruptedException {
		Thread.sleep(6000);
		// driver.close();
	}
}
