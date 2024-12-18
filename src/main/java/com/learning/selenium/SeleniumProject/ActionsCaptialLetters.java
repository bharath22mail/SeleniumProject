package com.learning.selenium.SeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class ActionsCaptialLetters {

	public static void main(String[] args) {
		try {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		Actions actions = new Actions(driver);
		
		
		WebElement ele=driver.findElement(By.cssSelector("#autocomplete"));
		
		Action action = actions.moveToElement(ele).click().keyDown(Keys.SHIFT).sendKeys("bharath").build();//.perform();
		action.perform();
		Thread.sleep(2000);
		ele.clear();
		
		actions.moveToElement(ele).click().sendKeys("Kushal").doubleClick().perform();
		
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
