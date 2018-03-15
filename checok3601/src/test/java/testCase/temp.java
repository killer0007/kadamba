package testCase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utility.ReadData;
public class temp{
	static WebDriver driver;
public static void main(String[] args) throws InterruptedException, IOException {
	//ReadData rd = new ReadData();
//	String path1 = "/home/ganesh/Downloads/mis.xls";
//	List<List<String>> readdata = new ArrayList<List<String>>();
//	readdata =rd.getdata(path1, "Sheet1");
//	System.out.println(readdata);
	String text = "name";
	
	System.setProperty("webdriver.chrome.driver", "/home/ganesh/Desktop/gopinath/driver/chromedriver");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://www.seleniumeasy.com/test/basic-first-form-demo.html");
	driver.findElement(By.id("user-message")).sendKeys(text);
	try {
		driver.findElement(By.xpath("//*[text()='Show dd']")).click();
	} catch (NoSuchElementException e) {
		// TODO: handle exception
		System.out.println("in catch");
		driver.findElement(By.xpath("//*[text()='Show Message']")).click();
	}
	
	
	String op = driver.findElement(By.id("display")).getText();
	if(op.equals(text)) {
		System.out.println("test passed");
		
	}
	else {
		System.out.println("test failed");
	}
	driver.close();
}
public void durai() throws InterruptedException {
	String text = "name";
	System.setProperty("webdriver.firefox.marionette", "/home/ganesh/Desktop/gopinath/driver/geckodriver");
	driver = new FirefoxDriver();
	driver.get("http://www.seleniumeasy.com/test/basic-first-form-demo.html");
	driver.manage().window().maximize();
	driver.findElement(By.id("user-message")).sendKeys(text);
	driver.findElement(By.xpath("//*[text()='Show Message']")).click();
	
	String op = driver.findElement(By.id("display")).getText();
	if(op.equals(text)) {
		System.out.println("test passed");
		
	}
	else {
		System.out.println("test failed");
	}
	driver.close();
}
}
