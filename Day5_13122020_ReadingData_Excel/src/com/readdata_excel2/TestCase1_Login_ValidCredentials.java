package com.readdata_excel2;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase1_Login_ValidCredentials {

	public static WebDriver driver;

	@BeforeMethod
	public void openBrowserandlaunchApplication() {

		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("http://practice.automationtesting.in/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@SuppressWarnings("unused")
	@Test
	public void validCredentials() throws IOException {
		
		driver.findElement(By.xpath("//a[contains(text(),'My Account')]")).click();

		// Path of excel file and open it
		FileInputStream file = new FileInputStream(".//testData//LoginData.xlsx");

		// Excel Work book
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(file);

		// Excel sheet
		XSSFSheet sheet = workbook.getSheetAt(0);

		// total number of row
		int rowCount = sheet.getLastRowNum();

		System.out.println("Total no of rows are:" + rowCount);

		for (int i = 1; i <= rowCount; i++) {

			String username = sheet.getRow(i).getCell(0).getStringCellValue();

			driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);

			System.out.println("Input Username is:" + username);

			String password = sheet.getRow(i).getCell(1).getStringCellValue();

			driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);

			System.out.println("Input Password is:" + password);

			driver.findElement(By.xpath("//input[@value='Login']")).click();

			String actual_text = driver.findElement(By.xpath("//strong[contains(text(),'')]")).getText();

			System.out.println("Username is:" + actual_text);

			String exp_text = sheet.getRow(i).getCell(2).getStringCellValue();

			if (actual_text.contains(exp_text)) {

				driver.findElement(By.xpath("//a[contains(text(),'Sign out')]")).click();

				System.out.println("TestCase1 is passed:User log-in successfully");

			} else {

				System.out.println("TestCase1 is failed");

			}

			break;
		}
	}

	@AfterMethod
	public void closeBrowser() {

		driver.close();

	}

}
