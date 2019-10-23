package com.internetbanking.testcases;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import com.internetbanking.PageObjects.LoginPage;
import com.internetbanking.utilites.XLUtils;

public class TC01 extends BaseClass {
	
@Test	
	public void login() throws Exception {
		
		driver.get(Url);
		log.info("Launched Browser");
		 LoginPage l = new LoginPage(driver);
		 
		 //XLUtils data = new XLUtils();
		 
		 Map<String,String> mydata = new HashMap<String, String>();		 
		 mydata = XLUtils.getData();
		 
		 String UserName = mydata.get("Account");
		 
		 l.enterusername(UserName);
		 l.enterpwd(password);
		 l.clickbtn();	 
		
	}

}
