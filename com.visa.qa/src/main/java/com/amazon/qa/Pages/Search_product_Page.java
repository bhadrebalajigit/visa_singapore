package com.amazon.qa.Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.Testbase.Testbase;

public class Search_product_Page extends Testbase{
	
	public Search_product_Page() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//input[@id='twotabsearchtextbox' and @type='text']")
	WebElement Enter_Product;
	
	@FindBy(xpath="//input[@class='nav-input' and @type='submit']")
	WebElement search_Product;
	

	public void Search_product(String product) throws IOException
	{
		Enter_Product.sendKeys(product);
		search_Product.click();
	 }
}