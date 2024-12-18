package com.learning.selenium.Selenium4VersionTopics;

import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

public class MobileEmulatorCDPTest {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		try {

			ChromeDriver driver = new ChromeDriver();
			DevTools devTools = driver.getDevTools();
			devTools.createSession();
			
			Map<String,Object> deviceMetrics = new HashMap<>();
			deviceMetrics.put("width",600);
			deviceMetrics.put("height", 1000);
			deviceMetrics.put("deviceScaleFactor", 50);
			deviceMetrics.put("mobile", true);
			
			driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", deviceMetrics);
			
	        
			driver.get("https://rahulshettyacademy.com/angularAppdemo/");
			
			Thread.sleep(3000);

			driver.findElement(By.cssSelector("span.navbar-toggler-icon")).click();

			Thread.sleep(3000);
			driver.findElement(By.linkText("Library")).click();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}