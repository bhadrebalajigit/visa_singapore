package com.amazon.qa.Testcases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.amazon.qa.Pages.HomePage;
import com.amazon.qa.Pages.LoginPage;
import com.amazon.qa.Pages.Product_page;
import com.amazon.qa.Pages.Search_product_Page;
import com.amazon.qa.Testbase.Testbase;

public class Visa_postive_tests extends Testbase {
	
	HomePage homepage;
	LoginPage loginpage;
	Search_product_Page searchproduct;
	Product_page productpage;
	public Visa_postive_tests() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeMethod
	public void setup() throws IOException
	{
		Testbase.initlization();
		homepage= new HomePage();
		loginpage=new LoginPage();
		searchproduct=new Search_product_Page();
		productpage= new Product_page();
	}
	@Test(priority=1)
	public void Verify_HomePage_Title_test1() 
	{
		String title=homepage.VerifyHomePageTitle();
		System.out.println("Page Header of Amazon:"+title);
		Assert.assertEquals(title,"Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
	}
	@Test(priority=2)
	public void Valid_credentials_Validate_header_test2() throws IOException 
	{
		homepage.click_signin_Link();
		System.out.println("Entering userName and Password");
		loginpage.Enter_valid_credentials(prop.getProperty("username"),prop.getProperty("password"));
	    String validate_user=loginpage.Verify_user_login_sucesfully();
	    System.out.println("**********User logged********:" +validate_user);
	    Assert.assertEquals(validate_user,"Hello, balaji",validate_user+"User logged sucessfully");
	}
	
	@Test(priority=3)
	public void Search_iphonex64gb_test3() throws IOException 
	{
		homepage.click_signin_Link();
		loginpage.Enter_valid_credentials(prop.getProperty("username"),prop.getProperty("password"));
	    String validate_user=loginpage.Verify_user_login_sucesfully();
	    System.out.println("User logged:" +validate_user);
	    Assert.assertEquals(validate_user,"Hello, balaji",validate_user+"User logged sucessfully");
	    searchproduct.Search_product(prop.getProperty("Product_iphonex"));
	}
	
	@Test(enabled=false)
	public void Capture_productname_price_add_quantity_basket_test4() throws IOException 
	{
		homepage.click_signin_Link();
		loginpage.Enter_valid_credentials(prop.getProperty("username"),prop.getProperty("password"));
	    String validate_user=loginpage.Verify_user_login_sucesfully();
	    System.out.println("User logged:" +validate_user);
	    Assert.assertEquals(validate_user,"Hello, balaji",validate_user+"User logged sucessfully");
	    searchproduct.Search_product(prop.getProperty("Product_iphonex"));
	    String product_name=productpage.Product_name();
	    System.out.println("Name of Product to be selected:"+product_name);
	    String Product_price=productpage.Product_Price();
	    System.out.println("Price of Product to be selected:"+Product_price);
	    System.out.println("********Product adding to Basket**************");
	    productpage.add_to_Basket();
	    System.out.println("********Product added to basket**************");
	    Testbase.Window_popup(1);
        productpage.Add_to_cart_button();
        System.out.println("*********Clicking on Logout*******************");
        productpage.click_Logout();   
	}
	
	@Test
	public void login_again_validate_product_basket_test5() throws IOException 
	{
		homepage.click_signin_Link();
		System.out.println("Entering userName and Password");
		loginpage.Enter_valid_credentials(prop.getProperty("username"),prop.getProperty("password"));
	    String validate_user=loginpage.Verify_user_login_sucesfully();
	    System.out.println("**********User logged********:" +validate_user);
	    Assert.assertEquals(validate_user,"Hello, balaji",validate_user+"User logged sucessfully");
	    System.out.println("*************Checking Cart quantity**************");
	    productpage.cart_quantity();
	    System.out.println("*************Number of products in cart**************");
	    int quantities=productpage.products_inCart();
	    if(quantities>0)
	    {
	    	System.out.println("Number of products avaliable in cart:"+quantities);
	    }else
	    {
	    	System.out.println(" products not avaliable in cart:");
	    }
	    
	}
	@AfterMethod
	 public void TearDown(ITestResult result) throws IOException{
	  
	  if (result.getStatus() == ITestResult.FAILURE || result.getStatus() == ITestResult.SUCCESS ){
	   TakesScreenshot ts = (TakesScreenshot)driver;
	   File srcFile = ts.getScreenshotAs(OutputType.FILE);
	   FileUtils.copyFile(srcFile, new File("E://Visa_Singapore_project//com.visa.qa//src//test//java//com//amazon//qa//Screenshots//Postive//"+result.getName()+"_"+new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date())+".jpg"));
	   //result.getname() method will give you current test case name. 
	   //./ScreenShots/ tell you that, in your current directory, create folder ScreenShots. dot represents current directory
	  }
	  driver.close();
	 }
}
