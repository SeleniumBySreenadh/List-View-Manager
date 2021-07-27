package com.ListView.POM;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ListView.generics.ListViewBaseClass;

public class CRM extends ListViewBaseClass{

 
	@Override
	public void CreateCRM() throws EncryptedDocumentException, IOException {
		
		
		
		WebElement Menu= driver.findElement(By.xpath(f.getExcelValue("Xpath", 6, 1)));
		wait.until(ExpectedConditions.elementToBeClickable(Menu));
		Menu.click();

		WebElement CRM= driver.findElement(By.xpath(f.getExcelValue("Xpath", 7, 1)));
		wait.until(ExpectedConditions.elementToBeClickable(CRM));
		CRM.click();

		WebElement Create= driver.findElement(By.xpath(f.getExcelValue("Xpath", 8, 1)));

		Create.click();
	
	}
	
}
