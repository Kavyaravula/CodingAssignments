package com.qa.zoopla.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.zoopla.TestBase.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(id="search-input-location")
	private WebElement strLocationSearch;
	
	@FindBy(id="search-submit")
	private WebElement brnSubmit;
	
	
	public HomePage(){
		PageFactory.initElements(driver, this);
		
	}
	
	public PropertyLoctionPage enterLocationAndSearch(){
		strLocationSearch.sendKeys("london");
		brnSubmit.click();
		return new PropertyLoctionPage();
	}

}
