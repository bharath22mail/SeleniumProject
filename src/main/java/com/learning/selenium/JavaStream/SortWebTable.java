package com.learning.selenium.JavaStream;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class SortWebTable {
	

	public static void main(String[] args) throws InterruptedException {
		List<WebElement> elements;
		List<String> priceValue ;
		
		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("th[role='columnheader']:nth-child(1) span:nth-child(2)")).click();
		elements = driver.findElements(By.xpath("//tbody/tr/td[1]"));

		List<String> collect = elements.stream().map(s -> s.getText()).collect(Collectors.toList());

		List<String> collect2 = collect.stream().sorted().collect(Collectors.toList());

		Assert.assertTrue(collect.equals(collect2));
		Thread.sleep(2000);
		List<String> price = elements.stream().filter(s->s.getText().equalsIgnoreCase("beans")).map(s->getPriceOfItem(s)).collect(Collectors.toList());

		System.out.println("PriceDetails:"+price.get(0));
		
		price.stream().forEach(s->System.out.println(s));
		System.out.println("++++++++++++++++++++++");
		
		do {
			
			elements = driver.findElements(By.xpath("//tbody/tr/td[1]"));
			priceValue= elements.stream().filter(s->s.getText().equalsIgnoreCase("Rice")).map(s->getPriceOfItem(s)).collect(Collectors.toList());
					
			if(priceValue.size()<1) {
				driver.findElement(By.cssSelector("a[aria-label='Next']")).click();
				Thread.sleep(2000);
			}	
			else {
				priceValue.stream().forEach(s->System.out.println(s));
				Thread.sleep(2000);
			}
		}while(priceValue.size()<1);
		
		Thread.sleep(2000);
		driver.close();
	}

	public static String getPriceOfItem(WebElement ele) {
		return ele.findElement(By.xpath("following-sibling::td[1]")).getText();
	}
}
