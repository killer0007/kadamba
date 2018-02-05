package testCase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class temp {
	static WebDriver driver;
public static void main(String[] args) throws InterruptedException {
	System.setProperty("webdriver.firefox.marionette", "/home/ganesh/Desktop/gopinath/driver/geckodriver");
	driver = new FirefoxDriver();
	driver.get("http://demo.guru99.com/test/guru99home/");
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	int size = driver.findElements(By.tagName("iframe")).size();
	System.out.println("frame size is :"+size);
	
	for(int i=0;i<size;i++) {
		driver.switchTo().frame(i);
		System.out.println("current page is : "+driver.getWindowHandle());
		Thread.sleep(2000);
		
	}
}
}	
