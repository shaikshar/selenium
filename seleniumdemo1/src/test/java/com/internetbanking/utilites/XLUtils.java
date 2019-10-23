package com.internetbanking.utilites;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils {
	
	public static final String EXCELFILELOCATION ="/Users/zulfiqar/Downloads/Workbook1.xlsx";
	
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row1, row2;
	//public static XSSFRow row2;
	
	public static void loadexcel() throws Exception {
		File f = new File(EXCELFILELOCATION);	
		FileInputStream fis = new FileInputStream(f);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet("Sheet1");
		fis.close();
	}
	
	/*public static void main(String[] args) {	
		Map<String,String> getvalue = new HashMap<String, String>();
		try {
			//XLUtils.loadexcel();
			getvalue = XLUtils.getData();
			String Account = getvalue.get("Name");
			System.out.println(Account);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	public static Map<String, String> getData() throws Exception{
		//Map<String, Map<String, String>> SuperMap = new HashMap<String, Map<String, String>>();
		XLUtils.loadexcel();
		Map<String, String> childMap = new HashMap<String,String>();
		row1= sheet.getRow(0);
		row2 = sheet.getRow(1);
		for(int i=0;i<row1.getLastCellNum()-1;i++) {
			System.out.println(row1.getCell(i));
			System.out.println(row2.getCell(i));
			childMap.put(row1.getCell(i).toString(), row2.getCell(i).toString());		
		}		
		return childMap;
	}
}
