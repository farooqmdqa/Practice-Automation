package com.readdata_excel1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RD_EXCEL_TC3_Login_InvalidCredentials {

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

		XSSFRow current_row = sheet.getRow(3);

		String username = current_row.getCell(0).getStringCellValue();

		System.out.println("Input Username is:"+ username );

		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
		
		//String password = current_row.getCell(1).getStringCellValue();
		
		//System.out.println("Input Password is:"+ password );

		//driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);

		driver.findElement(By.xpath("//input[@value='Login']")).click();

		String actual_text = driver.findElement(By.xpath("//div[@id='body']//li[1]")).getText();
		
		System.out.println("Validation message is:"+ actual_text);

		String exp_text = current_row.getCell(2).getStringCellValue();

		if (actual_text.contains(exp_text)) {

			System.out.println("TestCase3 is passed: User entered correct username and empty password");

		}else {

			System.out.println("TestCase3 is failed.");

		}

		driver.close();
	}


}


