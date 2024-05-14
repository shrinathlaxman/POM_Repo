package com.mla.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.mla.pages.HomePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	private Properties prop;
	private FileInputStream fis;
	private WebDriver driver;
	public HomePage hp;

	public WebDriver inisializeDriver() {
		prop = new Properties();
		String filePath = System.getProperty("user.dir") + "\\src\\main\\java\\com\\mla\\resources\\config.properties";
		try {
			fis = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String browser = prop.getProperty("browser");

		if (browser.equals("chrome")) {

			WebDriverManager.chromedriver().setup();
			ChromeOptions ops = new ChromeOptions();
			ops.addArguments("--disable-notifications");
			driver = new ChromeDriver(ops);
		} else if (browser.equals("ie")) {

			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		return driver;
	}

	// Take screenshot

	public String getScreenShot(String testcaseName,WebDriver driver) throws IOException {
		//driver = inisializeDriver();
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "\\screenshots\\" + testcaseName + ".png");
		FileUtils.copyFile(src, file);
		return System.getProperty("user.dir") + "\\screenshots\\" + testcaseName + ".png";

	}

	@BeforeMethod
	public HomePage launchApplication() {

		driver = inisializeDriver();
		hp = new HomePage(driver);
		hp.goTo();
		return hp;
	}

	@AfterMethod
	public void tearDown() {
		if (driver != null) {

			driver.close();
		}

	}
}
