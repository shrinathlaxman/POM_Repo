package com.mla.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mla.abstractComponents.AbstractComponents;

public class HomePage extends AbstractComponents {

	private WebDriver driver;

	public HomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//div[text()='NEW CARS']")
	WebElement newCars;
	
	@FindBy(xpath="//div[text()='Find New Cars']")
	WebElement findNewCars;
	
	By neCarsElement=By.xpath("//div[text()='NEW CARS']");
	public FindNewCarPage goToFindNewCars() {
		waitToElementToBeClickable(neCarsElement);
		performAction(newCars);
		findNewCars.click();
		return new FindNewCarPage(driver);
	}
	
	

	public void goTo() {
		
		driver.get("https://www.carwale.com/");
	}
	
	public String getPageTitile() {

		return driver.getTitle();
	}

}
