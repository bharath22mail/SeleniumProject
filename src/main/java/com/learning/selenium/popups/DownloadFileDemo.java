package com.learning.selenium.popups;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DownloadFileDemo {

	public static void main(String[] args) throws InterruptedException, IOException {

		// 1st Download from AutoID webSite
		// 2nd SciTE editor
		// 3rd Open Au3Info_x64 and identify WindowPopup options by dragging and
		// dropping on Disc icon
		// 4th Based on inputs write script in step 2nd step (SciTE editor) then Save
		// the file (.au3 format)
		// 5th Goto the location where filed saved, right click on it run the file to
		// generate .exe file
		String projectPath = System.getProperty("user.dir");
		String downLoadPath = projectPath+"\\DownloadPath";
		
		File file = new File(downLoadPath + "Rent.docx");
		if (file.exists()) {
			System.out.println("file found");
			file.delete();
			System.out.println("file deleted also");
		}
		
		/*
		 * Key: "profile.default_content_settings.popups" This preference controls
		 * whether popups are allowed in the Chrome browser.
		 * 
		 * Value: 0 Setting the value to 0 disables all popups in the browser.
		 * 
		 * 
		 * When to Use It When automating scenarios involving: File downloads. Pages or
		 * websites that frequently trigger popups. Testing in a headless mode where
		 * popups cannot be interacted with. If you don't disable popups, your script
		 * may fail or hang when a popup unexpectedly appears.
		 */			
			
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups",0);
		chromePrefs.put("download.default_directory", downLoadPath);
		
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);

		WebDriver driver = new ChromeDriver(options);
		driver.get(("https://www.ilovepdf.com/pdf_to_word"));
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//span[contains(text(),'Select PDF file')]")).click();
		Thread.sleep(3000);
		  String dynamicFile = projectPath + "\\Resources\\AutoIt\\Rent.pdf";
	        String autoItExecutable = projectPath + "\\Resources\\AutoIt\\fileUpload.exe"; // Example dynamic text
	        Runtime.getRuntime().exec(new String[]{autoItExecutable, dynamicFile});
	       
		Thread.sleep(10000);
		driver.findElement(By.cssSelector("span#processTaskTextBtn")).click();
		Thread.sleep(10000);
		driver.close();;
	}
}
