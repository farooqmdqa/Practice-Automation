
// 1. Execute the test case/ test cases by creating single class, non-static methods and main method to call non-static methods by creating object of class name where methods are parameterized by providing arguments inside it.
// or
// 2. Remove main method here and execute the test case/ test cases by creating seperate single class and main method to call non-static methods by creating object of class name where methods are parameterized by providing arguments inside it.

// Goal : Main method should not have any line of code except method call.

package com.refactor3_parameterization;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_All_Login_NonStaticmethods {
	
	public WebDriver driver;

	
	//  Create a method(non-static) "openBrowser" to instantiate the WebDriver and open the web browser.  
	public void openBrowser(){
		
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	
	}
	
	// Create a method(non-static) "launchApplication" with argument i.e.url 
	public void launchApplication(String url){
		
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	// Create a method(non-static) "inputCredentials" with arguments username, password.
	public void inputCredentials(String username, String password){
		
		driver.findElement(By.xpath("//a[contains(text(),'My Account')]")).click();
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@value='Login']")).click();
	}
	
	// Create a method(non-static) "validateLogin1" to validate the test case1
	public void validateLogin1(String exp_text1) {
		
		String actual_text1 = driver.findElement(By.xpath("//strong[contains(text(),'')]")).getText();
	    
		System.out.println("Username is:"+ actual_text1);
				
		if (actual_text1.contains(exp_text1)) {
			
			System.out.println("TestCase1 is passed.");
 		}else {
			
			System.out.println("TestCase1 is failed.");
			
		}
	}
	
	// Create a method(non-static) "validateLogin2" to validate from the test case2 to test case6
	public void validateLogin2(String exp_text2) {
		
		String actual_text2 = driver.findElement(By.cssSelector("ul.woocommerce-error:nth-child(1) > li")).getText();
	    
		System.out.println("Validation message is:"+ actual_text2);
				
		if (actual_text2.contains(exp_text2)) {
			
			System.out.println("TestCase is passed.");
 		}else {
			
			System.out.println("TestCase is failed.");
			
		}
	}
	
	
	// Create a method(non-static) "validateLogin3" to validate the test case7
	public void validateLogin3(String exp_text3) {
		
		String actual_text3 = driver.findElement(By.cssSelector("//h2[contains(text(),'Login')]")).getText();
	    
		System.out.println("Validation message is:"+ actual_text3);
				
		if (actual_text3.contains(exp_text3)) {
			
			System.out.println("TestCase7 is passed.");
 		}else {
			
			System.out.println("TestCase7 is failed.");
			
		}
	}
	
	// Create a method(non-static) "signOut" for test case7
	public void signOut() {
				
		driver.findElement(By.xpath("//a[contains(text(),'Sign out')]")).click();
		
		driver.navigate().back();
		
	}
	
	// Create a method(non-static) "closeBrowser" to close the web browser.
	public void closeBrowser() {
		
		driver.close();	
		
	}

	
	// 1. Create a main method to call all non-static methods and execute the test case/test cases where methods are parameterized by arguments inside it.

	// or
	
	// 2. Remove below main method here and execute the test case/ test cases by creating seperate single class and main method to call non-static methods by creating object of class name where methods are parameterized..
	
	// Goal : Main method should not have any line of code except method call.
	
	
	public static void main(String[] args) throws Exception {
		
		// Test Case 1: Log-in with valid user name and password.
		
		TC_All_Login_NonStaticmethods tc = new TC_All_Login_NonStaticmethods();
		
		tc.openBrowser();
		
		tc.launchApplication("http://practice.automationtesting.in/");
		
		tc.inputCredentials("testuser001", "1Drefnam1!");
		
		tc.validateLogin1("testuser001");
		
		tc.closeBrowser();
		
		
		// Test Case 2: Log-in with incorrect username and incorrect password.
		
		tc.openBrowser();
		
		tc.launchApplication("http://practice.automationtesting.in/");
			    
		tc.inputCredentials("testuser123", "1Drefnam");
		
		tc.validateLogin2("Invalid Username.");
		
		tc.closeBrowser();
		
		
		// Test Case 3: Log-in with correct username and empty password.
		
		tc.openBrowser();
		
		tc.launchApplication("http://practice.automationtesting.in/");
				
		tc.inputCredentials("testuser001", "");
		
		tc.validateLogin2("Password is required.");
		
		tc.closeBrowser();
		
		
		// Test Case 4: Log-in with empty username and correct password.
		
		tc.openBrowser();
		
		tc.launchApplication("http://practice.automationtesting.in/");
		
		tc.inputCredentials("", "1Drefnam1!");
		
		tc.validateLogin2("Username is required.");
		
		tc.closeBrowser();
		
		
		// Test Case 5: Log-in with empty username and empty password.
		
		tc.openBrowser();
		
		tc.launchApplication("http://practice.automationtesting.in/");
		
		tc.inputCredentials("", "");
		
		tc.validateLogin2("Username is required.");
		
		tc.closeBrowser();

		
		// Test Case 6: Login with valid case sensitive user name and password.
		
		tc.openBrowser();
		
		tc.launchApplication("http://practice.automationtesting.in/");
		
		tc.inputCredentials("TESTUSER001", "1DREFNAM1!");
		
		tc.validateLogin2("TESTUSER001");
		
		tc.closeBrowser();
		
		// Test Case 7: Login with valid user name and password, Sign Out, Navigate back to verify if users is in login page or not.
		
		tc.openBrowser();
		
		tc.launchApplication("http://practice.automationtesting.in/");
		
		tc.inputCredentials("testuser001", "1Drefnam1!");
		
		tc.signOut();
		
		tc.validateLogin3("Login");
		
		tc.closeBrowser();
		
	}

}
