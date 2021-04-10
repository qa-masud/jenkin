package com.readExcel;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import ups.nj.supperpage.CucumberBaseClass;


public class ReadExcelData extends CucumberBaseClass{
		public String path = "/Users/mohammedalam/git/repository3/CucumberBDD/TestData/testData.xlsx";

	    public ArrayList<String> readExcel(int colno) throws IOException	{		
		FileInputStream read = new FileInputStream(path);				
		XSSFWorkbook workbook = new XSSFWorkbook(read);				
	    XSSFSheet sheet = workbook.getSheet("data");	       
	    Iterator<Row> rowiterator = sheet.iterator();
	    rowiterator.next();    
	    ArrayList<String> list = new ArrayList<String>();	    
	    while(rowiterator.hasNext()) {
	    	list.add(rowiterator.next().getCell(colno).getStringCellValue());
	    }
	    return list;
	}	
	@Test
	public void loginWebZooplaPage() throws IOException {	
		//System.out.println("This  is my userName : "+readExcel(0));
		//System.out.println("This  is my password : "+readExcel(1));
				
        System.setProperty("webdriver.chrome.driver", "/Applications/chromedriver");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		driver.get("https://www.zoopla.co.uk/");				
		driver.findElement(By.xpath("(//*[text()='Accept all cookies'])[2]")).click();
		driver.findElement(By.xpath("(//*[text()='Sign in'])[1]")).click();
				
		ArrayList<String> userName = readExcel(0);
		ArrayList<String> pwd = readExcel(1);
		for (int i =0; i<userName.size(); i++) {		
			
		driver.findElement(By.cssSelector("#signin_email")).sendKeys(userName.get(i));
		System.out.println("This is a my userName : "+ userName.get(i));
		driver.findElement(By.cssSelector("#signin_password")).sendKeys(pwd.get(i));	
		System.out.println("This is a my password : "+ pwd.get(i));
		driver.findElement(By.id("signin_submit")).click();		
	}
	
}}
