package mobile;
import java.net.URL;
import java.util.List;
import java.net.MalformedURLException;
import io.appium.java_client.android.AndroidDriver;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.remote.DesiredCapabilities;
public class BrowserStack {
	public static String userName = "gopinath77";
	  public static String accessKey = "pFq3rG8kt4yuPhw7ExMH";

	  public static void main(String args[]) throws MalformedURLException, InterruptedException {
	    DesiredCapabilities caps = new DesiredCapabilities();

	    caps.setCapability("device", "Google Nexus 6");
	    caps.setCapability("app", "bs://<hashed app-id>");

	    AndroidDriver driver = new AndroidDriver(new URL("https://"+userName+":"+accessKey+"@hub-cloud.browserstack.com/wd/hub"), caps);

	    WebElement searchElement = new WebDriverWait(driver, 30).until(
	        ExpectedConditions.elementToBeClickable(By.id("Search Wikipedia")));
	    searchElement.click();
	    WebElement insertTextElement = new WebDriverWait(driver, 30).until(
	        ExpectedConditions.elementToBeClickable(By.id("org.wikipedia.alpha:id/search_src_text")));
	    insertTextElement.sendKeys("BrowserStack");
	    Thread.sleep(5000);

	    List allProductsName = driver.findElements(By.className("android.widget.TextView"));
	    assert(allProductsName.size() > 0);

	    driver.quit();
	  }
}
