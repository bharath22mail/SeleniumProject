package com.learning.selenium.SeleniumProject;

import java.util.ArrayList;

public class ReadExcelDemo {

	public static void main(String[] args) {
		ReadExcelData excelDemo = new ReadExcelData();
		ArrayList<String> data = excelDemo.readData("Purchase");
		for (String cellData : data) {
			System.out.println("CellData::"+cellData);
		}
	}

}
