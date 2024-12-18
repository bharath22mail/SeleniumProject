package com.learning.selenium.Selenium4VersionTopics;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v121.emulation.Emulation;
import org.openqa.selenium.devtools.v121.emulation.model.DevicePosture;
import org.openqa.selenium.devtools.v121.emulation.model.DisplayFeature;
import org.openqa.selenium.devtools.v121.emulation.model.ScreenOrientation;
import org.openqa.selenium.devtools.v121.page.model.Viewport;

public class MobileEmulatorTest {

	
	public static void main(String[] args) {

		try {

			ChromeDriver driver = new ChromeDriver();
			//driver.get("https://rahulshettyacademy.com/angularAppdemo/");
			DevTools devTools = driver.getDevTools();
			devTools.createSession();

			// Send command to CDP --chrome devtools protocol
			// CDP method will invoke and get access to chrome dev tools automatically

			// The method setDeviceMetricsOverride(Integer, Integer, Number, Boolean, Optional<Number>, Optional<Integer>, Optional<Integer>, Optional<Integer>, Optional<Integer>, Optional<Boolean>, Optional<ScreenOrientation>, Optional<Viewport>, Optional<DisplayFeature>, Optional<DevicePosture>
			
			
			devTools.send(Emulation.setDeviceMetricsOverride(600, 1000, 50, true,  Optional.<Number> empty(),
		            Optional.<Integer> empty(), Optional.<Integer> empty(), Optional.<Integer> empty(), 
		            Optional.<Integer> empty(), Optional.<Boolean> empty(), Optional.<ScreenOrientation> empty(), 
		            Optional.<Viewport> empty(), Optional.<DisplayFeature> empty(), java.util.Optional.<DevicePosture> empty()));
			

	        
			driver.get("https://rahulshettyacademy.com/angularAppdemo/");
			driver.manage().window().maximize();
			Thread.sleep(3000);

			driver.findElement(By.cssSelector("span.navbar-toggler-icon")).click();

			Thread.sleep(3000);
			driver.findElement(By.linkText("Library")).click();
			Thread.sleep(5000);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
