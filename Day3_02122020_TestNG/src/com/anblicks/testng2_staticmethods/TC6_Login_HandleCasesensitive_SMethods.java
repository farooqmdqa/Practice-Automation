
// Create Single Class and Static methods. 
// Execute the test case by Implementing TestNG annotations in seperate class(MainTestScript_SMethods) and call static methods by class name.

package com.anblicks.testng2_staticmethods;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

//Test Case 6: Login with valid case sensitive username and password. 

public class TC6_Login_HandleCasesensitive_SMethods {

	public static WebDriver driver;

	// Create a method(static) "openBrowserandlaunchApplication" to open web browser and launch application.
  	public static void openBrowserandlaunchApplication(){

		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://practice.automationtesting.in/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	// Create a method(static) "invalidCredentials" to enter valid case sensitive username and password, and click Login button.
	public static void invalidCredentials() {

		driver.findElement(By.xpath("//a[contains(text(),'My Account')]")).click();

		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("TESTUSER001");

		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("1DREFNAM1!");

		driver.findElement(By.xpath("//input[@value='Login']")).click();
	}
	
	// Create a method(static) "validateLogin" to validate.
		public static void validateLogin() {
			
		String actual_text = driver.findElement(By.cssSelector("ul.woocommerce-error:nth-child(1) > li")).getText();

		System.out.println("Validation message is:"+ actual_text);

		String exp_text = "TESTUSER001";

		//Assert.assertEquals(actual_text,exp_text,"TC6_Login_HandleCasesensitive is failed");
		
		Assert.assertTrue(actual_text.contains(exp_text), "TC6_Login_HandleCasesensitive is failed!");
		
		System.out.println("TC6_Login_HandleCasesensitive is passed!");

	}
		
	
	// Create a method(static) "closeBrowser" to close browser instance.	
	public static void closeBrowser() {

		driver.close();

	}

}
