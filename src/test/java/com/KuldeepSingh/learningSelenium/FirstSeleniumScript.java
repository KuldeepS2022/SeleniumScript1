package com.KuldeepSingh.learningSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;




public class FirstSeleniumScript {
	WebDriver wb;
	@BeforeMethod
	public void setup() {
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\deepg\\Downloads\\setup\\chromedriver.exe");
		System.setProperty("webdriver.edge.driver", "C:\\Users\\deepg\\Downloads\\setup\\msedgedriver.exe");
		//wb=new ChromeDriver();
		wb=new EdgeDriver();
	wb.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
	}
	@Test
	public void verifyLoginTest() {
		WebElement userName=wb.findElement(By.cssSelector("input#input-email"));
		WebElement password=wb.findElement(By.cssSelector("input#input-password"));
		WebElement button=wb.findElement(By.cssSelector("input[value='Login']"));
		userName.sendKeys("PeterLois@familyguy.com");
		password.sendKeys("StewieisOG");
		button.click();
		String titleOfPage=wb.getTitle();
		System.out.println(titleOfPage);
		Assert.assertEquals(titleOfPage, "My Account","Failed");
		
	}
	@AfterMethod
	public void tearDown() {
		wb.close();
	}
}
