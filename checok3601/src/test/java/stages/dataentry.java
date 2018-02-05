package stages;

import java.util.ArrayList;
import java.util.List;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.locators;

public class dataentry {
	WebDriver driver;

	public dataentry(WebDriver driver) {
		this.driver = driver;
	}

	public void entry(String caseno) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement ele = driver.findElement(By.id(locators.dropdown));
		Select sel = new Select(ele);
		sel.selectByIndex(2);
		// Thread.sleep(500);
		// *************to click get next buttton****************
		// WebElement ee= driver.findElement(By.id(locators.getnext));
		// wait.until(ExpectedConditions.elementToBeClickable(ee));
		// ee.click();
		// ********************search and select*******************

		driver.findElement(By.id(locators.search)).sendKeys(caseno);
		// driver.findElement(By.id(locators.search)).sendKeys(keys.re);
		Thread.sleep(2000);
		WebElement ele1 = driver.findElement(By.id(locators.btn));
		wait.until(ExpectedConditions.elementToBeClickable(ele1));
		ele1.click();
		Thread.sleep(1000);

		WebElement ref = driver.findElement(By.xpath(".//*[text()='" + caseno + "']"));
		boolean casetatus = ref.isDisplayed();
		if (casetatus) {
			ref.click();
		} else {
			System.out.println("case not found");
		}
	}

	public List<String> getallchecks() throws InterruptedException {
		List<WebElement> checklist = driver.findElements(By.xpath("//*[@class='rtsUL']/li/a/span/span/span"));
		int checklenght = checklist.size();
		//System.out.println(checklenght);
		List<String> data = new ArrayList<String>();
		for (int i = 0; i < checklenght; i++) {
			String title = checklist.get(i).getText();
			data.add(title);
		checklist.get(i).click();
		Thread.sleep(3000);
			
		}
		// System.out.println(data);
		return data;
	}
	
}