package com.ListView.POM;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.ListView.generics.ListViewBaseClass;

public class LoginPage extends ListViewBaseClass{


	

	public void Login(String email, String password) throws EncryptedDocumentException, IOException {
	WebElement Email= driver.findElement(By.id(f.getExcelValue("Xpath", 3, 1)));
	WebElement Password= driver.findElement(By.id(f.getExcelValue("Xpath", 4, 1)));
	WebElement Login= driver.findElement(By.xpath(f.getExcelValue("Xpath", 5, 1)));
	
	
	Email.sendKeys(email);
	Password.sendKeys(password);
	
	wait.until(ExpectedConditions.elementToBeClickable(Login));

	
	Login.click();
	}
	
}