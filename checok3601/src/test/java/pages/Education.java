package pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.FindElement;

public class Education {
	static FindElement elements;
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
		elements = new FindElement(driver);
		WebElement edutype = elements.find("ctl00_ContentPlaceHolder1_ddlEducationHighestComponent_Input");
		edutype.click();
		edutype.sendKeys(Keys.ARROW_DOWN);
		edutype.sendKeys(Keys.ARROW_DOWN);
		edutype.sendKeys(Keys.ARROW_DOWN);
		edutype.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		WebElement institute = elements.find("ctl00_ContentPlaceHolder1_ddlEducationInstitute_Input");
		institute.sendKeys("anna");
		Thread.sleep(1000);
		institute.sendKeys(Keys.ARROW_DOWN);
		institute.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		WebElement edu = elements.find("ctl00_ContentPlaceHolder1_ddlEducationBoard_Input");
		edu.clear();
		edu.sendKeys("anna");
		Thread.sleep(700);
		edu.sendKeys(Keys.ARROW_DOWN);
		edu.sendKeys(Keys.ENTER);
		Thread.sleep(1000);	
		elements.find("ctl00_ContentPlaceHolder1_txtEducationNameOfCourse").sendKeys("ECE");
		elements.find("ctl00_ContentPlaceHolder1_txtEducationEnrollmentRegisterNo").sendKeys("612312106017");
		elements.find("ctl00_ContentPlaceHolder1_txtEducationCourseCompletionDate_dateInput").sendKeys("12/2014");
		WebElement save = elements.find("ctl00_ContentPlaceHolder1_btnEducationSaveSubmit_input");
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

