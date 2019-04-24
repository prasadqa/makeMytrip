package com.makemytrip.util;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExelUtil {
	public static FileInputStream fis;
	public static Workbook workbook;
	public ExelUtil()
	{ 
		try 
			{
				fis = new FileInputStream("D://NaveenAssignments//MakeMyTrip.Assignment//src//main//java//com//makemytrip//testdata//Input.xlsx");
				workbook = WorkbookFactory.create(fis);
			}
		catch (Exception e) 
			{
				e.printStackTrace();
			}
		
		
	}
	public int rowCount(String sheetName)
	{
		return workbook.getSheet(sheetName).getLastRowNum();
	}
	public int cellCount(String sheetName,int rowNumber)
	{
		return workbook.getSheet(sheetName).getRow(rowNumber).getLastCellNum();
	}
	public String getCellData(String sheetName,int rowNumber,int cellNumber)
	{ 
		String data = workbook.getSheet(sheetName).getRow(rowNumber).getCell(cellNumber).getStringCellValue();
		return data;
	}
}
