package com.kerchanshe.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShot {
	TakesScreenshot takeScreenshot;
	public void takeScreenShot(WebDriver driver,String imagename) {
		try {
			takeScreenshot=(TakesScreenshot) driver;
			File file=takeScreenshot.getScreenshotAs(OutputType.FILE);
			String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());
			String destination=System.getProperty("user.dir")+"\\screenshots\\ "+imagename+ "  " + timeStamp+".png";
			File finalDestination=new File(destination);
			FileHandler.copy(file, finalDestination);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
