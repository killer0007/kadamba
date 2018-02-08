package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Credit {
	WebDriver driver;

	// **********data entry for address check***********************
	
	//******************** click on address frame*************************
	public static void click (WebDriver driver) throws InterruptedException {
		 driver.findElement(By.xpath("//*[text()='Credit']")).click();
	 	    driver.switchTo().frame(6);
	 	    Thread.sleep(2000);
	 	    
	 	    int addsize  = Credit.add(driver);
	 	    int endpoint=addsize-2;
	 	    System.out.println("size is : "+addsize +"\n"+"end point is :" +endpoint);
	 	    for (int i = 0; i < addsize-1; i++) {
	 	    	Credit.adddata(driver, i, endpoint);
	 		}
	}
	
	// **********************get dropdown count in address check*********************
	public static int add(WebDriver driver) throws InterruptedException {
	//	driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlcreditComponent_Input")).click();
		List<WebElement> drop = driver
				.findElements(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_ddlcreditComponent_DropDown']/div/ul/li"));
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
		//

	}
	public static void adddata(WebDriver driver, int end, int endpoint) throws InterruptedException {
		try {
			WebElement drop = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlCreditId_Input"));
			drop.sendKeys(Keys.ARROW_DOWN);
			drop.sendKeys(Keys.ENTER);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Thread.sleep(1000);
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtCreditIdName")).sendKeys("JUGUGJV");
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtCreditIdNumber")).sendKeys("9988776655");
		
		WebElement save = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnCreditSaveSubmit_input"));
		JavascriptExecutor je = (JavascriptExecutor)driver;
		je.executeScript("arguments[0].scrollIntoView(true);", save);
		save.click();
		Thread.sleep(1000);
		
		if (end == endpoint) {
			driver.switchTo().defaultContent();
			driver.findElement(By.xpath("//*[@class='rwInnerSpan']")).click();
			
		} else {
			driver.findElement(By.xpath("//*[@class='rwInnerSpan']")).click();
			
		}
	}
}
