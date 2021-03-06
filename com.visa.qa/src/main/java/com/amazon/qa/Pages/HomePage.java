package com.amazon.qa.Pages;




import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.Testbase.Testbase;

public class HomePage   extends Testbase{
	
	@FindBy(xpath="//span[text()='Hello. Sign in']")
	WebElement Mouse_hover_on_Sign_link;

	public HomePage() throws IOException {
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
		
	public void click_signin_Link() throws IOException
	{
		Actions action=new Actions(driver);
		action.moveToElement(Mouse_hover_on_Sign_link).build().perform();
		Mouse_hover_on_Sign_link.click();
	
		
	}
	
	public String VerifyHomePageTitle()
	{
		return driver.getTitle();
	}
}
