package com.qa.zoopla.Tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.zoopla.Pages.AgentPage;
import com.qa.zoopla.Pages.HomePage;
import com.qa.zoopla.Pages.PropertyLoctionPage;
import com.qa.zoopla.TestBase.TestBase;

public class MyTest extends TestBase {
	public HomePage homepage;
	public PropertyLoctionPage locationpgae;
	public AgentPage agentpage;

	public MyTest() {

		super();
	}

	@BeforeMethod

	public void setUp() {
		loadBrowserWithURL(prop.getProperty("browser"));
	}

	@Test

	public void displayAllPrices() {
		homepage= new HomePage();
		locationpgae=homepage.enterLocationAndSearch();
		ArrayList<Integer> prices = new ArrayList<Integer>();
		prices.addAll(locationpgae.showPricesOfProperty());
		Iterator<Integer> ir= prices.iterator();
		while(ir.hasNext()){
			
			System.out.println(ir.next());
			
		}
		
		Collections.sort(prices);
		Collections.reverse(prices);
		System.out.println("descending order:");
		
		Iterator<Integer> ir1= prices.iterator();
		while(ir1.hasNext()){
			
			System.out.println(ir1.next());
			
		}
		locationpgae.clickOnProperty5();
		
		String propAddress= locationpgae.getPropertyDetails();
		System.out.println(propAddress);
		agentpage=locationpgae.naviageToAgentPage();
		agentpage.loadAllProperties();
		
		ArrayList<String> propAddressList= new ArrayList<String>();
		
		propAddressList.addAll(agentpage.propertyAddressesInAgentPage());
		
		boolean flag=propAddressList.contains(propAddress);
		Assert.assertTrue(flag);
	}
}
