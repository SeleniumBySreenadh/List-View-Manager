package com.ListView.generics;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.ListView.POM.CRM;
import com.ListView.POM.Contact;
import com.ListView.POM.LoginPage;


public class ListViewBaseClass {


	//Declaring WebDriver driver 
	public static WebDriver driver;							
	public static WebDriverWait wait;
	//Created object of FileLib Class, To access the values  present in Data Folders
	public FileLib f=new FileLib();								

	@BeforeTest
	//This method will opens the browser
	public void openBrowser() throws IOException {               

	String browser = f.getExcelValue("Xpath", 1, 1);
	String url = f.getExcelValue("Xpath", 2, 1);

	//Initialization of driver
	if(browser.equals("Chrome")) {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver=new ChromeDriver();
}
	if(browser.equals("firefox")) {
		 System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
		 driver=new FirefoxDriver();
	}
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 wait=new WebDriverWait(driver, 20);

	 driver.get(url);
}

	@BeforeMethod
	//Method for login
	public void SignUp() throws IOException, InterruptedException {	
		
		String email = f.getExcelValue("Xpath", 3, 2);
		String password = f.getExcelValue("Xpath", 4 ,2); 
		
		//SignUpPage Object is Created to call signIn()
		LoginPage singup = new LoginPage();	
		singup.Login(email, password);
	}
	
	@AfterMethod
	public void CreateCRM() throws EncryptedDocumentException, IOException {
		//Click on CRM
		CRM crm=new CRM(); 
		crm.CreateCRM();
		
		//Creating a Contact in CRM
		Contact contact= new Contact();
		contact.CreateContact();

	}
	
	@AfterTest
	//This method will close the browser
	public void closeBrowser() {							
	 driver.close();
	}
}