package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Acadmy.Base;
import pageObjects.LandingPage;
import pageObjects.LoginPage;

public class validateTittle extends Base
{
	public WebDriver driver;
	public static Logger log=LogManager.getLogger(Base.class.getName());
	LandingPage lap;
	
	
	@BeforeTest
	public void initialize() throws IOException
	{
	driver=initializeDriver();
	log.info("Initializing the driver");
	
	driver.get(prop.getProperty("url"));
	log.info("Navigated to Home page");
	}
	
	@Test
	public void basePageNavigationn_Tittle() throws IOException
	{
		
		
	    lap=new LandingPage(driver);
		String V_Tittle = lap.getTittle().getText();
		System.out.println(V_Tittle);
		
		Assert.assertEquals(V_Tittle, "FEATURED COURSES");
		log.info("Succesfully validated the Fetured");
		
		boolean navBar = lap.getNavigation().isDisplayed();
		System.out.println(navBar);
		Assert.assertTrue(navBar);	
		
		log.info("Succesfully validated the navigatin bar");
		//Assert.assertTrue(false);
		
	}
	@Test
	public void vvalidateTittleHeader() throws IOException
	{
		
		
		
		String V_TittleHeader = lap.getTittleHeader().getText();
		System.out.println(V_TittleHeader);
		
		Assert.assertEquals(V_TittleHeader, "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
		log.info("Succesfully validated the ACADEMY HEADR");
		
		Assert.assertTrue(false
				);
		
	}
	
	@AfterTest
	public void closeBrowser()
	{
		driver.close();
	}
	
	
}
