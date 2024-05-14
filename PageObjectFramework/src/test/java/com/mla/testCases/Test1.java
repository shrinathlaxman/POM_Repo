package com.mla.testCases;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mla.abstractComponents.AbstractComponents;
import com.mla.base.BaseTest;
import com.mla.pages.CarPage;
import com.mla.pages.FindNewCarPage;
import com.mla.pages.HomePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test1 extends BaseTest {

	//WebDriver driver;

	@Test
	public void myCarTest() throws Exception {

		//HomePage hp=launchApplication();

		// System.out.println(actualTitle);
		//AbstractComponents abs = new AbstractComponents(driver);
		
		String actualTitle =hp.getPageTitile();
		
		String expectedTitle = "New Cars, Used Cars, Buy a Car, Sell Your Car - CarWale";
		if (actualTitle.equals(expectedTitle))
			System.out.println("Test case pass actual title maches with expected");
		else
			throw new Exception("Test case fail actual title is not maches with expected");

		// wait to page load
		
		
		FindNewCarPage findNewCarPage = hp.goToFindNewCars();
		// Thread.sleep(3000);
		String actualNewCarText = findNewCarPage.getCarText();
		String expNewCarText = "NEW CARS";

		Assert.assertEquals(actualNewCarText, expNewCarText, "Failed to Navigate Cars Page");

		// get all the cars brands

		ArrayList<String> allBrandsCars = findNewCarPage.getAllBrands();
		System.out.println(allBrandsCars.size());

		System.out.println(allBrandsCars);

		String carName = "Tata";
		CarPage cp = findNewCarPage.goToCar(carName);
		String actualCarName = cp.getSelectedCarName();
		String expCarName = "Tata Cars";
		Assert.assertEquals(actualCarName, expCarName);
		

	}
}
