package com.learning.selenium.SeleniumProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsDemo {

	ExtentReports extentReports;
	
	
	@BeforeTest
	public void config() {
		String path = System.getProperty("user.dir") + "//reports//index.html";
		ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(path);
		extentSparkReporter.config().setReportName("Practice Automation Demo Results");
		extentSparkReporter.config().setDocumentTitle("Testing Results");
		
		extentReports = new ExtentReports();
		extentReports.attachReporter(extentSparkReporter);
		
		extentReports.setSystemInfo("Automation Tester", "Bharath");
		
	}

	@Test
	public void intialDemo() {
		
		extentReports.createTest("Initial Demo");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/");
		driver.close();
		extentReports.flush();
	}

	
}
