
// 1. Execute the test case by creating single class, multiple static methods and main method to call static methods.
// or
// 2. Remove main method here and execute the test case by creating seperate single class and main method to call all static methods by class name.

// Goal : Main method should not have any line of code except method call.

package com.anblicks.refactor1_staticmethods;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

// Test Case 4: Log-in with empty username and correct password.
public class TC4_Login_Invalidcredentials_Smethods {

	// static variable 
	public static WebDriver driver;

	//  Create a method(static) "openBrowser" to instantiate the WebDriver and open the web browser.  
	public static void openBrowser(){

		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	
	// Create a method(static) "launchApplication" to enter the URL “http://practice.automationtesting.in/”
	public static void launchApplication() {

		driver.get("http://practice.automationtesting.in/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	
	
	// Create a method(static) "invalidCredentials" to enter the invalid user account credentials and click login button.
	public static void invalidCredentials() {

		driver.findElement(By.xpath("//a[contains(text(),'My Account')]")).click();

		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("");

		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("1Drefnam1!");

		driver.findElement(By.xpath("//input[@value='Login']")).click();

	}

	// Create a method(static) "validateLogin" to validate.
	public static void validateLogin() {	

		String actual_text = driver.findElement(By.cssSelector("ul.woocommerce-error:nth-child(1) > li")).getText();

		System.out.println("Validation message is:"+ actual_text);

		String exp_text = "Username is required.";

		if (actual_text.contains(exp_text)) {

			System.out.println("TC4_Login_Invalidcredentials is passed: User entered empty username and correct password");

		}else {

			System.out.println("TC4_Login_Invalidcredentials is failed");

		}

	}
	
	
	// Create a method(static) "closeBrowser" to close the web browser.
	public static void closeBrowser() {

		driver.close();

	}
	
	
	// 1. Create a main method to call all the static methods and execute the test case.
	// No need to create object for static methods. 
	// We can directly call the static methods and execute the test case.
	
	// or
	
	// 2. Remove below main method here and execute the test case by creating seperate single class and main method to call all static methods by class name.
	
	// Goal : Main method should not have any line of code except method call.
	
	public static void main(String[] args) {

		openBrowser();

		launchApplication();

		invalidCredentials();

		validateLogin();

		closeBrowser();

	}

}
