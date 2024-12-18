package com.learning.selenium.TestNGProject;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class day3 {
	
	@Test(enabled = false, groups = "smoke")
	public void getHomeLoan() {
		System.out.println("getHomeLoan");
	}

	@Test(groups = "Regression")
	public void clearHomeLoan() {
		System.out.println("clearHomeLoan");
	}
	@BeforeTest
	public void beforeTest() {
		System.out.println("beforeTest");
	}
	@AfterTest
	public void afterTest() {
		System.out.println("afterTest");
	}

}
