package com.learning.selenium.SeleniumProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SSLCertificate {

	public static void main(String[] args) {
		ChromeOptions cOptions = new ChromeOptions();
		cOptions.setAcceptInsecureCerts(true);
		WebDriver driver = new ChromeDriver(cOptions);
		driver.get("https://expired.badssl.com");
		
	}

}
