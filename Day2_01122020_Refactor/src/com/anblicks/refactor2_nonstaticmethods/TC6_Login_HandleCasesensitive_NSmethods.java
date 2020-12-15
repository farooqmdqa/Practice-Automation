
// 1. Execute the test case by creating single class, non-static methods and main method to call non-static methods.
// or
// 2. Remove main method here and execute the test case by creating seperate single class and main method to call all non-static methods by creating object of class name.

// Goal : Main method should not have any line of code except method call.

package com.anblicks.refactor2_nonstaticmethods;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//Test Case 6: Login with valid case sensitive username and password.
public class TC6_Login_HandleCasesensitive_NSmethods {

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
	

	// Create a method(non-static) "invalidCredentials" to enter the invalid user account credentials and click login button.
	public void invalidCredentials() {

		driver.findElement(By.xpath("//a[contains(text(),'My Account')]")).click();

		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("TESTUSER001");

		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("1DREFNAM1!");

		driver.findElement(By.xpath("//input[@value='Login']")).click();

	}
	
	// Create a method(non-static) "validateLogin" to validate.
	public void validateLogin() {	

		String actual_text = driver.findElement(By.cssSelector("ul.woocommerce-error:nth-child(1) > li")).getText();

		System.out.println("Validation message is:"+ actual_text);

		String exp_text = "TESTUSER001";

		if (actual_text.contains(exp_text)) {

			System.out.println("TC6_Login_HandleCasesensitive is passed:User entered username in case-sensitive");
		}else {

			System.out.println("TC6_Login_HandleCasesensitive is failed");

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
		
		TC6_Login_HandleCasesensitive_NSmethods tc6 = new TC6_Login_HandleCasesensitive_NSmethods();
		
		tc6.openBrowser();
		
		tc6.launchApplication();
		
		tc6.invalidCredentials();
		
		tc6.validateLogin();
		
		tc6.closeBrowser();
	}

}
