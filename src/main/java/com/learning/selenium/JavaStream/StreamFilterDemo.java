package com.learning.selenium.JavaStream;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class StreamFilterDemo {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#search-field")).sendKeys("Rice");
		List<WebElement> veggies = driver.findElements(By.xpath("//tbody/tr/td[1]"));
		
		List<WebElement> veggieItem = veggies.stream().filter(veggie->veggie.getText().equalsIgnoreCase("rice")).collect(Collectors.toList());
		
		Assert.assertEquals(veggies.size(), veggieItem.size());
		
		System.out.println("Both are equal::");
		driver.close();
	}

}
