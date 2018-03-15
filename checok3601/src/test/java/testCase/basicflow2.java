package testCase;

import static org.testng.Assert.assertTrue;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utility.locators;

public class basicflow2 {
	WebDriver driver;
	WebDriverWait wait;
	String uname = "gopi";
	String pass = "gopi$123";
	String clientname = "TCS";
	String projectname = "Checks360";
	ExtentReports extent;
	ExtentTest logger;

	@BeforeTest
	public void start() {
		extent = new ExtentReports ("/home/ganesh/git/checok3601/reports/STMExtentReport.html", true);
		extent
        .addSystemInfo("Host Name", "check360")
        .addSystemInfo("Environment", "Automation Testing")
        .addSystemInfo("User Name", "gopinath N");
		 logger = extent.startTest("start");
		System.setProperty("webdriver.firefox.marionette", "/home/ganesh/Desktop/gopinath/driver/geckodriver");
		 extent.loadConfig(new File("/home/ganesh/git/checok3601/reports/extent-config.xml"));
		driver = new FirefoxDriver();
		logger.log(LogStatus.PASS, "browser starting");
		driver.get("http://192.168.2.17:99/Login.aspx");
		logger.log(LogStatus.PASS, "application starting");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(4, TimeUnit.SECONDS);
	}

	@Test(priority = 1, enabled = true)
	public void homepage() {
		 logger = extent.startTest("homepage");
		String name = driver.findElement(By.id("ctl00_lblHeader")).getText();
		System.out.println(name);
		if (name.equalsIgnoreCase("CHECKS360 V1.2")) {
			assertTrue(true);
			logger.log(LogStatus.PASS, "login successfull");

		} else {
			assertTrue(false, "page loading failed");
		}
	}

	@Test(priority = 2, enabled = true, dependsOnMethods = "homepage")
	public void Login() {
		logger = extent.startTest("Login");
		try {
			wait = new WebDriverWait(driver, 4);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_ContentPlaceHolder1_txtUserName")))
					.sendKeys(uname);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_ContentPlaceHolder1_txtPassword")))
					.sendKeys(pass);
			;
			wait.until(ExpectedConditions.elementToBeClickable(By.id("ctl00_ContentPlaceHolder1_btnLogin"))).click();
			WebElement ele = driver.findElement(By.id("ctl00_ContentPlaceHolder1_lblhdr"));
			boolean result = ele.isDisplayed();
			assertTrue(result, "login failed plz check username password");
		} catch (Exception e) {
			// e.printStackTrace();
			assertTrue(false, "login failed plz check username password");
		}
	}

	@Test(priority = 3, enabled = true, dependsOnMethods = "Login")
	public void clickcase() {
		logger = extent.startTest("clickcase");
		try {
			WebElement ele = driver.findElement(By.id("btnNewCase_Click"));
			JavascriptExecutor je = (JavascriptExecutor) driver;
			je.executeScript("arguments[0].click();", ele);
			driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_divAddVal']/h2/table/tbody/tr/td[1]"));
			assertTrue(true);
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false, "failed");
		}

	}

	@Test(priority = 4, enabled = true, dependsOnMethods = "clickcase")
	public void entry() throws InterruptedException {
		logger = extent.startTest("entry");
		try {
			driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlClient_Input")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[text()='" + clientname + "']")).click();
			Thread.sleep(1000);

			driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlProject_Input")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[text()='" + projectname + "']")).click();
			Thread.sleep(1000);

			driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtFirstName")).sendKeys("maniiii");
			driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtLastName")).sendKeys("vvv");
			driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtClientCandidateID")).sendKeys("592348235");
			driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnAddComponent_input")).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test(priority = 5, enabled = true, dependsOnMethods = "entry")
	public void selectcheck1() throws IOException, InterruptedException {
		logger = extent.startTest("selectcheck1");
		try {
			Thread.sleep(2000);
			driver.switchTo().defaultContent();
			String ccc = driver.findElement(By.className("rwDialogText")).getText();
			System.out.println(ccc);
			driver.findElement(By.className("rwInnerSpan")).click();
		} catch (Exception e) {
			// TODO: handle exception
			WebElement ele1 = driver.findElement(By.id("ctl00_ContentPlaceHolder1_lblComponentCounthdr"));

			JavascriptExecutor jee = (JavascriptExecutor) driver;
			jee.executeScript("arguments[0].scrollIntoView(true)", ele1);
			List<String> name = new LinkedList<String>();
			List<String> box = new LinkedList<String>();
			List<WebElement> checkname = driver.findElements(
					By.xpath("//tr[contains(@id,'ctl00_ContentPlaceHolder1_grdComponentDetails_ctl00__')]/td[3]"));
			List<WebElement> checkbox = driver
					.findElements(By.xpath("//*[@class='rgGroupHeader']/following-sibling::tr/td[2]/span/label"));
			for (int i = 0; i < checkname.size(); i++) {
				String temp = checkname.get(i).getText();
				name.add(temp);
			}
			System.out.println(name);
			for (int i = 0; i < checkbox.size(); i++) {
				String temp = checkbox.get(i).toString();
				String op = temp.substring(84);
				// System.out.println(op);
				box.add(op);

			}
			System.out.println(box);
			List<String> dat = exceldata();
			// System.out.println("the data from excel : " +dat.get(3));
			for (int i = 0; i < dat.size(); i++) {
				sselect(dat.get(i), name, checkbox, driver);
			}
			driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSave_input")).click();
			Thread.sleep(2000);
			WebElement ele2 = driver.findElement(By.className("rwDialogText"));
			String te1 = ele2.getText();
			String te = te1.trim();
			if (te.contains("Saved")) {
				System.out.println(te);
				driver.switchTo().defaultContent();
				driver.findElement(By.className("rwInnerSpan")).click();
				assertTrue(true);
			} else if (te.contains("Case")) {
				System.out.println(te);
				driver.switchTo().defaultContent();
				driver.findElement(By.className("rwInnerSpan")).click();
				assertTrue(false);
			} else {
				System.out.println(te);
				driver.switchTo().defaultContent();
				driver.findElement(By.className("rwInnerSpan")).click();
				assertTrue(false);
			}

		}

	}

	public static void sselect(String checkname, List<String> name, List<WebElement> checkbox, WebDriver driver) {
		String ccc = checkname;
		for (int i = 0; i < name.size(); i++) {
			if (name.get(i).equalsIgnoreCase(ccc)) {
				JavascriptExecutor jeee = (JavascriptExecutor) driver;
				jeee.executeScript("arguments[0].scrollIntoView(true)", checkbox.get(i));
				checkbox.get(i).click();
				break;
			}
		}
	}

	public static List<String> exceldata() throws IOException {
		String path = "/home/ganesh/eclipse-workspace/checks/src/test/java/casereg/TestCase.xls";
		File file = new File(path);
		FileInputStream fis = new FileInputStream(file);
		HSSFWorkbook wb = new HSSFWorkbook(fis);
		HSSFSheet sheet = wb.getSheet("Sheet1");
		List<String> ex = new ArrayList<String>();
		Iterator<Row> rowiterator = sheet.iterator();
		while (rowiterator.hasNext()) {
			Row row = rowiterator.next();
			ex.add(row.getCell(0).getStringCellValue());
		}
		return ex;
	}

	@AfterTest
	public void teardown() {
		logger = extent.startTest("teardown");
		driver.close();
	}
}
