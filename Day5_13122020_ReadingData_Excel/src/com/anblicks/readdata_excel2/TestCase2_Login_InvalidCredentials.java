package com.anblicks.readdata_excel2;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase2_Login_InvalidCredentials {

	public static WebDriver driver;


	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException, InterruptedException {

		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("http://practice.automationtesting.in/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//a[contains(text(),'My Account')]")).click();

		// Path of excel file and open it
		FileInputStream file = new FileInputStream(".//testData//LoginData.xlsx");

		// Excel Work book
		XSSFWorkbook workbook = new XSSFWorkbook(file);

		// Excel sheet
		XSSFSheet sheet = workbook.getSheetAt(0);

		// total number of row 
		int rowCount = sheet.getLastRowNum();

		System.out.println("Total no of rows are:"+ rowCount);
		
		for (int i=2; i<=rowCount; i++) {
				
			XSSFCell username = sheet.getRow(i).getCell(0);
			username.setCellType(username.getCellType());
			
			XSSFCell password = sheet.getRow(i).getCell(1);
			password.setCellType(password.getCellType());
			
			XSSFCell exptext = sheet.getRow(i).getCell(2);
			exptext.setCellType(exptext.getCellType());
	
			driver.findElement(By.xpath("//input[@id='username']")).clear();
			driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username.getStringCellValue());
			
			System.out.println("Input Username is:"+ username.getStringCellValue() );
			
			driver.findElement(By.xpath("//input[@id='password']")).clear();
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password.getStringCellValue());
		
			System.out.println("Input Password is:"+ password.getStringCellValue() );
			
			driver.findElement(By.xpath("//input[@value='Login']")).click();

			String actual_text = driver.findElement(By.xpath("//div[@id='body']//li[1]")).getText();

			System.out.println("Validation message is:"+ actual_text);

			String exp_text = exptext.getStringCellValue();
			
			if (actual_text.contains(exp_text)) {

				System.out.println("TestCase is passed");

			}else {

				System.out.println("TestCase is failed");

			}
		}

		driver.close();
	}


}


