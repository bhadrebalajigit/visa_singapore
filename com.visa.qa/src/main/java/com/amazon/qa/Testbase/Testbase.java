package com.amazon.qa.Testbase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Testbase {
	
	public static WebDriver driver;
	public static Properties prop;
	
		public Testbase() throws IOException
			{
				prop=new Properties();
				FileInputStream fs= new FileInputStream("E://Visa_Singapore_project//com.visa.qa//src//main//java//com//amazon//qa//Config//config.properties");
				prop.load(fs);
		
			}
		public static void initlization() throws IOException
			{
				String browsername=prop.getProperty("browser");
				if(browsername.equals("chrome"))
			{
				driver=new ChromeDriver();
			}else
			{
				System.out.println("Please use another browser");
			}
		
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				//driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_WAIT, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS );
				driver.get(prop.getProperty("url"));
}
		
		public static void Window_popup(int tabnumber)
		{
			 ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
			    driver.switchTo().window(tabs2.get(tabnumber));
		}
}
