package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage 
{
	public WebDriver driver;
	
	private By signIn=By.cssSelector("a[href*='sign_in']");
	private By tittle=By.xpath("//div[@class='container']//div[@class='text-center']");
	private By navigationBar=By.xpath("//ul[@class='nav navbar-nav navbar-right']");
	private By header=By.cssSelector("div[class*=video-banner] h3");
	
	
	public LandingPage(WebDriver driver)
	{
		this.driver=driver;
	}
	//Login link
	public LoginPage getLogIn()
	{
	driver.findElement(signIn).click();
	LoginPage lp=new LoginPage(driver);
	return lp;
	}
	//Tittle verfication
	public WebElement getTittle()
	{
		return driver.findElement(tittle);
	}
	//Navigation verification
	public WebElement getNavigation()
	{
		return driver.findElement(navigationBar);
	}
	public WebElement getTittleHeader()
	{
		return driver.findElement(header);
	}
}
