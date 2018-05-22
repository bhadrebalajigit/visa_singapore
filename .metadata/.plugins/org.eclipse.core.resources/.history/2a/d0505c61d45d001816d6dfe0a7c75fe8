package com.amazon.qa.Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.Testbase.Testbase;

public class LoginPage extends Testbase {
	
	@FindBy(xpath="//input[@id='ap_email']")
	WebElement username_textbox;
	
	@FindBy(xpath="//input[@id='continue']")
	WebElement continue_button;
	
	@FindBy(xpath="//input[@id='ap_password']")
	WebElement password_textbox;
	
	@FindBy(xpath="//input[@id='signInSubmit']")
	WebElement continue_button_login;
	
	@FindBy(xpath="//div[@id='nav-tools']/a/span[@class='nav-line-1' and contains(text(),'balaji')]")
	WebElement validate_correct_user;
	
	@FindBy(xpath="//span[@class='a-list-item' and contains(text(),'We cannot find')]")
	WebElement invalid_error_meesage;
	
	@FindBy(xpath="//span[@class='a-list-item' and contains(text(),'password is incorrect')]")
	WebElement invalid_error_password;
	
	//"//span[@class='a-list-item' and contains(text(),'password is incorrect')]"
	public LoginPage() throws IOException {
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	public void Enter_valid_credentials(String username,String password) throws IOException
	{
		username_textbox.sendKeys(username);
		continue_button.click();
		password_textbox.sendKeys(password);
		continue_button_login.click();
	 }
	
	public void Enter_invalid_username(String invalidusername) throws IOException
	{
		username_textbox.sendKeys(invalidusername);
		continue_button.click();
	 }
	
	public String Validate_error_message_email()
	{
		String Email_Error_message=invalid_error_meesage.getText();
		return Email_Error_message;
	}
	
	public void Enter_valid_Email_Invalid_password(String username,String invalidpassword) throws IOException
	{
		username_textbox.sendKeys(username);
		continue_button.click();
		password_textbox.sendKeys(invalidpassword);
		continue_button_login.click();
	 }
	
	public String Validate_error_message_password()
	{
		String Email_Error_message=invalid_error_meesage.getText();
		return Email_Error_message;
	}
	public String Verify_user_login_sucesfully()
	{
		String validate=validate_correct_user.getText();
		return validate;
	}
	

}
