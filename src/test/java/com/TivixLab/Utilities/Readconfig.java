package com.TivixLab.Utilities;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Readconfig 
{
	Properties pro=null;
	public Readconfig() 
	{
		try 
		{
			FileInputStream fis = new FileInputStream("Configuration\\config.properties");
			pro=new  Properties();
			pro.load(fis);
			fis.close();
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}
	
	public String getApplicationURL()
	{
		String  url=pro.getProperty("baseURL");
		return url;
		
	}
}