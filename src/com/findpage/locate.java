package com.findpage;




import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.baseclass.setup;
public class locate extends setup {
	String acturl="http://demo.guru99.com/V4/manager/Managerhomepage.php";
	String crturl="http://demo.guru99.com/V4/index.php";
	
	  public void login(String uname,String password) throws IOException {
		  
		  driver.findElement(By.name("uid")).sendKeys(uname);
		  driver.findElement(By.name("password")).sendKeys(password);
		  driver.findElement(By.name("btnLogin")).click();
		  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  }
	  
	  public boolean isalertpresent()
	  {
		  try {
		  driver.switchTo().alert().accept();
		  return true;
		  }// try
		  catch (NoAlertPresentException Ex)
		  {
			  return false;
		  }// catch
		} // is alertpresent();
	  
	  public void lin()
	  {
	  
		 if(acturl.equalsIgnoreCase(driver.getCurrentUrl()))
			{
				List <WebElement> links=driver.findElements(By.tagName("a"));
				System.out.println("Totoal links are:-"+links.size());
				for(int j=1;j>=links.size();j++)
				{
					WebElement element=links.get(j);
					String ur=element.getAttribute("href");
					System.out.println("links are:-"+ur);
					verifyLink1(ur);
				}
			}
	  }
				public static void verifyLink1(String urlLink) {
			        //Sometimes we may face exception "java.net.MalformedURLException". Keep the code in try catch block to continue the broken link analysis
			        try {
						//Use URL Class - Create object of the URL Class and pass the urlLink as parameter 
						URL link = new URL(urlLink);
						// Create a connection using URL object (i.e., link)
						HttpURLConnection httpConn =(HttpURLConnection)link.openConnection();
						//Set the timeout for 2 seconds
						httpConn.setConnectTimeout(2000);
						//connect using connect method
						httpConn.connect();
						//use getResponseCode() to get the response code. 
							if(httpConn.getResponseCode()== 200) {	
								System.out.println(urlLink+" - "+httpConn.getResponseMessage());
							}
							if(httpConn.getResponseCode()== 404) {
								System.out.println(urlLink+" - "+httpConn.getResponseMessage());
							}
						}
						//getResponseCode method returns = IOException - if an error occurred connecting to the server. 
					catch (Exception e) {
						//e.printStackTrace();
					}
			}
	

	
		
	}

	

		
	  
	
	
