package com.amazon.qa.Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.Testbase.Testbase;

public class Product_page extends Testbase {


	@FindBy(xpath="//*[@id='s-results-list-atf']/li[@id='result_0']/div/child::div[@class='a-row a-spacing-mini']/div/a/h2")
	WebElement Capture_product_name;
	
	@FindBy(xpath="//*[@id='s-results-list-atf']/li[@id='result_0']/div/child::div[@class='a-row a-spacing-mini']/div/a/span")
	WebElement Validate_price;
	
	@FindBy(xpath="//input[@id='add-to-cart-button' and @name='submit.add-to-cart']")
	WebElement Add_to_cart;
	
	@FindBy(xpath="//span[text()='Hello, balaji']")
	WebElement Mouse_hover_on_Sign_link;
	
	@FindBy(xpath="//span[text()='Sign Out']")
	WebElement Click_logout;
	
	@FindBy(xpath="//span[@id='nav-cart-count']")
	WebElement Click_cart_quantity;
	
	@FindBy(xpath="//*[@id='a-autoid-0-announce']")
	WebElement number_product_cart;
	
	public Product_page() throws IOException {
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	public String Product_name()
	{
		String name=Capture_product_name.getText();
		return name;
	}
	public String Product_Price()
	{
		String price=Validate_price.getText();
		return price;
	}
	
	
	public void add_to_Basket()
	{
		Capture_product_name.click();
		
	}
	
	public void Add_to_cart_button()
	{
		Add_to_cart.click();
	}
	
	public void click_Logout() throws IOException
	{
		Actions action=new Actions(driver);
		action.moveToElement(Mouse_hover_on_Sign_link).build().perform();
		Click_logout.click();
	}
	
	public void cart_quantity()
	{
		Click_cart_quantity.click();	
	}
	
	public int products_inCart()
	{
		String product_count=number_product_cart.getText();
		int quantity=Integer.parseInt(product_count);
		return quantity;
	}
	
}
