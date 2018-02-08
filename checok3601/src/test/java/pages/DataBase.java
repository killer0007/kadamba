package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DataBase {
	public static void click (WebDriver driver) throws InterruptedException {
		 driver.findElement(By.xpath("//*[text()='DataBase']")).click();
	 	    driver.switchTo().frame(4);
	 	    Thread.sleep(2000);
	 	    
	 	   WebElement drop = driver.findElement(By.id("ctl00_ContentPlaceHolder1_dockIDDetails_C_ddlDataBaseIDComponent_Input"));
			Thread.sleep(1000);
			drop.sendKeys(Keys.ARROW_DOWN);
			drop.sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			driver.findElement(By.id("ctl00_ContentPlaceHolder1_dockIDDetails_C_txtDataBaseNameOnID")).sendKeys("HYRJA");
			driver.findElement(By.id("ctl00_ContentPlaceHolder1_dockIDDetails_C_txtDataBaseIDNumber")).sendKeys("53245345435");
			WebElement save = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnDataBaseSaveSubmit_input"));
			JavascriptExecutor je = (JavascriptExecutor)driver;
			je.executeScript("arguments[0].scrollIntoView(true);", save);		
			save.click();
			System.out.println("*******************************");
			Thread.sleep(1000);
			driver.switchTo().defaultContent();
			driver.findElement(By.xpath("//*[@class='rwInnerSpan']")).click();
	 	    
	 	   
	}
	
}
