package com.learning.selenium.popups;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowAuthenticationPopup {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		//driver.get("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();

		//
		driver.get("http://admin:admin@the-internet.herokuapp.com/");
		driver.findElement(By.linkText("Basic Auth")).click();		
		//driver.close();
		Thread.sleep(5000);
		//https://httpbin.org/basic-auth/foo/bar
		driver.get("http://foo:bar@httpbin.org/basic-auth/foo/bar");
		Thread.sleep(3000);
		//driver.findElement(By.linkText("Sign in")).click();
		
		
		
	}

}
