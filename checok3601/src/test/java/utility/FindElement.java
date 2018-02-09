package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FindElement {
	private WebDriver driver;

	public FindElement(WebDriver driver) {
		this.driver = driver;

	}

	public WebElement find(String path) {
		WebElement ele = driver.findElement(By.id(path));
		return ele;

	}
}
