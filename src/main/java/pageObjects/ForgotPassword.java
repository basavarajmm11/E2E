package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pageObjects.LoginPage;
public class ForgotPassword
{
	public WebDriver driver;

	public ForgotPassword(WebDriver driver)
	{
		this.driver=driver;
	}


	By sendMeInstructionVar=By.xpath("//input[@id='user_email']");
	By sendMeInstructionButtonVar=By.xpath("//input[@name='commit']");
	
	public WebElement sendMeInstruction()
	{
		return driver.findElement(sendMeInstructionVar);
	}
	
	public WebElement sendMeInstructionButton()
	{
		return driver.findElement(sendMeInstructionButtonVar);
	}
	

}
