package com.mla.abstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import freemarker.log.Logger;

public class AbstractComponents {

	private WebDriver driver;
	private WebDriverWait wait;

	// new Cars header

	public void goToNewCars(WebElement loactor) {

		AbstractComponents abs = new AbstractComponents(driver);
		abs.performAction(loactor);
	}

	public void performAction(WebElement locator) {
		Actions action = new Actions(driver);
		action.moveToElement(locator).perform();
	}

	public AbstractComponents(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	// wait until element is clickable
	public void waitToElementToBeClickable(By loactor) {

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(loactor));

	}

	public void waitToElementToBeClickable(WebElement loactor) {

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(loactor));

	}

	// Wait until page load
	public void waitToPageLoad(int duration) {
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(duration));
	}

	// Get the page title

	public void waitVisibilityOfElement(By locator) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));

	}
}
