package com.amazon.qa.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;

import com.amazon.qa.Testbase.Testbase;


public class TestUtils extends Testbase {

	public TestUtils() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void takeScreenshotAtEndOfTest() throws IOException {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			//String currentDir = System.getProperty("user.dir");
			
			//FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
			FileUtils.copyFile(scrFile, new File("E://webdriver_Framework//Screenshot//Screenshot" + System.currentTimeMillis() + ".png"));
			}
}
