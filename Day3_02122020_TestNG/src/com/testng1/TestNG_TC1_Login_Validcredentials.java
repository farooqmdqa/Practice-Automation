
// Implement TestNG instead of main method by creating methods and execute the test case with TestNG annotations methods.

package com.testng1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//Test Case 1: Log-in with valid username and password.

public class TestNG_TC1_Login_Validcredentials {

	public WebDriver driver;
	
	// Create a method "openBrowserandlaunchApplication" to open web browser and launch application.
    @BeforeMethod
	public void openBrowserandlaunchApplication(){

		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://practice.automationtesting.in/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

    // Create a method "validCredentials" to enter valid user account credentials and click Login button.
	@Test
	public void validCredentials() {

		driver.findElement(By.xpath("//a[contains(text(),'My Account')]")).click();
		
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("testuser001");
		
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("1Drefnam1!");
		
		driver.findElement(By.xpath("//input[@value='Login']")).click();
	}
	
	// Create a method "validateLogin" to validate.
	@Test
	public void validateLogin() {
		
		String actual_text = driver.findElement(By.xpath("//strong[contains(text(),'')]")).getText();

		System.out.println("Username is:"+ actual_text);

		String exp_text = "testuser001";
		
		//Assert.assertEquals(actual_text,exp_text,"TC1_Login_ValidCredentials is failed");
		
		Assert.assertTrue(actual_text.contains(exp_text), "TC1_Login_ValidCredentials is failed!");
		
		System.out.println("TC1_Login_ValidCredentials is passed!");
	}
	
	
	// Create a method "closeBrowser" to close browser instance.
    @AfterMethod
	public void closeBrowser() {

		driver.close();

	}

}


