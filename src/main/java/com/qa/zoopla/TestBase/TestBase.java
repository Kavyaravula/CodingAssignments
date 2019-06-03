package com.qa.zoopla.TestBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;

	public TestBase() {
		prop = new Properties();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(
					"C:\\Users\\Chintu\\workspace\\SeleniumCodingAssignments\\src\\main\\java\\com\\qa\\zoopla\\Config\\config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e1) {

			e1.printStackTrace();
		}

		catch (IOException e) {

			e.printStackTrace();
		}
	}
	
	public static void loadBrowserWithURL(String nameOfBrowser){
		
		
		if (nameOfBrowser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "F:\\Selenium Drivers\\chromedriver4.exe");
			driver= new ChromeDriver();
		}
		else if(nameOfBrowser.equalsIgnoreCase("ff")){
			System.setProperty("webdriver.gecko.driver", "F:\\Selenium Drivers\\geckodriver(1).exe");
			driver= new FirefoxDriver();
		}
		else if(nameOfBrowser.equalsIgnoreCase("IE")){
			System.setProperty("wendrover.ie.driver", "F:\\Selenium Drivers\\IEDriverServer_x64_3.5.1\\IEDriverServer.exe");
			driver= new InternetExplorerDriver();
		}
		else {
			System.out.println("Please Enter Valid Browser Name: Like chrome or IE or FF");
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
}
