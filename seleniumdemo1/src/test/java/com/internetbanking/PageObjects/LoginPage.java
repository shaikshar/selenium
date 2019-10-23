package com.internetbanking.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	 public LoginPage(WebDriver rdriver) {
		 driver = rdriver;
		 PageFactory.initElements(rdriver, this);	
	}
	 
	 @FindBy(name="uid")
	 @CacheLookup
	 WebElement txtUserName;
	 
	 WebElement username = driver.findElement(By.xpath(""))
	 
	 @FindBy(name="password")
	 @CacheLookup
	 WebElement txtpassword;
	 
	 @FindBy(name="btnLogin")
	 @CacheLookup
	 WebElement submitbutton;
	 
	 public void enterusername(String username) {	 
		 txtUserName.sendKeys(username);
	 }
	 
	 public void enterpwd(String pwd) {	 
		 txtpassword.sendKeys(pwd);
	 }
	 
	 public void clickbtn() {	 
		 submitbutton.click();
	 }

}
