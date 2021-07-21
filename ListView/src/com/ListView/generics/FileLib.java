package com.ListView.generics;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class FileLib {
		/**
		 * Reading the data from property file
		 * @param key
		 * @return
		 * @throws IOException
		 */
		public  String getPropertyValue(String key) throws IOException {
			 FileInputStream fis=new FileInputStream("./data/ListViewAutomation.xlsx");
			 Properties p=new Properties();
			 p.load(fis);
			 String value = p.getProperty(key);
			 return value;
			}
		/**
		 * This method is used read the data from Excel file
		 * @param sheetname
		 * @param row
		 * @param cell
		 * @return
		 * @throws EncryptedDocumentException
		 * @throws IOException
		 */
		public String getExcelValue(String sheetname,int row,int cell) throws EncryptedDocumentException, IOException {
			  FileInputStream fis=new FileInputStream("./data/ListViewAutomation.xlsx");
			  Workbook wb = WorkbookFactory.create(fis);
			  String value = wb.getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();
			  return value;
			 
			}

}