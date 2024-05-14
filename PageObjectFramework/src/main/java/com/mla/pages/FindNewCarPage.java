package com.mla.pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mla.abstractComponents.AbstractComponents;

public class FindNewCarPage extends AbstractComponents {

	private WebDriver driver;

	public FindNewCarPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[text()='NEW CARS']")
	WebElement actCarText;

	@FindBy(xpath = "//ul[@class='o-XylGE o-bCRRBE  o-cpnuEd']/li/a")
	List<WebElement> allBrands;

	@FindBy(xpath = "//div[@aria-label='View More Brands']")
	WebElement viewAll;

	By CarText = By.xpath("//div[text()='NEW CARS']");

	public String getCarText() {

		waitVisibilityOfElement(CarText);
		return actCarText.getText();
	}

	public ArrayList<String> getAllBrands() {

		viewAll.click();
		Iterator<WebElement> itr = allBrands.iterator();
		ArrayList<String> expAllBrands = new ArrayList<>();
		while (itr.hasNext()) {
			String value = itr.next().getText();
			expAllBrands.add(value);

		}
		return expAllBrands;
	}

	public CarPage goToCar(String carName) throws InterruptedException {
		Iterator<WebElement> itr = allBrands.iterator();
		while (itr.hasNext()) {
			WebElement selectCar=itr.next();
			String value = selectCar.getText();
			if (value.equals(carName)) {
				waitToElementToBeClickable(selectCar);
				System.out.println("Clicked on car bran "+value);
				selectCar.click();
				break;
			}
		}

		return new CarPage(driver);
	}
}
