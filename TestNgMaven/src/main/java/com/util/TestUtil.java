package com.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class TestUtil {
	static Workbook book;
	static Sheet sheet;
	public static String pathOfSheet="C:\\Users\\Shree\\Desktop\\TestNgMaven\\src\\main\\java\\com\\testdata\\logindataForNewAccount.xlsx";
	public static Object[][] getTestData(String newlogindata){
		FileInputStream fis=null;
		try {
			fis=new FileInputStream(pathOfSheet);
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}try {
			book=WorkbookFactory.create(fis);
		}catch (InvalidFormatException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
			}
		sheet=book.getSheet(newlogindata);
		Object [][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0;i<sheet.getLastRowNum();i++) {
			for(int k=0;k<sheet.getRow(0).getLastCellNum();k++) {
				data[i][k]=sheet.getRow(i+1).getCell(k).toString();
			}
		}
		
		return data;
		
	}
	

}
