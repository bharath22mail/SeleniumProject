package com.learning.selenium.SeleniumProject;

import org.testng.Assert;
import org.testng.annotations.Test;


/**
 * Unit test for simple App.
 */
public class AppTest 
{
  
	String parameterIS=System.getProperty("parameterIS")!=null ? System.getProperty("parameterIS"):"firefox";
	
    @Test
    public void shouldAnswerWithTrue()
    {
        Assert.assertTrue( true );
        System.out.println("Apptest parameter from command prompt::"+parameterIS);
    }
    @Test	
    public void methodInterceptorRetryTest() {
    	System.out.println("This is retry test");
    	
    	//If tru executes 1 time if false executes 3 times code is in Retry.java
    	//Assert.assertTrue(false);
    	Assert.assertTrue(true);
    	
    }
    @Test
    public void methodInterceptorTest() {
    	System.out.println("This is methosinterseptorTest");
    	System.out.println("Value came from mvn command:"+parameterIS);
    }
    @Test
    public void sampleAppTest() {
    	System.out.println("This is sampleAppTest");
    }
    
}
