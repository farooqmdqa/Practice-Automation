
// 1. Execute the test case by creating single class, non-static methods and main method to call non-static methods.
// or
// 2. Remove main method here and execute the test case by creating seperate single class and main method to call all non-static methods by creating object of class name.

// Goal : Main method should not have any line of code except method call.

package com.anblicks.refactor2_nonstaticmethods;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//Test Case 7: Login with valid username and password, Sign Out, Navigate back to verify user is in login page or not.
public class TC7_Login_Authentication_NSmethods {

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

	// Create a method(non-static) "handleAuthentication" to enter the valid user account credentials and click login button.
	public void handleAuthentication() {

		driver.findElement(By.xpath("//a[contains(text(),'My Account')]")).click();

		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("testuser001");

		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("1Drefnam1!");

		driver.findElement(By.xpath("//input[@value='Login']")).click();

		driver.findElement(By.xpath("//a[contains(text(),'Sign out')]")).click();

		driver.navigate().back();

	}
	
	// Create a method(non-static) "validateLogin" to validate.
	public void validateLogin() throws Exception {	
		
		Thread.sleep(10000);

		String actual_text = driver.findElement(By.xpath("//h2[contains(text(),'Login')]")).getText();

		System.out.println("Validation message is:"+ actual_text);

		String exp_text = "Login";

		if (actual_text.contains(exp_text)) {

			System.out.println("TC7_Login_Authentication is passed:User stays on Login page");
		}else {

			System.out.println("TC7_Login_Authentication is failed");

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
	
	public static void main(String[] args) throws Exception {
		
		TC7_Login_Authentication_NSmethods tc7 = new TC7_Login_Authentication_NSmethods();
		
		tc7.openBrowser();
		
		tc7.launchApplication();
		
		tc7.handleAuthentication();
		
		tc7.validateLogin();
		
		tc7.closeBrowser();
	}
}
