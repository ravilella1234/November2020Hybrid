package com.demoproject.SampleCRM.BaseClass;

import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.demoproject.SampleCRM.Utilities.ExcelAPI;

public class BaseTest 
{
	
	public String  projectPath = System.getProperty("user.dir");
	public FileInputStream fis;
	public Properties mainProp;
	public Properties childProp;
	public Properties orProp;
	public ExcelAPI xls;
	
	
	public void init() throws Exception
	{
		fis = new FileInputStream(projectPath+"//src//test//resources//environment.properties");
		mainProp = new Properties();
		mainProp.load(fis);
		String e = mainProp.getProperty("env");
		System.out.println(e);
		
		fis = new FileInputStream(projectPath+"//src//test//resources//"+e+".properties");
		childProp = new Properties();
		childProp.load(fis);
		String value = childProp.getProperty("zohourl");
		System.out.println(value);
		
		fis = new FileInputStream(projectPath+"//src//test//resources//or.properties");
		orProp = new Properties();
		orProp.load(fis);
		
		//How do i come to know which Excel file to load
		String[] pack = this.getClass().getPackage().getName().split("\\.");
		String suiteName = pack[pack.length-1];
		System.out.println(suiteName);
		
		//init the xls file
		xls = new ExcelAPI(projectPath+"\\src\\test\\resources\\"+suiteName+".xlsx");
		
		//init the TestName
		String testName = this.getClass().getSimpleName();
		System.out.println(testName);
		
		
	}
	
	@BeforeMethod
	public void beforeMethod() throws Exception 
	{
		System.out.println("iam beforemethod...");
	    init();
	}
	
	@AfterMethod
    public void afterMethod()
	{
		System.out.println("iam aftermethod...");
	}

}
