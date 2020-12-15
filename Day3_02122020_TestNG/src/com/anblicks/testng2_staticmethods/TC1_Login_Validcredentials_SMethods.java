
// Create Single Class and Static methods. 
// Execute the test case by Implementing TestNG annotations in seperate class(MainTestScript_SMethods) and call static methods by class name.

package com.anblicks.testng2_staticmethods;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

//Test Case 1: Log-in with valid username and password.

public class TC1_Login_Validcredentials_SMethods {

	public static WebDriver driver;
	
	// Create a method(static) "openBrowserandlaunchApplication" to open web browser and launch application.
	public static void openBrowserandlaunchApplication(){

		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://practice.automationtesting.in/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

    // Create a method(static) "validCredentials" to enter valid user account credentials and click Login button.
	public static void validCredentials() {

		driver.findElement(By.xpath("//a[contains(text(),'My Account')]")).click();
		
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("testuser001");
		
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("1Drefnam1!");
		
		driver.findElement(By.xpath("//input[@value='Login']")).click();
	}
	
	// Create a method(static) "validateLogin" to validate.
	public static void validateLogin() {
		
		String actual_text = driver.findElement(By.xpath("//strong[contains(text(),'')]")).getText();

		System.out.println("Username is:"+ actual_text);

		String exp_text = "testuser001";
		
		//Assert.assertEquals(actual_text,exp_text,"TC1_Login_ValidCredentials is failed");
		
		Assert.assertTrue(actual_text.contains(exp_text), "TC1_Login_ValidCredentials is failed!");
		
		System.out.println("TC1_Login_ValidCredentials is passed!");
	}
	
	
	// Create a method(static) "closeBrowser" to close browser instance.
	public static void closeBrowser() {

		driver.close();

	}

}


