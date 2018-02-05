package utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class screenshot {
	WebDriver driver;
	public screenshot(WebDriver driver) {
		this.driver=driver;
	}
	public void takeshot(String path) {
	File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	try {
		 // now copy the  screenshot to desired location using copyFile //method
		FileUtils.copyFile(src, new File(path));
		}
		 
		catch (IOException e)
		 {
		  System.out.println(e.getMessage());
		 }
	
}
}
