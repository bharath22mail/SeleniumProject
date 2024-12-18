package com.learning.selenium.SeleniumProject;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandlerDemo {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        String parent = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.TAB);     
        
        driver.getWindowHandles();
        Set<String> windowHandles = driver.getWindowHandles();
        
        for (String window : windowHandles) {
			driver.switchTo().window(window);
		}
        driver.get("https://www.facebook.com");
        driver.close();
        driver.switchTo().window(parent);
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.close();
        
		
	}

}
