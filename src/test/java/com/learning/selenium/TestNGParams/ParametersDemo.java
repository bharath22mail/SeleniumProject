package com.learning.selenium.TestNGParams;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class ParametersDemo {
	
	@Parameters({"URL","Port"})
	@Test
	public void paramsTest(String urlString,String port) {
		System.out.println("Complete URL::"+urlString+port);
	}

}
