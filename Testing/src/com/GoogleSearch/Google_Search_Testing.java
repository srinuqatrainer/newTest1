package com.GoogleSearch;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Google_Search_Testing 
{

	
	ChromeDriver driver;

	@BeforeTest
	public void setUp()
	{
	
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\driverFiles\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.get("http://google.com");
		
		driver.manage().window().maximize();
		
	
	
}
	
	@Test
	public void search()
	{
		driver.findElement(By.id("lst-ib")).sendKeys("Cheese");
		
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).build().perform();
		
		String expected_Title="Cheese";
		
		String actual_Title=driver.getTitle();
		
		
		assertTrue(actual_Title.contains(expected_Title), "Title does not contain expected text -- Fail");
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
	

}