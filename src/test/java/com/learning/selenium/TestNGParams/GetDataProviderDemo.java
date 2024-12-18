package com.learning.selenium.TestNGParams;

import org.testng.annotations.Test;

public class GetDataProviderDemo extends DataProviderDemo{

	@Test(dataProvider = "getData")
	public void getDataMethod(String param1, String param2) {
		System.out.println(param1 + " " + param2);
	}
}
