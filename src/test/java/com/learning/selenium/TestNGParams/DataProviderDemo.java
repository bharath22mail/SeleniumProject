package com.learning.selenium.TestNGParams;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo {

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[3][2];
		
		data[0][0]="1st UserName";
		data[0][1]="1st UserPwd";
		
		data[1][0]="2nd UserName";
		data[1][1]="2nd UserPwd";

		data[2][0]="3rd UserName";
		data[2][1]="3rd UserPwd";
		
		return data;
	}
//	@Test(dataProvider = "getData")
//	public void getData(String param1,String param2) {
//		System.out.println(param1+" "+param2);
//	}
}
