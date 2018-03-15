package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.FindElement;

public class Id {
	static FindElement elements;
	public static void click (WebDriver driver) throws InterruptedException {
		 driver.findElement(By.xpath("//*[text()='ID']")).click();
	 	    driver.switchTo().frame(9);
	 	    Thread.sleep(2000);
	 	    
	 	    int addsize  = Id.add(driver);
	 	    int endpoint=addsize-2;
	 	    System.out.println("size is : "+addsize +"\n"+"end point is :" +endpoint);
	 	    for (int i = 0; i < addsize-1; i++) {
	 	    	Id.adddata(driver, i, endpoint);
	 		}
	}
	public static int add(WebDriver driver) throws InterruptedException {
		List<WebElement> drop = driver
				.findElements(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_ddlIdComponent_DropDown']/div/ul/li"));
		System.out.println("id dd is : "+drop);
		int size = drop.size();
		List<String> dropdata = new ArrayList<String>();
		// ***getting data in dropdown*******
		for (int i = 0; i < size; i++) {
			String name = drop.get(i).getText();
			System.out.println("data is :" + name);
			dropdata.add(name);
		}
		System.out.println(dropdata);
		int dropsize = dropdata.size();
		Thread.sleep(3000);
		return dropsize;
	}
	public static void adddata(WebDriver driver, int end, int endpoint) throws InterruptedException {
		elements = new FindElement(driver);
		elements.find("ctl00_ContentPlaceHolder1_txtIdName").sendKeys("ECFWERTEE");
		elements.find("ctl00_ContentPlaceHolder1_txtIdNumber").sendKeys("59823479853");
		WebElement save = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnIdSaveSubmit_input"));
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
