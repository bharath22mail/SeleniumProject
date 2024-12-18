package com.learning.selenium.Selenium4VersionTopics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import static org.openqa.selenium.support.locators.RelativeLocator.*;
public class SetGeoLcation {

	public static void main(String[] args) throws InterruptedException {

		ChromeDriver driver = new ChromeDriver();
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		
		Map<String, Object> coordinates = new HashMap<>();
		coordinates.put("latitude", 40);
		coordinates.put("longitude", 3);
		coordinates.put("accuracy", 1);
		
		driver.executeCdpCommand("Emulation.setGeolocationOverride", coordinates);
		
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		driver.findElement(By.name("q")).sendKeys("netflix",Keys.ENTER);
		Thread.sleep(300);
		List<WebElement> elements = driver.findElements(By.cssSelector(".LC20lb")); //.get(0).click();
		System.out.println("Size is::"+elements.size());
		elements.get(0).click();
		Thread.sleep(3000);
		WebElement ele = driver.findElement(By.cssSelector("h1[class*='default-ltr-cache-jmnaey']"));
		
		
		System.out.println("Title is::"+ele.getText());
		
		WebElement cancelPrice = driver.findElement(By.cssSelector("p[class*=' default-ltr-cache-lwezpj']"));
		
		System.out.println((driver.findElement(with(By.tagName("h1")).above(cancelPrice)).getText()));
		
		WebElement submitButton= driver.findElement(By.cssSelector("button[data-uia='nmhp-card-cta+hero_card']"));
		
		System.out.println(driver.findElement(with(By.tagName("input")).toLeftOf(submitButton)).getAttribute("data-uia"));
		
		driver.close();
	}

}
