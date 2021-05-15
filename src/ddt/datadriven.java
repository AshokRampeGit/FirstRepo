package ddt;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.baseclass.setup;
import com.excelsheet.util;
import com.findpage.locate;


public class datadriven extends setup {

  @Test
  public void tests() throws IOException {
  String xpath="E:\\Book1.xlsx";
	String xlsheet="Sheet1";
	int rc;
	rc=util.row(xpath, xlsheet);
	String uname, password;
	locate lp=new locate();

	for (int i=0; i<=rc; i++)
	{
	uname=util.getCellData(xpath, xlsheet, i, 0);
	password=util.getCellData(xpath, xlsheet, i, 1);
	lp.login(uname, password);
	lp.isalertpresent();
	System.out.println(uname+"  "+ password);
	lp.lin();
	lp.verifyLink1(password);
	
}
  }
}