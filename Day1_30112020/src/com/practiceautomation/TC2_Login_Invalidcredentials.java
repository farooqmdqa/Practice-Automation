
// Execute the test case by creating single class and main method. 

package com.practiceautomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

// Test Case 2: Log-in with incorrect username and incorrect password.

public class TC2_Login_Invalidcredentials {

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

		// Step 4. Enter incorrect username in username textbox
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("testuser123");
		
		// Step 5. Enter incorrect password in password textbox.
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("1Drefnam1");
		
		// Step 6. Click on login button
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		// Step 7: Proper error must be displayed(ie Invalid username) and prompt to enter login again
		String actual_text = driver.findElement(By.xpath("//div[@id='body']//li[1]")).getText();
		
		System.out.println("Validation message is:"+ actual_text);
		
		String exp_text = "Invalid username.";
		
		if (actual_text.contains(exp_text)) {
			
			System.out.println("TC2_Login_Invalidcredentials is passed: User entered incorrect username and incorrect password");
			
		}else {
			
			System.out.println("TC2_Login_Invalidcredentials is failed");
			
		}

		// Step 8: Close the browser
		driver.close();
		
	}

}
