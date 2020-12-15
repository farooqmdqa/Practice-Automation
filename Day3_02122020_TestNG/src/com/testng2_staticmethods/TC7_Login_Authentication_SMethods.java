
// Create Single Class and Static methods. 
// Execute the test case by Implementing TestNG annotations in seperate class(MainTestScript_SMethods) and call static methods by class name.

package com.testng2_staticmethods;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

//Test Case 7: Login with valid username and password, Sign Out, Navigate back to verify user is in login page or not.

public class TC7_Login_Authentication_SMethods {

	public static WebDriver driver;

	// Create a method(static) "openBrowserandlaunchApplication" to open web browser and launch application.

  	public static void openBrowserandlaunchApplication(){

		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://practice.automationtesting.in/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	 // Create a method "handleAuthentication" to enter valid user account credentials, click Login button, Sign out and navigate back.

	public static void handleAuthentication() throws Exception {

		driver.findElement(By.xpath("//a[contains(text(),'My Account')]")).click();

		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("testuser001");

		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("1Drefnam1!");

		driver.findElement(By.xpath("//input[@value='Login']")).click();

		driver.findElement(By.xpath("//a[contains(text(),'Sign out')]")).click();

		driver.navigate().back();
		
	}
	
	// Create a method(static) "validateLogin" to validate.

	public static void validateLogin() throws InterruptedException {

		Thread.sleep(1000);

		String actual_text = driver.findElement(By.xpath("//h2[contains(text(),'Login')]")).getText();

		System.out.println("Validation message is:"+ actual_text);

		String exp_text = "Login";

		//Assert.assertEquals(actual_text,exp_text,"TC7_Login_Authentication is failed!");
		
		Assert.assertTrue(actual_text.contains(exp_text), "TC7_Login_Authentication is failed!");
				
		System.out.println("TC7_Login_Authentication is passed!");
		
	}
	
	
	// Create a method(static) "closeBrowser" to close browser instance.
	public static void closeBrowser() {

		driver.close();

	}

}
