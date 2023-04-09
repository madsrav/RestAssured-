package com.rmgyantra.GenericUtils;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseAPI {
  public DataBaseUtilty dutils=new DataBaseUtilty();
	@BeforeSuite
	public void creatingConDB() throws Throwable
	{
		dutils.createConnectionDB();
	}
	
	@AfterSuite
	public void closeCOnDB() throws Throwable
	{
		dutils.closeCOnDB();
	}
	
}
