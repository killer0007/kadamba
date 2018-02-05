package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Address {
	WebDriver driver;
//	**********data entry for address check***********************
public static void add(WebDriver driver) {
	driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlComponent_Input")).click();
	List<WebElement> drop = driver.findElements(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_ddlComponent_DropDown']/div/ul/li"));
	int size=drop.size();
	List<String> dropdata = new ArrayList<String>();
	//***getting data in dropdown*******
	for(int i=0;i<size;i++) {
		String name = drop.get(i).getText();
		dropdata.add(name);
	}
	drop.get(2).click();
	System.out.println(dropdata);
}
}
