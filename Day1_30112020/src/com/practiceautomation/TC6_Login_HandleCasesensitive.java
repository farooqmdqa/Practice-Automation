
// Execute the test case by creating single class and main method. 

package com.practiceautomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

// Test Case 6: Login with valid case sensitive username and password. 

public class TC6_Login_HandleCasesensitive {

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
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("TESTUSER001");
		
		// Step 5. Enter registered password in password textbox
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("1DREFNAM1!");
		
		// Step 6. Click on login button
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		// Step 7: Verify whether User is logged in or not
		String actual_text = driver.findElement(By.cssSelector("ul.woocommerce-error:nth-child(1) > li")).getText();
	    
		System.out.println("Validation message is:"+ actual_text);
		
		String exp_text = "TESTUSER001";
		
		if (actual_text.contains(exp_text)) {
			
			System.out.println("TC6_Login_HandleCasesensitive is passed:User entered username in case-sensitive");
 		}else {
			
			System.out.println("TC6_Login_HandleCasesensitive is failed");
			
		}

		// Step 8: Close the browser
		driver.close();
		
	}

}
