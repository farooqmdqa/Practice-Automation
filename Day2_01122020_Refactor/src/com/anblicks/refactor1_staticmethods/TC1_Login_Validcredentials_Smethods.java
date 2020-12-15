
// 1. Execute the test case by creating single class, static methods and main method to call static methods.
// or
// 2. Remove main method here and execute the test case by creating seperate single class and main method to call all static methods by class name.

// Goal : Main method should not have any line of code except method call.

package com.anblicks.refactor1_staticmethods;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

// Test Case 1: Log-in with valid username and password.
public class TC1_Login_Validcredentials_Smethods {

	// static variable 
	public static WebDriver driver;


	//  Create a method(static) "openBrowser" to instantiate the WebDriver and open the web browser.  
	public static  void openBrowser(){

		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}


	// Create a method(static) "launchApplication" to enter the URL “http://practice.automationtesting.in/”
	public static void launchApplication() {

		driver.get("http://practice.automationtesting.in/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}


	// Create a method(static) "validCredentials" to enter the valid user account credentials and click login button.
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

		if (actual_text.equals(exp_text)) {

			System.out.println("TC1_Login_Validcredentials is passed:User log-in successfully");
		}else {

			System.out.println("TC1_Login_Validcredentials is failed");

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

		validCredentials();

		validateLogin();

		closeBrowser();

	}

}


