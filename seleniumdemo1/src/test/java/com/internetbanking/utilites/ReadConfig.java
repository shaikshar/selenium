package com.internetbanking.utilites;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro ;
	
	public ReadConfig() {
		File src = new File("./Configuration/config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public String getUrl() {
		String Url = pro.getProperty("Url");
		return Url;
	}
	
	public String getusername() {
		String Uname = pro.getProperty("Username");
		return Uname;
	}
	
	public String getpassword() {
		String password = pro.getProperty("password");
		return password;
	}
}
