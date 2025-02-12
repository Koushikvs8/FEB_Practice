package com.xyz.qa.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.xyz.qa.TestCases.*;
import com.xyz.qa.base.TestBase;

public class ActionMouseKeyboardInteractions extends TestBase {
	
	By pointme= By.xpath("//button[normalize-space()='Point Me']");
	By laptomsfield= By.xpath("//a[normalize-space()='Laptops']");
	
	By doubleClick= By.xpath("//button[normalize-space()='Copy Text']");
	By fileld2= By.xpath("//input[@id='field2']");
	By dragelement= By.xpath("//div[@id='draggable']");
	By dropelement= By.xpath("//div[@id='droppable']");
	@Test(priority = 0)
	public void mouseActions() throws InterruptedException
	{
		driver=getdriver();
		driver.findElement(pointme);
		Actions myactions=new Actions(driver);
		ElementuserInteraction.scrolltoview(driver.findElement(pointme));
		myactions.moveToElement(driver.findElement(pointme)).click().build().perform();
		myactions.moveToElement(driver.findElement(laptomsfield)).build().perform();
		
        Thread.sleep(1000);
		myactions.doubleClick(driver.findElement(doubleClick)).perform();
		//Assert.assertTrue(driver.findElement(fileld2).getText().equalsIgnoreCase("Hello World!"));
		System.out.println(driver.findElement(fileld2).getText());
		 Thread.sleep(1000);
		myactions.dragAndDrop(driver.findElement(dragelement), driver.findElement(dropelement)).build().perform();
		Thread.sleep(1000);
		myactions.clickAndHold(driver.findElement(By.xpath("//div[@id='HTML7']//span[1]"))).moveByOffset(100, 0).perform();
		Thread.sleep(3000);
	}
	
	@Test(priority = 1)
	public void keyBoardActions() throws InterruptedException
	{
		Actions myactions=new Actions(driver);
		driver.findElement(By.xpath("//textarea[@id='textarea']")).sendKeys("nrewighgnrtgnj");
		myactions.click(driver.findElement(By.xpath("//textarea[@id='textarea']"))).keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
		Thread.sleep(3000);
	}
	
	
	
}
