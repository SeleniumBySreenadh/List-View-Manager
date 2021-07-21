package com.ListView.POM;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ListView.generics.ListViewBaseClass;

public class Contact extends ListViewBaseClass{

 
	public void CreateContact() throws EncryptedDocumentException, IOException {
		
		
		
		WebElement Contact= driver.findElement(By.xpath(f.getExcelValue("Xpath", 9, 1)));
		System.out.println("Created Contact detials are :");
	
		Actions act =  new Actions(driver);
		act.moveToElement(Contact).click().perform();

		WebElement ContactName= driver.findElement(By.xpath(f.getExcelValue("Xpath", 10, 1)));
		System.out.println("Contact Name is "+ ContactName.getText());

		act.moveToElement(ContactName).click().perform();

		//Click on Edit button
		WebElement Edit= driver.findElement(By.xpath(f.getExcelValue("Xpath", 11, 1)));
		Edit.click();

		//Click on ExpectedClosingDate
		WebElement ExpectedClosingDate= driver.findElement(By.xpath(f.getExcelValue("Xpath", 12, 1)));
		wait.until(ExpectedConditions.elementToBeClickable(ExpectedClosingDate));	
		act.moveToElement(ExpectedClosingDate).click().perform();

		//Click on ClosingDate
		WebElement ClosingDate= driver.findElement(By.xpath(f.getExcelValue("Xpath", 13, 1)));
		wait.until(ExpectedConditions.elementToBeClickable(ClosingDate));	
		System.out.println("Closing Date is "+ ClosingDate.getText());

		act.moveToElement(ClosingDate).click().perform();
		
		//Click on Priority
		WebElement Priority= driver.findElement(By.xpath(f.getExcelValue("Xpath", 14, 1)));
		wait.until(ExpectedConditions.elementToBeClickable(Priority));	
		act.moveToElement(Priority).click().perform();

		//Click on Tags
		WebElement Tags= driver.findElement(By.xpath(f.getExcelValue("Xpath", 15, 1)));
		wait.until(ExpectedConditions.elementToBeClickable(Tags));	
		act.moveToElement(Tags).click().perform();

		//Click on Product
		WebElement Product= driver.findElement(By.xpath(f.getExcelValue("Xpath", 16, 1)));
		wait.until(ExpectedConditions.elementToBeClickable(Product));	
		System.out.println("Tag is "+ Product.getText());

		act.moveToElement(Product).click().perform();
		
		//Click on Save
		WebElement Save= driver.findElement(By.xpath(f.getExcelValue("Xpath", 17, 1)));
		wait.until(ExpectedConditions.elementToBeClickable(Save));	
		act.moveToElement(Save).click().perform();
		
	}
}