package com.ebayreg.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.utility.TestUtility;

public class EbayRegTest {
	WebDriver driver;

	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Vamshi\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.ebay.com/");

	}
	@DataProvider
	public Iterator<Object[]> getTestData(){
		ArrayList<Object[]> testData =TestUtility.getDataFromExcel();
		return testData.iterator();
	
	}

	@Test(dataProvider="getTestData")
	//@Test
	public  void EbayRegTest(String firstname, String lastname, String emailaddress, String password){
	//public void EbayRegTest(){

		WebElement registerBtn	=	driver.findElement(By.linkText("register"));
		Actions actions = new Actions(driver);
		actions.moveToElement(registerBtn).click().build().perform();
		driver.findElement(By.name("firstname")).clear();
		driver.findElement(By.name("firstname")).sendKeys(firstname);
		//driver.findElement(By.name("firstname")).sendKeys("Aarshi");

		
		driver.findElement(By.name("lastname")).clear();
		driver.findElement(By.name("lastname")).sendKeys(lastname);
		//driver.findElement(By.name("lastname")).sendKeys("kanha");

		
		driver.findElement(By.name("email")).clear();
		driver.findElement(By.name("email")).sendKeys(emailaddress);
		//driver.findElement(By.name("email")).sendKeys("Aarshi@gmail.com");

		
		driver.findElement(By.name("PASSWORD")).clear();
		driver.findElement(By.name("PASSWORD")).sendKeys(password);
		//driver.findElement(By.name("PASSWORD")).sendKeys("test123$");


		WebElement registerBtn1 = driver.findElement(By.xpath("//input[@id='ppaFormSbtBtn']"));
		Actions actions1 = new Actions(driver);
		actions1.moveToElement(registerBtn1).click().build().perform();


	}
	@AfterMethod
	public void teardown(){
		driver.quit();
		
		
	}
}
