package pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.record.PageBreakRecord.Break;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.FindElement;

public class Address {
	static FindElement elements;

	// **********data entry for address check***********************
	
	//******************** click on address frame*************************
	public static void click (WebDriver driver) throws InterruptedException {
		
		 if (driver.findElement(By.xpath("//*[text()='Address']")).isDisplayed()) {
			driver.findElement(By.xpath("//*[text()='Address']")).click();
			driver.switchTo().frame(0);
			Thread.sleep(2000);
			int addsize = Address.add(driver);
			int endpoint = addsize - 2;
			System.out.println("size is : " + addsize + "\n" + "end point is :" + endpoint);
			for (int i = 0; i < addsize - 1; i++) {
				Address.adddata(driver, i, endpoint);
			} 
		}
		 else {
			 System.out.println("Address Check Not Found");
		 }
	}
	
	// **********************get dropdown count in address check*********************
	public static int add(WebDriver driver) throws InterruptedException {
		//driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlComponent_Input")).click();
		List<WebElement> drop = driver
				.findElements(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_ddlComponent_DropDown']/div/ul/li"));
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
		elements=new FindElement(driver);
		WebElement line = elements.find("ctl00_ContentPlaceHolder1_txtAddressAddress");
		line.clear();
		line.sendKeys("plot no 1");
		WebElement state = elements.find("ctl00_ContentPlaceHolder1_ddlAddressState_Input");
		state.clear();
		state.sendKeys("tam");
		Thread.sleep(600);
		state.sendKeys(Keys.ARROW_DOWN);
		state.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		WebElement city = elements.find("ctl00_ContentPlaceHolder1_ddlAddressCity_Input");
		city.clear();
		city.sendKeys("chen");
		Thread.sleep(700);
		city.sendKeys(Keys.ARROW_DOWN);
		city.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		WebElement landmark = elements.find("ctl00_ContentPlaceHolder1_txtAddressLandMark");
		landmark.clear();
		landmark.sendKeys("near central station");
//		WebElement area = driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtArea"));
//		area.clear();
//		area.sendKeys("mylapore");
		WebElement submit = elements.find("ctl00_ContentPlaceHolder1_btnAddressSubmit_input");
		submit.click();
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
