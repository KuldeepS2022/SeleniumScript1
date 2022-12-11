package com.KuldeepSingh.learningSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignupNaveen {
	WebDriver wd;
@BeforeMethod
public void setup() {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\deepg\\Downloads\\setup\\chromedriver.exe");
	wd=new ChromeDriver();
	wd.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
}
@Test
public void signUp() {
	WebElement fName=wd.findElement(By.cssSelector("input#input-firstname"));
	WebElement lName=wd.findElement(By.cssSelector("input#input-lastname"));
	WebElement eMail=wd.findElement(By.cssSelector("input#input-email"));
	WebElement pNumber=wd.findElement(By.cssSelector("input#input-telephone"));
	WebElement password=wd.findElement(By.cssSelector("input#input-password"));
	WebElement confirmPassword=wd.findElement(By.cssSelector("input#input-confirm"));
	WebElement subscribeForUpdates=wd.findElement(By.cssSelector("input[value='0']"));
	WebElement checkBox=wd.findElement(By.cssSelector("input[type=\"checkbox\"]"));
	WebElement buttonContinue=wd.findElement(By.cssSelector("input[value=\"Continue\"]"));
	
	fName.sendKeys("Peter");
	lName.sendKeys("Griffin");
	eMail.sendKeys("PeterLois@familyguy.com");
	pNumber.sendKeys("0000888822");
	password.sendKeys("StewieisOG");
	confirmPassword.sendKeys("StewieisOG");
	subscribeForUpdates.click();
	checkBox.click();
	buttonContinue.click();
	String currentTitle=wd.getTitle();
	System.out.println();
	
	Assert.assertEquals(currentTitle, "My Account","Something went wrong");
}
@AfterMethod
public void tearDown() {
	wd.close();
}
	
}
