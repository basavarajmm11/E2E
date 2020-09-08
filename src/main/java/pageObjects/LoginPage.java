package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pageObjects.ForgotPassword;

public class LoginPage 
{
	public WebDriver driver;

	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}


	private By userEmail=By.cssSelector("input[id='user_email']");
	private By userPassword=By.cssSelector("input[id='user_password']");
	private By logButton=By.name("commit");
	private By forgotPassword=By.xpath("//a[@class='link-below-button']");
	
	//UserName
	public WebElement userId()
	{
		return driver.findElement(userEmail);
	}
	
	//Password
	public WebElement password()
	{
		return driver.findElement(userPassword);
	}
	
	//LoginButton
	public WebElement logInButton()
	{
		return driver.findElement(logButton);
	}
	
	//forgetPwd
		public ForgotPassword forgetPwdLink()
		{
			 driver.findElement(forgotPassword).click();
			 ForgotPassword fp=new ForgotPassword(driver);
			 return fp;
			 
		}
	

}
