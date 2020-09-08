package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Acadmy.Base;
import pageObjects.ForgotPassword;
import pageObjects.LandingPage;
import pageObjects.LoginPage;

public class HomePage extends Base
{
	public WebDriver driver;
	public static Logger log=LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeDriver();
		log.info("Initializing the driver");
		
		
		
	}
	@Test(dataProvider="getData")
	public void basePageNavigation(String Username,String Password,String text) throws IOException
	{
		
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Home page");
		
		LandingPage lap=new LandingPage(driver);
		LoginPage lp = lap.getLogIn();//
		
		
		lp.userId().sendKeys(Username);
		lp.password().sendKeys(Password);
		System.out.println(text);
		log.info("successfully validated the test");
		
		lp.logInButton().click();
		ForgotPassword fp = lp.forgetPwdLink();
		fp.sendMeInstruction().sendKeys("Hello");
		fp.sendMeInstructionButton().click();
	}
	
	@DataProvider
	
	public Object[][] getData()
	{
		
		Object[][] data = new Object[2][3];
		data[0][0]="NonRestUser@qv.com";
		data[0][1]="123456";
		data[0][2]="Resticted user";
		
		data[1][0]="RestUser@qv.com";
		data[1][1]="456789";
		data[1][2]="Non Resticted user";
		return data;
	}
	
	@AfterTest
	public void closeBrowser()
	{
		driver.close();
	}
	

}
