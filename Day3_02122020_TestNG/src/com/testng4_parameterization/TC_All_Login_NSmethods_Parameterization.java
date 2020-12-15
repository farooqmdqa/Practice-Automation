// Create Single Class and Non-Static methods. 
// Execute the test case/test cases by Implementing TestNG annotations in seperate class(MainTestScript_NSM) and call non-static methods by creating object of class name.

package com.testng4_parameterization;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TC_All_Login_NSmethods_Parameterization {

	public WebDriver driver;


	//  Create a method(non-static) "openBrowser" to instantiate and open the web browser.  
	public void openBrowserandlaunchApplication(String url){

		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

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

		//Assert.assertEquals(actual_text1,exp_text1,"TC1_Login_ValidCredentials is failed");

		Assert.assertTrue(actual_text1.contains(exp_text1), "TC1_Login_ValidCredentials is failed!");

		System.out.println("TC1_Login_ValidCredentials is passed!");


	}


	// Create a method(non-static) "validateLogin2" to validate from the test case2 to test case6

	public void validateLogin2(String exp_text2) {

		String actual_text2 = driver.findElement(By.cssSelector("ul.woocommerce-error:nth-child(1) > li")).getText();

		System.out.println("Validation message is:"+ actual_text2);

		//Assert.assertEquals(actual_text,exp_text,"TC_Login_InvalidCredentials is failed!");

		Assert.assertTrue(actual_text2.contains(exp_text2), "TC_Login_InvalidCredentials is failed!");

		System.out.println("TC_Login_InvalidCredentials is passed!");
	}

	// Create a method(non-static) "signOut" for test case7
	public void signOut() {

		driver.findElement(By.xpath("//a[contains(text(),'Sign out')]")).click();

		driver.navigate().back();

	}

	// Create a method(non-static) "validateLogin3" to validate the test case7

	public void validateLogin3(String exp_text3) {

		String actual_text3 = driver.findElement(By.cssSelector("//h2[contains(text(),'Login')]")).getText();

		System.out.println("Validation message is:"+ actual_text3);

		//Assert.assertEquals(actual_text,exp_text,"TC7_Login_Authentication is failed!");

		Assert.assertTrue(actual_text3.contains(exp_text3), "TC7_Login_Authentication is failed!");

		System.out.println("TC7_Login_Authentication is passed!");

	}


	// Create a method(non-static) "closeBrowser" to close the web browser.
	public void closeBrowser() {

		driver.close();	

	}

}
