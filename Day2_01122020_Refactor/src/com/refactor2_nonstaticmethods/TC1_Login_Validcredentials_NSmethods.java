
// 1. Execute the test case by creating single class, non-static methods and main method to call non-static methods.
// or
// 2. Remove main method here and execute the test case by creating seperate single class and main method to call all non-static methods by creating object of class name.

// Goal : Main method should not have any line of code except method call.

package com.refactor2_nonstaticmethods;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//Test Case 1: Log-in with valid username and password.
public class TC1_Login_Validcredentials_NSmethods {

	public WebDriver driver;

	//  Create a method(non-static) "openBrowser" to instantiate the WebDriver and open the web browser.  
	public void openBrowser(){

		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	// Create a method(non-static) "launchApplication" to enter the URL “http://practice.automationtesting.in/”
	public void launchApplication() {

		driver.get("http://practice.automationtesting.in/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	// Create a method(non-static) "validCredentials" to enter the valid user account credentials and click login button.
	public void validCredentials() {

		driver.findElement(By.xpath("//a[contains(text(),'My Account')]")).click();
		
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("testuser001");
		
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("1Drefnam1!");
		
		driver.findElement(By.xpath("//input[@value='Login']")).click();

	}

	// Create a method(non-static) "validateLogin" to validate.
	public void validateLogin() {

		String actual_text = driver.findElement(By.xpath("//strong[contains(text(),'')]")).getText();

		System.out.println("Username is:"+ actual_text);

		String exp_text = "testuser001";

		if (actual_text.equals(exp_text)) {

			System.out.println("TC1_Login_Validcredentials is passed:User log-in successfully");
		}else {

			System.out.println("TC1_Login_Validcredentials is failed");

		}
	}

	// Create a method(non-static) "closeBrowser" to close the web browser.
	public void closeBrowser() {

		driver.close();

	}

	// 1. Create a main method to call all the non-static methods by creating object of class name and execute the test case.

	// or
	
	// 2. Remove main method here and execute the test case by creating seperate single class and main method to call all non-static methods by creating object of class name.
	
	// Goal : Main method should not have any line of code except method call.
	
	public static void main(String[] args) {
		
		TC1_Login_Validcredentials_NSmethods tc1 = new TC1_Login_Validcredentials_NSmethods();

		tc1.openBrowser();

		tc1.launchApplication();

		tc1.validCredentials();

		tc1.validateLogin();

		tc1.closeBrowser();

	}

}


