package com.learning.selenium.TestNGProject;

import org.testng.annotations.Test;

public class day4 {
	
	@Test
	public void getPersonalLoan() {
		System.out.println("getPersonalLoan");
	}

	@Test(priority = 1,    groups = "smoke")
	public void clearPersonalLoan() {
		System.out.println("clearPersonalLoan");
	}

}
