package com.baseclass;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;


public class setup {
	public static WebDriver driver;
	String url="http://demo.guru99.com/V4/";
  @BeforeTest
  public void f() 
  {
	  System.setProperty("webdriver.chrome.driver","E:\\chromedriver.exe");
	  driver= new ChromeDriver();
	  driver.get(url);
	  driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
  }
}
