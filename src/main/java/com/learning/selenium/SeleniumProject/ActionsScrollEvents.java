package com.learning.selenium.SeleniumProject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsScrollEvents {

	public static void main(String[] args) {
		try {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		Actions actions = new Actions(driver);
		actions.scrollByAmount(0, 900).build().perform();
		
		actions.sendKeys(Keys.END).build().perform();
		
		actions.sendKeys(Keys.UP).build().perform();
		
		
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
