package com.DataDriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadParticularData {

	public static void main(String[] args) throws IOException {
		
		File f = new File("C:\\Users\\USER\\eclipse-workspace\\Maven8AM\\DataDriven\\TestData.xlsx");//declare
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheet = wb.getSheetAt(0);
		Row row = sheet.getRow(4);
		Cell cell = row.getCell(3);
		CellType cellType = cell.getCellType();
		if (cellType.equals(CellType.STRING)) {
			
			String cellValue = cell.getStringCellValue();
			System.out.println(cellValue);
			
		} else {
			
			double numericValue = cell.getNumericCellValue();
			int i = (int) numericValue;
			System.out.println(i);
		}		
		wb.close();
		
	}
	
	
	
}
