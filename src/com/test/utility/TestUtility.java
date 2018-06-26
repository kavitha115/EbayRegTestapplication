package com.test.utility;

import java.util.ArrayList;

import com.excel.utility.Xls_Reader;
  

public class TestUtility {
	  static Xls_Reader reader;
	public static  ArrayList<Object[]> getDataFromExcel(){
		
		 ArrayList<Object[]> mydata = new ArrayList<Object[]>();

	 try{
		 reader = new Xls_Reader("C:\\Users\\AarshiCherry\\workspace\\TestNG\\src\\com\\testdata\\EbayTestData.xlsx");
				 
	 }catch(Exception e){
		 e.printStackTrace();
	 }
	 for (int rowNum=2; rowNum<=reader.getRowCount("RegTestData");rowNum++){
		 String firstname = reader.getCellData("RegTestData","firstname", rowNum);
		 String lastname = reader.getCellData("RegTestData","lastname", rowNum);
		 String emailaddress = reader.getCellData("RegTestData","emailaddress", rowNum);
		 String password = reader.getCellData("RegTestData","password", rowNum);
		 
		 Object Ob[] = {firstname,lastname,emailaddress,password};
		 mydata.add(Ob);
		 
  }
	 return mydata;
		 
	 

	}
}

	

