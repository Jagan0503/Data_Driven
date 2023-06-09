package com.DataDriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteData {
	
	public static void main(String[] args) throws IOException {
		
		File f = new File("C:\\Users\\USER\\eclipse-workspace\\Maven8AM\\DataDriven\\TestData.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheet = wb.createSheet("Credential");
		Row row = sheet.createRow(0);
		Cell cell = row.createCell(0);
		cell.setCellValue("Username");
		wb.getSheet("Credential").getRow(0).createCell(1).setCellValue("Password");
		wb.getSheet("Credential").createRow(1).createCell(0).setCellValue("Kandhavel");
		wb.getSheet("Credential").getRow(1).createCell(1).setCellValue("Kandha123");
		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);
		System.out.println("Succeeded");
		wb.close();
	}

}
