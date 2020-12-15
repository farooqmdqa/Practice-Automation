package com.anblicks.readdata_p1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//Test Case 1: Log-in with valid username and password.

public class RD_PROP_TC1_Login_ValidCredentials {

	static WebDriver driver;

	public static void main(String[] args) throws IOException, InterruptedException {

		// Path of properties file and open it
		FileInputStream file = new FileInputStream(".//properties//data_properties.txt");

		// create object of Properties
		Properties prop = new Properties();

		prop.load(file);


		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();


		driver.get(prop.getProperty("baseURL"));

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.xpath(prop.getProperty("myaccountlink"))).click();

		driver.findElement(By.xpath(prop.getProperty("usernametxb"))).sendKeys(prop.getProperty("username1"));

		driver.findElement(By.xpath(prop.getProperty("passwordtxb"))).sendKeys(prop.getProperty("password1"));

		driver.findElement(By.xpath(prop.getProperty("loginbtn"))).click();

		
		String actual_text = driver.findElement(By.xpath(prop.getProperty("actual_text1"))).getText();

		System.out.println("Username is:"+ actual_text);


		if (actual_text.contains(prop.getProperty("exp_text1"))) {

			driver.findElement(By.xpath(prop.getProperty("signoutlink"))).click();

			System.out.println("RD_PROP_TC1_Login_ValidCredentials is passed:User log-in successfully");

		}else {

			System.out.println("RD_PROP_TC1_Login_ValidCredentials is failed");

		}

		driver.close();
	}


}


