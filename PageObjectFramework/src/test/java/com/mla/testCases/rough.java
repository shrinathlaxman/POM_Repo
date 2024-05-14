package com.mla.testCases;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class rough {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(ops);
		driver.manage().window().maximize();
		driver.get("https://www.carwale.com/");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		List<WebElement> allBrands=driver.findElements(By.xpath("//ul[@class='o-XylGE o-bCRRBE  o-cpnuEd']/li/a"));
		Iterator<WebElement> itr = allBrands.iterator();
		ArrayList<String> expAllBrands=new ArrayList<>();
		while(itr.hasNext()) {
			String value=itr.next().toString();
			expAllBrands.add(value);	
			
		}
	}

	
}
