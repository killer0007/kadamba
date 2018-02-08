package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Education {
	public static void click (WebDriver driver) throws InterruptedException {
		 driver.findElement(By.xpath("//*[text()='Education']")).click();
	 	    driver.switchTo().frame(1);
	 	    Thread.sleep(2000);
	 	    
	 	    int addsize  = Education.add(driver);
	 	    int endpoint=addsize-2;
	 	    System.out.println("size is : "+addsize +"\n"+"end point is :" +endpoint);
	 	    for (int i = 0; i < addsize-1; i++) {
	 	    	Education.adddata(driver, i, endpoint);
	 		}
	}
	public static int add(WebDriver driver) throws InterruptedException {
		
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlEducationComponent_Input")).click();
		List<WebElement> drop = driver
				.findElements(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_ddlEducationComponent_DropDown']/div/ul/li"));
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
		
		
		if (end == endpoint) {
			driver.switchTo().defaultContent();
			driver.findElement(By.xpath("//*[@class='rwInnerSpan']")).click();
			
		} else {
			driver.findElement(By.xpath("//*[@class='rwInnerSpan']")).click();
			
		}
	}
	}

