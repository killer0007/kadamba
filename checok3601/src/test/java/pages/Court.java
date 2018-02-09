package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.FindElement;

public class Court {
	WebDriver driver;
	static FindElement elements;

	// **********data entry for address check***********************
	
	//******************** click on address frame*************************
	public static void click (WebDriver driver) throws InterruptedException {
		 driver.findElement(By.xpath("//*[text()='Court']")).click();
	 	    driver.switchTo().frame(7);
	 	    Thread.sleep(2000);
	 	    
	 	    int addsize  = Court.add(driver);
	 	    int endpoint=addsize-2;
	 	    System.out.println("size is : "+addsize +"\n"+"end point is :" +endpoint);
	 	    for (int i = 0; i < addsize-1; i++) {
	 	    	Court.adddata(driver, i, endpoint);
	 		}
	}
	
	// **********************get dropdown count in address check*********************
	public static int add(WebDriver driver) throws InterruptedException {
		List<WebElement> drop = driver
				.findElements(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_ddlCourtComponent_DropDown']/div/ul/li"));
		int size = drop.size();
		List<String> dropdata = new ArrayList<String>();
		// ***getting data in dropdown*******
		for (int i = 0; i < size; i++) {
			String name = drop.get(i).getText();
			System.out.println("data is :" + name);
			dropdata.add(name);
		}
		// drop.get(0).click();
		System.out.println(dropdata);
		int dropsize = dropdata.size();
		Thread.sleep(3000);

		return dropsize;

	}
	public static void adddata(WebDriver driver, int end, int endpoint) throws InterruptedException {
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtCourtAddress")).sendKeys("plot no 1");
		
		elements= new FindElement(driver);
		
		WebElement state = elements.find("ctl00_ContentPlaceHolder1_ddlCourtState_Input");
		state.clear();
		state.sendKeys("tam");
		Thread.sleep(600);
		state.sendKeys(Keys.ARROW_DOWN);
		state.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		WebElement city = elements.find("ctl00_ContentPlaceHolder1_ddlCourtCity_Input");
		city.clear();
		city.sendKeys("chen");
		Thread.sleep(700);
		city.sendKeys(Keys.ARROW_DOWN);
		city.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		
		WebElement save = elements.find("ctl00_ContentPlaceHolder1_btnCourtSubmit_input");
		JavascriptExecutor je = (JavascriptExecutor)driver;
		je.executeScript("arguments[0].scrollIntoView(true);", save);
		save.click();
		Thread.sleep(1000);
		if (end == endpoint) {
			driver.switchTo().defaultContent();
			Thread.sleep(500);
			driver.findElement(By.xpath("//*[@class='rwInnerSpan']")).click();
			
		} else {
			driver.findElement(By.xpath("//*[@class='rwInnerSpan']")).click();
			
		}
	}
}
