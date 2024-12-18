package com.learning.selenium.JavaStream;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CollectVegPriceDemoUsingStreams {
	static String item="Rice";
	public static void main(String[] args) {
		try {
			WebDriver driver = new ChromeDriver();
			driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
			driver.manage().window().maximize();
			Thread.sleep(2000);
			List<WebElement> elements = driver.findElements(By.xpath("//td[text()='"+item+"']"));
			
			List<WebElement> prices = elements.stream().filter(s->s.getText().equalsIgnoreCase(""+item)).map(f->getPriceElement(f)).collect(Collectors.toList());
			
			
			WebElement el= elements.stream().filter(s->s.getText().equalsIgnoreCase(""+item)).findFirst().orElse(null);
			System.out.println("Hello item is::"+el.getText());
			
			WebElement pr= elements.stream().filter(s->s.getText().equalsIgnoreCase(""+item)).map(price->price.findElement(By.xpath("following-sibling::td[1]"))).findFirst().orElse(null);
			System.out.println("Hello item price is::"+pr.getText());
	
			
			for (WebElement price : prices) {
				System.out.println("Price is::"+price.getText());
			}
			
			driver.close();

		} catch (Exception e) {
			System.out.println("Exception Window::" + e.getMessage());
		}
	}

	private static WebElement getPriceElement(WebElement f) {
		// TODO Auto-generated method stub
		return f.findElement(By.xpath("following-sibling::td[1]"));
		
	}
	//********Want to return Text
	private static String getPriceValue(WebElement f) {
		// TODO Auto-generated method stub
		return f.findElement(By.xpath("following-sibling::td[1]")).getText();
		
	}
}
