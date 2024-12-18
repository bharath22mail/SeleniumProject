package com.learning.selenium.SeleniumProject;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenshotDemo {

	public static void main(String[] args) {

		try {
			String projectPath = System.getProperty("user.dir");
			String pageScreen= projectPath+ "//Screenshots//1.jpeg";
			String eleScreen= projectPath+ "//Screenshots//2.jpeg";

			WebDriver driver = new ChromeDriver();

			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.get("https://www.spicejet.com/");

			File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			FileUtils.copyFile(file, new File(pageScreen));
			
			WebElement ele = driver.findElement(By.xpath("//div[contains(text(),'Search')]"));
			File webEleScreen = ele.getScreenshotAs(OutputType.FILE);
			
			FileUtils.copyFile(webEleScreen, new File(eleScreen));
			
			driver.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

}
