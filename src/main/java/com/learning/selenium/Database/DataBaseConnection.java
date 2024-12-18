package com.learning.selenium.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DataBaseConnection {

	public static void main(String[] args) {

		String url = "jdbc:mysql://" + "localhost" + ":" + "3306" + "/Qadbt";
		try {
			Connection connection = DriverManager.getConnection(url, "root", "test");
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery("select * from Employeeinfo where name ='ram'");
			while (result.next()) {
				WebDriver driver = new ChromeDriver();
				driver.get("https://login.salesforce.com/?locale=in");
				driver.manage().window().maximize();
				//System.out.println(result.getInt("id"));
				//System.out.println(result.getString("location"));
				driver.findElement(By.cssSelector(".username")).sendKeys(""+result.getInt("id"));
				driver.findElement(By.cssSelector(".password")).sendKeys(result.getString("location").toString());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
