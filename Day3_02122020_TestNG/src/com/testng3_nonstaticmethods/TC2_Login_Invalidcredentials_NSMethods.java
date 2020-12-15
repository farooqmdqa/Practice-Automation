
// Create Single Class and Non-Static methods. 
// Execute the test case by Implementing TestNG annotations in seperate class(MainTestScript_NSMethods) and call non-static methods by creating object of class name.

package com.testng3_nonstaticmethods;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

//Test Case 2: Log-in with incorrect username and incorrect password.

public class TC2_Login_Invalidcredentials_NSMethods {

	public WebDriver driver;

	// Create a method(non-static) "openBrowserandlaunchApplication" to open web browser and launch application.
	public void openBrowserandlaunchApplication(){

		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("http://practice.automationtesting.in/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	// Create a method(non-static) "invalidCredentials" to enter incorrect username and incorrect password, and click Login button.
	public void invalidCredentials() {

		driver.findElement(By.xpath("//a[contains(text(),'My Account')]")).click();

		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("testuser123");

		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("1Drefnam1!");

		driver.findElement(By.xpath("//input[@value='Login']")).click();

	}

	// Create a method(non-static) "validateLogin" to validate.
	public void validateLogin() {

		String actual_text = driver.findElement(By.xpath("//div[@id='body']//li[1]")).getText();

		System.out.println("Validation message is:"+ actual_text);

		String exp_text = "Invalid username.";

		//Assert.assertEquals(actual_text,exp_text,"TC2_Login_InvalidCredentials is failed!");

		Assert.assertTrue(actual_text.contains(exp_text), "TC2_Login_InvalidCredentials is failed!");

		System.out.println("TC2_Login_InvalidCredentials is passed!");
	}
	

	// Create a method(non-static) "closeBrowser" to close browser instance.
	public void closeBrowser() {

		driver.close();

	}

}


