package com.xyz.qa.TestCases;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.xyz.qa.base.TestBase;

public class Switchingcontrol  extends TestBase{
	//button[@id='alertBtn']
	//button[@id='confirmBtn']
	//button[@id='promptBtn']
	//button[normalize-space()='New Tab']
	//button[@id='PopUp']
	@Test(priority = 0,enabled = false)
	public void SwichtoAlert() throws InterruptedException
	{
		driver=getdriver();
		driver.findElement(By.xpath("//button[@id='alertBtn']")).click();
		Alert al=driver.switchTo().alert();
		Thread.sleep(2000);
		al.accept();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='confirmBtn']")).click();
		al.accept();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='promptBtn']")).click();
		Thread.sleep(2000);
		al.sendKeys("koushik");
		Thread.sleep(2000);
		al.accept();
		
		
	}
	@Test(priority = 1,enabled = false)
	public void Swichtotabs() throws InterruptedException
	{
		driver.findElement(By.xpath("//a[normalize-space()='merrymoonmary']")).click();
		Thread.sleep(2000);
		swichtochildwindow();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Search millions of premium-quality stock images and videos']")).sendKeys("women");
		Thread.sleep(2000);
		swichtochildwindow();
		
		
		
		
	}
	
	@Test(priority = 0)
	public void SwichtopopUps() throws InterruptedException
	{  System.out.println("  dghjkl;'");
		driver.findElement(By.xpath("//button[@id='PopUp']")).click();
		swichtochildwindow("selenium");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		
	}
	
	
	
	
	public static void  swichtochildwindow()
	{    
		String parentWindow=driver.getWindowHandle();
		
		Set<String> windowhandales  =driver.getWindowHandles();
		for (String Window : windowhandales) {
			if(!Window.equals(parentWindow))
			{
				driver.switchTo().window(Window);
				System.out.println("swich :" +Window);
			}
			System.out.println(Window);
			
		}
	}
		public static void  swichtochildwindow(String title)
		{    
			String parentWindow=driver.getWindowHandle();
			
			Set<String> windowhandales  =driver.getWindowHandles();
			for (String Window : windowhandales) {
				driver.switchTo().window(Window);
				if(driver.getTitle().equals(title))
				{
					break;
				}
				
				
			}
		
		
	}
		public  static WebElement waitedElement(WebElement ele  ) 
		{
			WebDriverWait waite=new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement  waitedElement=waite.until(ExpectedConditions.visibilityOf(ele));
			
			return waitedElement;
			
			
			
		}
		
	
	
	
}
