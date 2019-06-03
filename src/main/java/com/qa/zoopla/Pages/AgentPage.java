package com.qa.zoopla.Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.zoopla.TestBase.TestBase;

public class AgentPage extends TestBase {
	
	
	
	
	@FindBy(xpath="//a[contains(text(),'See all property for sale from this agent')]")
	private WebElement seeAllProperties;
	
	@FindAll({@FindBy(xpath="//a[@class='listing-results-address']")})
	private List<WebElement> allPropertyAddress;
	
	public AgentPage(){
		PageFactory.initElements(driver, this);
	}
	
	
	public void loadAllProperties(){
		
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",seeAllProperties);
		
		seeAllProperties.click();
	}

	public ArrayList<String> propertyAddressesInAgentPage(){
		
		ArrayList<String> propAddValues= new ArrayList<String>();
		for (int i=0; i<allPropertyAddress.size();i++ ){
			propAddValues.add(allPropertyAddress.get(i).getText());
		}
		return propAddValues;
	}
}
