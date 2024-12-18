package com.learning.selenium.TestNGProject;

import org.testng.annotations.Test;

public class day1 {
	
	@Test(groups = "smoke")
	public void getGadgetsLoan() {
		System.out.println("getGadgetsLoan");
	}

	@Test(groups = {"smoke","Regression"})
	public void clearGadgetsLoan() {
		System.out.println("clearGadgetsLoan");
	}

}
