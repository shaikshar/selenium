package com.internetbanking.testcases;

import java.io.File;
import java.nio.file.Files;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


import com.internetbanking.utilites.ReadConfig;

public class BaseClass  {
	
	ReadConfig readconfi = new ReadConfig();
	
	public static Logger log;
	
	public String Url = readconfi.getUrl();
	public String Username = readconfi.getusername();
	public String password =readconfi.getpassword();
	public static WebDriver driver;
	
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {
		
		 log = Logger.getLogger("ebanking");
		PropertyConfigurator.configure("");
		
		if(br.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers//Chromedriver");
		driver = new ChromeDriver();
		}else if(br.equals("ie")) {
			
		}else if(br.equals("firefox")) {
			
		}
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver,String tname) throws Exception{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File Source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
		FileUtils.copyFile(Source, target);
	}

}
