package com.learning.selenium.SeleniumProject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {

	ArrayList<String> al = new ArrayList<String>();

	public ArrayList<String> readData(String testData) {
		FileInputStream fis;
		try {
			fis = new FileInputStream(System.getProperty("user.dir") + "//Resources//ReadExcelDataFile.xlsx");
			XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fis);
			System.out.println("File Loaded::");
			int noOfSheets = xssfWorkbook.getNumberOfSheets();
			for (int i = 0; i < noOfSheets; i++) {
				if (xssfWorkbook.getSheetName(i).equalsIgnoreCase("inputSheet")) {
					XSSFSheet sheet = xssfWorkbook.getSheetAt(i);
					// System.out.println("Sheet Loaded");
					for (int j = 0; j < sheet.getLastRowNum(); j++) {
						XSSFRow row = sheet.getRow(j);
						// System.out.println("Row loaded");

						// System.out.println("Yes Uts true");
						for (int k = 0; k < row.getLastCellNum(); k++) {
							// if (row.getCell(j).getStringCellValue().equalsIgnoreCase("Purchase")) {
							String cellData = row.getCell(k).getStringCellValue();
							// for(int cellNum=0;cellNum<row.getLastCellNum();cellNum++) {
							// System.out.println(cellData);
							if (cellData.equalsIgnoreCase(testData)) {
								// System.out.println( row.getRowNum());
								Iterator<Cell> cellIterator = row.cellIterator();
								while (cellIterator.hasNext()) {
									// System.out.println(cellIterator.next().getStringCellValue());
									
									Cell cell = cellIterator.next();
									CellType cellType = cell.getCellType();
										
										 if (cellType.toString() == "NUMERIC") {
								            al.add(String.valueOf(cell.getNumericCellValue()));
								         }
										 else {
											 al.add(cell.getStringCellValue());
										 }

								}
								break;
							}
							// }
						}
					}
				}
			}

			xssfWorkbook.close();
			fis.close();

		} catch (

		FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return al;

	}
}
