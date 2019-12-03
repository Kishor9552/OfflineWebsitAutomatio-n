package com.testngdata;

import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.impl.Log4JLogger;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.util.TestUtil;

public class LoginTest {
	static WebDriver driver;
@BeforeMethod
public static void setUp() {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Shree\\Desktop\\TestNgMaven\\chromedriver.exe");		
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.get("https://www.facebook.com");
	
	try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		
		e.printStackTrace();
	}
}
@DataProvider
public Object[][] getlogindata(){
	Object data[][]=TestUtil.getTestData("newlogindata");
	return data;
			
/*}
@Test(dataProvider="getlogindata") 
public void logintest(String uusernme,String pass) {
	driver.findElement(By.id("email")).sendKeys(uusernme);
	driver.findElement(By.id("pass")).sendKeys(pass);
	driver.findElement(By.id("loginbutton")).click();*/
}
@Test(dataProvider="getlogindata")
public void creartNewAccount(String firstname,String surname,String mail,String newpass,String month) {
	
	
	driver.findElement(By.name("firstname")).sendKeys(firstname);
	driver.findElement(By.name("lastname")).sendKeys(surname);
	driver.findElement(By.name("reg_email__")).sendKeys(mail);
	driver.findElement(By.name("reg_passwd__")).sendKeys(newpass);
	/*Select select=new Select(driver.findElement(By.name("birthday_day")));
	select.selectByIndex(1);*/
	Select select1=new Select(driver.findElement(By.name("birthday_month")));
	select1.selectByVisibleText(month);
	try {
		Thread.sleep(20000);
	} catch (InterruptedException e) {
		
		e.printStackTrace();
	}
	/*Select select2=new Select(driver.findElement(By.name("birthday_year")));
	select2.selectByValue("1994");*/
	try {
		Thread.sleep(2000);
		driver.findElement(By.id("u_0_7")).click();
	}catch (Exception e) {
		e.printStackTrace();
	}
	
	driver.findElement(By.name("websubmit")).click();
	
}
@AfterMethod
public void tesrdown() {
	driver.quit();
}
}

