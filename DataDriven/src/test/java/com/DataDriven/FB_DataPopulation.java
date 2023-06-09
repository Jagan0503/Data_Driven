package com.DataDriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FB_DataPopulation {
	
	static List<String> usernamelist = new ArrayList<>();
	static List<String> passwordlist = new ArrayList<>();
		
	public static void readData() throws IOException {
 
		File f = new File("C:\\Users\\USER\\eclipse-workspace\\Maven8AM\\DataDriven\\TestData.xlsx");//declare
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheet = wb.getSheetAt(1);
		int numberOfRows = sheet.getPhysicalNumberOfRows();
        for (int i = 0; i < numberOfRows; i++) {			
        	Row row = sheet.getRow(i);
        	int numberOfCells = row.getPhysicalNumberOfCells();     
        	int k = 0;
        	for (int j = 0; j < numberOfCells; j++) {
				
        		if (k % 2 == 0) {
        			
        			Cell cell = row.getCell(j);
        			usernamelist.add(cell.getStringCellValue());
					
				} else {
					
					Cell cell = row.getCell(j);
                    passwordlist.add(cell.getStringCellValue());
				}
        		k++;
			}      
		}
        wb.close();
		
	}
	
	public static void facebookLogin(String username, String password) {
         
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(co);
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("email")).sendKeys(username);
		driver.findElement(By.id("pass")).sendKeys(password);
		driver.findElement(By.name("login")).click();
		
	}
	
	public static void executeTest() {
        
		for (int i = 0; i < usernamelist.size() ; i++) {
			
			facebookLogin(usernamelist.get(i), passwordlist.get(i));
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		
		readData();
		System.out.println(usernamelist);
		System.out.println(passwordlist);
		executeTest();
		
	}

}
