package com.mla.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mla.abstractComponents.AbstractComponents;

public class CarPage extends AbstractComponents{

	private WebDriver driver;
	public CarPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath="//h1[@data-lang-id='make_page_heading']")
	WebElement carModel;
	
	public String getSelectedCarName() {
		
		return carModel.getText();
	}
}
