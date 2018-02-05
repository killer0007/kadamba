package stages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.locators;

public class deQC {
	WebDriver driver;

	public deQC(WebDriver driver) {
		this.driver = driver;
	}

	public void dataentryQC(String caseno, String names) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement ele = driver.findElement(By.id(locators.dropdown));
		Select sel = new Select(ele);
		sel.selectByIndex(1);
		Thread.sleep(500);
		driver.findElement(By.id(locators.search)).sendKeys(caseno);
		// driver.findElement(By.id(locators.search)).sendKeys(keys.re);
		Thread.sleep(2000);
		WebElement ele1 = driver.findElement(By.id(locators.btn));
		wait.until(ExpectedConditions.elementToBeClickable(ele1));
		ele1.click();
		Thread.sleep(1000);
		// ********************************verify case id and select high
		List<WebElement> tbody = driver.findElements(By.xpath(locators.tbodycheck));
		for (int i = 0; i < tbody.size(); i++) {
			if (tbody.get(i).getText().equals(caseno)) {
				WebElement element = driver.findElement(By.xpath(locators.priority));
				Select sl = new Select(element);
				String svalue = sl.getFirstSelectedOption().getText();

				if (svalue.equals("Normal")) {
					sl.selectByVisibleText("High");
					Thread.sleep(500);
					driver.findElement(By.xpath(locators.alert)).click();

				} else {
					System.out.println("state high already selected");
				}
				System.out.println("start");
				WebElement ell = driver.findElement(By.xpath(locators.assignuser));
				boolean name1 = ell.isEnabled();
				System.out.println("the boolean is:" + name1);
				if (name1) {
					System.out.println("entering loop");
					Select sel1 = new Select(ell);
					sel1.selectByVisibleText(names);

					break;

					// return true;
				} else {
					System.out.println("already assigned");

				}

			} else {
				System.out.println("case not found");

			}
		}

	}
}
