package com.anblicks.readdata_excel1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UserLoginDDT {

	public static WebDriver driver;


	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException, InterruptedException {

		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("http://practice.automationtesting.in/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[contains(text(),'My Account')]")).click();

		FileInputStream file = new FileInputStream(".//testData//LoginData.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook(file);

		XSSFSheet sheet = workbook.getSheetAt(0);

		int rowCount = sheet.getLastRowNum();

		System.out.println("Total rows are:"+ rowCount);



		for (int row =1; row <= rowCount; row++) {

			XSSFRow current_row = sheet.getRow(row);

			String username = current_row.getCell(0).getStringCellValue();

			System.out.println("Input Username is:"+ username );


			driver.findElement(By.xpath("//input[@id='username']")).clear();
			driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);


			String password = current_row.getCell(1).getStringCellValue();

			System.out.println("Input Password is:"+ password );

			driver.findElement(By.xpath("//input[@id='password']")).clear();
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);


			driver.findElement(By.xpath("//input[@value='Login']")).click();

			Thread.sleep(1000);


			while(true) {

				String actual_text = driver.findElement(By.xpath("//strong[contains(text(),'')]")).getText();

				System.out.println("Username is:"+ actual_text);

				String exp_text = current_row.getCell(2).getStringCellValue();

				if (actual_text.contains(exp_text)) {

					driver.findElement(By.xpath("//a[contains(text(),'Sign out')]")).click();

					System.out.println("TestCase is passed");

					break;

				}else {

					String actual_text1 = driver.findElement(By.xpath("//div[@id='body']//li[1]")).getText();

					System.out.println("Username is:"+ actual_text1);

					String exp_text1 = current_row.getCell(2).getStringCellValue();

					if (actual_text1.contains(exp_text1)) {

						System.out.println("TestCase is passed");

					}else {

						System.out.println("TestCase is failed");

					}
				}

				driver.close();

			}}}
}


