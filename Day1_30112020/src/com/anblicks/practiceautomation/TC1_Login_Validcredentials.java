
// Execute the test case by creating single class and main method. 

package com.anblicks.practiceautomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

// Test Case 1: Log-in with valid username and password.

public class TC1_Login_Validcredentials {

	public static void main(String[] args) {

		// Step 1. Open the browser
		// Instantiate WebDriver 
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Step 2. Enter the URL “http://practice.automationtesting.in/”
		driver.get("http://practice.automationtesting.in/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// Step 3. Click on My Account Menu
		driver.findElement(By.xpath("//a[contains(text(),'My Account')]")).click();

		// Step 4. Enter registered username in username textbox
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("testuser001");
		
		// Step 5. Enter registered password in password textbox
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("1Drefnam1!");
		
		// Step 6. Click on login button
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		// Step 7: Verify whether User is logged in or not
		String actual_text = driver.findElement(By.xpath("//strong[contains(text(),'')]")).getText();
	    
		System.out.println("Username is:"+ actual_text);
		
		String exp_text = "testuser001";
	
		if (actual_text.equals(exp_text)) {
			
			System.out.println("TC1_Login_Validcredentials is passed: User log-in successfully");
 		}else {
			
			System.out.println("TC1_Login_Validcredentials is failed");
			
		}

		// Step 8: Close the browser
		driver.close();
		
	}

}
