
// Execute the test case by creating single class and main method.  

package com.practiceautomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

// Test Case 3: Log-in with correct username and empty password.

public class TC3_Login_Invalidcredentials {

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

		// Step 4. Enter valid username in username textbox
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("testuser001");
		
		// Step 5. Now enter empty password in the password textbox
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("");
		
		// Step 6. Click on login button
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		// Step 7: Proper error must be displayed(ie Password is required.) and prompt to enter login again
		String actual_text = driver.findElement(By.xpath("//div[@id='body']//li[1]")).getText();
		
		System.out.println("Validation message is:"+ actual_text);
		
		String exp_text = "Password is required.";
		
		if (actual_text.contains(exp_text)) {
			
			System.out.println("TC3_Login_Invalidcredentials is passed: User entered correct username and empty password");
			
		}else {
			
			System.out.println("TC3_Login_Invalidcredentials is failed");
			
		}

		// Step 8: Close the browser
		driver.close();
		
	}

}
