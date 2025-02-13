package com.xyz.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestBase {
    public static WebDriver driver;
     Properties prop;
    public TestBase() 
    {     
    	FileInputStream fileInput=null;
    	prop=new Properties();
    	try {
    		
    		File file =new File(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
    		 fileInput= new  FileInputStream(file);
    		 prop.load(fileInput);
		} catch (FileNotFoundException e) {
			// TODO: handle exception
		System.out.println(e.getMessage());
	        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	finally {
			try {
				fileInput.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
    }
   

		@BeforeClass
   public void setup()
   {      
          String browserProperty=prop.getProperty("Browser");
	    if(browserProperty.equalsIgnoreCase("chrome")) 
	    {
	    	driver=new ChromeDriver();
	    }
	   
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.manage().deleteAllCookies();
	    driver.manage().window().maximize();
	    driver.get(prop.getProperty("Url"));	
	   
   }
    	
    public  WebDriver getdriver(){
    		
    		return driver; 
    		
    	}
    	
    	
    	@AfterClass
    	public void tearDown(){
    		
    		driver.quit();
    		
    	}
    	
    	
    
	
	
	
	
}
