package com.qa.zoopla.Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.zoopla.TestBase.TestBase;

public class PropertyLoctionPage extends TestBase {

	@FindAll({
			@FindBy(xpath = "//ul[@class='listing-results clearfix js-gtm-list']//a[@class='listing-results-price text-price']") })
	private List<WebElement> strPropertyPrices;
	
	@FindBy(xpath="(//div[@class='listing-results-wrapper']//a[@class='listing-results-price text-price'])[5]")
	private WebElement property5;
	
	
	@FindBy(xpath="//div[@class='ui-property-summary']//h1[@class='ui-property-summary__title ui-title-subgroup']")
	private WebElement selectedPropName;
	
	@FindBy(xpath="//h2[@class='ui-property-summary__address']")
	private WebElement selectedPropAddress;
	
	@FindBy(xpath="//div[@class='ui-agent']")
	private WebElement agentName;

	public PropertyLoctionPage() {
		PageFactory.initElements(driver, this);

	}

	public String verifyPageTitle(){
		
		return driver.getTitle();
	}
	
	public ArrayList<Integer> showPricesOfProperty(){
		
		ArrayList<Integer> propertyPrice= new  ArrayList<Integer>();
		for (int i=0; i<strPropertyPrices.size();i++){
			
			int strPrice = Integer.parseInt((strPropertyPrices.get(i).getText().replaceAll("[^0-9]", "")));
			propertyPrice.add(strPrice);
			
		}
		 return propertyPrice;
	}
	
	public void clickOnProperty5(){
		/*JavascriptExecutor js1= (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].scrollIntoView(true);",property5);*/
		property5.click();
		
	}
	
	public String getPropertyDetails(){
		
		//ArrayList<String> propDetails= new ArrayList<String>();
		//propDetails.add(selectedPropName.getText());
		//propDetails.add(selectedPropAddress.getText());
		String prpAddress= selectedPropAddress.getText();
		return prpAddress;
		
	}
	
	public AgentPage naviageToAgentPage(){
		agentName.click();
		return new AgentPage();
		
	}
}