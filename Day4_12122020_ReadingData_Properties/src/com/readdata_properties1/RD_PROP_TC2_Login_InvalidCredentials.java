package com.readdata_properties1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//Test Case 2: Log-in with incorrect username and incorrect password.

public class RD_PROP_TC2_Login_InvalidCredentials {

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

		driver.findElement(By.xpath(prop.getProperty("usernametxb"))).sendKeys(prop.getProperty("username2"));

		driver.findElement(By.xpath(prop.getProperty("passwordtxb"))).sendKeys(prop.getProperty("password2"));

		driver.findElement(By.xpath(prop.getProperty("loginbtn"))).click();

		
		String actual_text = driver.findElement(By.xpath(prop.getProperty("actual_text2"))).getText();

		System.out.println("Validation message is:"+ actual_text);


		if (actual_text.contains(prop.getProperty("exp_text2"))) {

			System.out.println("RD_PROP_TC2_Login_InvalidCredentials is passed:User entered incorrect username and incorrect password");

		}else {

			System.out.println("RD_PROP_TC2_Login_InvalidCredentials is failed");

		}

		driver.close();
	}


}


