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

public class ReadAllData {
	
	public static void main(String[] args) throws IOException {		
		File f = new File("C:\\Users\\USER\\eclipse-workspace\\Maven8AM\\DataDriven\\TestData.xlsx");//declare
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheet = wb.getSheetAt(0);
		int numberOfRows = sheet.getPhysicalNumberOfRows();
        //System.out.println(numberOfRows);
        for (int i = 0; i < numberOfRows; i++) {			
        	Row row = sheet.getRow(i);
        	int numberOfCells = row.getPhysicalNumberOfCells();      	
        	for (int j = 0; j < numberOfCells; j++) {
				Cell cell = row.getCell(j);
				CellType cellType = cell.getCellType();
				if (cellType.equals(CellType.STRING)) {					
					String cellValue = cell.getStringCellValue();
					System.out.println(cellValue);				
				} else {				
					double numericValue = cell.getNumericCellValue();
					long k = (long) numericValue;
					System.out.println(k);
				}		
			}        	
		}
        wb.close();
		
	}

}
