package com.TivixLab.Utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeErrorScreenshot {
	
	public TakeErrorScreenshot(WebDriver driver,String tname) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File file=ts.getScreenshotAs(OutputType.FILE);
		File destfile=new File(".\\Screenshots\\"+tname+".png");
		FileUtils.copyFile(file, destfile); 
	}


}
