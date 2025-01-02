package com.learning.selenium.popups;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AutoITWindowBasedPopupWithDynamicFile {

	public static void main(String[] args) {

		// 1st Download from AutoID webSite
		// 2nd SciTE editor
		// 3rd Open Au3Info_x64 and identify WindowPopup options by dragging and
		// dropping on Disc icon
		// 4th Based on inputs write script in step 2nd step (SciTE editor) then Save
		// the file (.au3 format)
		// 5th Goto the location where filed saved, right click on it run the file to
		// generate .exe file
		
		String projectPath = System.getProperty("user.dir");
		String downLoadPath = projectPath+"\\DownloadPath\\";
		
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups",0);
		chromePrefs.put("download.default_directory", downLoadPath);
		
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);

		WebDriver driver = new ChromeDriver(options);
		driver.get(("https://www.ilovepdf.com/pdf_to_word"));
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//span[contains(text(),'Select PDF file')]")).click();
		try {
			Thread.sleep(3000);
		
		
		File file = new File(downLoadPath + "Rent.docx");
		if (file.exists()) {
			System.out.println("file found");
			file.delete();
			System.out.println("file trace not found");
		}
		else
			System.out.println("file not found");
		
		//
		//****Open SciTE editor
		//
		//$dynamicText = $CmdLine[1] ; First argument
		//ControlFocus("Open","","Edit1")
		//ControlSetText("Open","","Edit1",$dynamicText)
		//ControlClick("Open","","Button1")
		//
		//****Save the above 4 lines in .au3 formaat
		//****compile the above saved file to get .exe filr
		
        String dynamicFile = projectPath + "\\Resources\\AutoIt\\Rent1.pdf";
        String autoItExecutable = projectPath + "\\Resources\\AutoIt\\fileUpload.exe"; // Example dynamic text
        Runtime.getRuntime().exec(new String[]{autoItExecutable, dynamicFile});
        
		//Runtime.getRuntime().exec(projectPath + "\\Resources\\AutoIt" + "\\fileUpload.exe");
		
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("span#processTaskTextBtn")).click();
		Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();
	}
}
