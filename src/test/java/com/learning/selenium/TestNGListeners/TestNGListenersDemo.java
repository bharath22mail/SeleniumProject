package com.learning.selenium.TestNGListeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListenersDemo implements ITestListener{

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Test execution is completed::"+context.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Method is success::"+result.getName());
	}

	
	
}
