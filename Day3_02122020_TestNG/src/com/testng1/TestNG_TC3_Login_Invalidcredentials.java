
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

//Test Case 3: Log-in with correct username and empty password.

public class TestNG_TC3_Login_Invalidcredentials {


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

	// Create a method "invalidCredentials" to enter correct username and empty password, and click Login button.
	@Test
	public void invalidCredentials() {

		driver.findElement(By.xpath("//a[contains(text(),'My Account')]")).click();

		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("testuser001");

		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("");

		driver.findElement(By.xpath("//input[@value='Login']")).click();
	}

	// Create a method "validateLogin" to validate.
	@Test
	public void validateLogin() {

		String actual_text = driver.findElement(By.cssSelector("ul.woocommerce-error:nth-child(1) > li")).getText();

		System.out.println("Validation message is:"+ actual_text);

		String exp_text = "Password is required.";

		//Assert.assertEquals(actual_text,exp_text,"TC3_Login_InvalidCredentials is failed");

		Assert.assertTrue(actual_text.contains(exp_text), "TC3_Login_InvalidCredentials is failed!");

		System.out.println("TC3_Login_InvalidCredentials is passed!");

	}

	// Create a method "closeBrowser" to close browser instance.
	@AfterMethod
	public void closeBrowser() {

		driver.close();

	}

}
