package pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.record.PageBreakRecord.Break;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Criminal {
	WebDriver driver;

	// **********data entry for address check***********************
	
	//******************** click on address frame*************************
	public static void click (WebDriver driver) throws InterruptedException {
		 driver.findElement(By.xpath("//*[text()='Criminal']")).click();
	 	    driver.switchTo().frame(5);
	 	    Thread.sleep(2000);
	 	    
	 	    int addsize  = Criminal.add(driver);
	 	    int endpoint=addsize-2;
	 	    System.out.println("size is : "+addsize +"\n"+"end point is :" +endpoint);
	 	    for (int i = 0; i < addsize-1; i++) {
	 	    	 Criminal.adddata(driver, i, endpoint);
	 		}
	}
	
	// **********************get dropdown count in address check*********************
	public static int add(WebDriver driver) throws InterruptedException {
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlCriminalComponent_Input")).click();
		List<WebElement> drop = driver
				.findElements(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_ddlCriminalComponent_DropDown']/div/ul/li"));
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
// *****************data entry in address check****************************88
	public static void adddata(WebDriver driver, int end, int endpoint) throws InterruptedException {
		WebElement line = driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtCriminalAddress"));
		line.clear();
		line.sendKeys("plot no 1");
		WebElement state = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlCriminalState_Input"));
		state.clear();
		state.sendKeys("tam");
		Thread.sleep(600);
		state.sendKeys(Keys.ARROW_DOWN);
		state.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		WebElement city = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlCriminalCity_Input"));
		city.clear();
		city.sendKeys("chen");
		Thread.sleep(700);
		city.sendKeys(Keys.ARROW_DOWN);
		city.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		WebElement station =driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtPoliceStation"));
		station.clear();
		station.sendKeys("chennai R2 ");
		WebElement save = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnCriminalSubmit_input"));
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
