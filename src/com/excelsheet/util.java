package com.excelsheet;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class util{
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static Workbook wb;
	public static Sheet sh;
	public static Row ro;
	public static Cell cl; 
	public static CellStyle style; 
	static int rows,tot;
  public static int row (String Xpath, String xlsheet) throws IOException
  {
	  fi=new FileInputStream(Xpath);
	  wb=new XSSFWorkbook(fi);
	  sh=wb.getSheet(xlsheet);
	rows= sh.getLastRowNum();
	 wb.close();
	 fi.close();
	return rows;
  }
  public static int getcol(String xpath, String Xlsheet, int row) throws IOException
  {
	  fi=new FileInputStream(xpath);
	  wb= new XSSFWorkbook(fi);
	  sh=wb.getSheet(Xlsheet);
	  ro=sh.getRow(row);
	tot=ro.getLastCellNum();
	wb.close();
	fi.close();
	return tot;
  }
  public static String getCellData(String xlfile,String xlsheet,int rownum,int colnum) throws IOException
	{
		
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		sh=wb.getSheet(xlsheet);
		ro=sh.getRow(rownum);
		String data;
		try 
		{
			cl=ro.getCell(colnum);
			data=cl.getStringCellValue();
		} catch (Exception e) 
		{
			data="";
		}
		wb.close();
		fi.close();
		return data;		
	}
	
	public static void setCellData(String xlfile,String xlsheet,int rownum,int colnum,String data) throws IOException
	{
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		sh=wb.getSheet(xlsheet);
		ro=sh.getRow(rownum);
		cl=ro.createCell(colnum);
		cl.setCellValue(data);
		fo=new FileOutputStream(xlfile);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();		
	}
	
	
	public static void fillGreenColor(String xlfile,String xlsheet,int rownum,int colnum) throws IOException
	{
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		sh=wb.getSheet(xlsheet);
		ro=sh.getRow(rownum);
		cl=ro.getCell(colnum);
		style=wb.createCellStyle();
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		cl.setCellStyle(style);
		fo=new FileOutputStream(xlfile);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();		
	}
	
	public static void fillRedColor(String xlfile,String xlsheet,int rownum,int colnum) throws IOException
	{
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		sh=wb.getSheet(xlsheet);
		ro=sh.getRow(rownum);
		cl=ro.getCell(colnum);
		style=wb.createCellStyle();
		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		cl.setCellStyle(style);
		fo=new FileOutputStream(xlfile);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();		
	}
	
}