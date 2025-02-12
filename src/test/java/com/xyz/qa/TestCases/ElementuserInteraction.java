package com.xyz.qa.TestCases;

import org.openqa.selenium.NoSuchElementException;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.xyz.qa.base.TestBase;

public class ElementuserInteraction extends TestBase {
    

   By username= By.xpath("//input[@id='name']");
   By password= By.xpath("//input[@id='email']");
   By checkbox=By.xpath("//label[normalize-space()='Sunday']");
   By countryDropDown= By.xpath("//select[@id='country']");
   By choseButton= By.xpath("//input[@id='singleFileInput']");
 
	@Test(priority = 0)
	public void fill_Form() throws InterruptedException
	{
		driver=getdriver();
		driver.findElement(username).sendKeys("koushik");
		Thread.sleep(1000);
		driver.findElement(password).sendKeys("koushik@134");
		Thread.sleep(1000);
		try {
			if(driver.findElement(checkbox).isDisplayed())
			{
				driver.findElement(checkbox).click();
				Thread.sleep(1000);
				System.out.println("displayed ");
				
			}
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			System.out.println("not displayed "+ e.getStackTrace()+e.getMessage());
		}	
	}
	
	
	@Test(priority = 1)
	public void dropdown_UploadFile() throws InterruptedException
	
	{   driver.findElement(checkbox).click();
		
		scrolltoview(driver.findElement(countryDropDown));
		Select dp=new Select(driver.findElement(countryDropDown));
		List <WebElement> options=dp.getOptions();
		for (WebElement webElement : options) {
			webElement.click();
		}
		
		driver.findElement(By.xpath("//input[@id='comboBox']")).click();
		scrolltoview(driver.findElement(By.xpath("//div[normalize-space()='Item 73']")));
		driver.findElement(By.xpath("//div[normalize-space()='Item 73']")).click();
		
		//driver.findElement(choseButton).sendKeys("C:\\Usereclipsonly\\Koushikworkspace1\\Feb_BrushUp\\src\\test\\resources\\config.properties");
		//driver.findElement(By.xpath("//button[normalize-space()='Upload Single File']")).click();
		
	}
	
	
	
	
	
	
	public static void scrolltoview(WebElement element)
	{   JavascriptExecutor js=(JavascriptExecutor)driver;
	    js.executeScript("arguments[0].scrollIntoView(true);", element);
	
	}
}
