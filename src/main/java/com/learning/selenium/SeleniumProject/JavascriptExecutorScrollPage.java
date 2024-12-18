package com.learning.selenium.SeleniumProject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class JavascriptExecutorScrollPage {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/AutomationPractice");
		driver.manage().window().maximize();
		JavascriptExecutor js= (JavascriptExecutor) driver;
		
		
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
		Thread.sleep(3000);
		WebElement Element = driver.findElement(By.xpath("//legend[text()='iFrame Example']"));
		//We can scroll until the weblemt is visible.
		js.executeScript("arguments[0].scrollIntoView();", Element);
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		//We can scroll inside webtable also by using below method we need to provide webelement, scroll limit
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=1000");
		
		
		List<WebElement> elements = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		System.out.println(elements.size());
		int sum=0;
		for (WebElement webElement : elements) {
			sum=sum+Integer.parseInt(webElement.getText());
		}
		System.out.println("SUM::"+sum);
		//driver.close();
	}

}