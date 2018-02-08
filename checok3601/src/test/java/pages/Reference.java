package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Reference {
	public static void click (WebDriver driver) throws InterruptedException {
		 driver.findElement(By.xpath("//*[text()='Reference']")).click();
	 	    driver.switchTo().frame(3);
	 	    Thread.sleep(2000);
	 	    
	 	    int addsize  = Reference.add(driver);
	 	    int endpoint=addsize-2;
	 	    System.out.println("size is : "+addsize +"\n"+"end point is :" +endpoint);
	 	    for (int i = 0; i < addsize-1; i++) {
	 	    	Reference.adddata(driver, i, endpoint);
	 		}
	}
	public static int add(WebDriver driver) throws InterruptedException {
		
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlRefType_Input")).click();
		List<WebElement> drop = driver
				.findElements(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_ddlRefType_DropDown']/div/ul/li"));
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
		
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtReferenceName")).sendKeys("raja");
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtRefContactNo1")).sendKeys("4525256869");
		WebElement save = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnRefSaveSubmit_input"));
		JavascriptExecutor je = (JavascriptExecutor)driver;
		je.executeScript("arguments[0].scrollIntoView(true);", save);
		
		save.click();
		System.out.println("*******************************");
		System.out.println("end is : "+end+"  " +"end point is :" +endpoint);
		Thread.sleep(1000);
		if (end == endpoint) {
			driver.switchTo().defaultContent();
			driver.findElement(By.xpath("//*[@class='rwInnerSpan']")).click();
			
		} else {
			driver.findElement(By.xpath("//*[@class='rwInnerSpan']")).click();
			
		}
	}

}
