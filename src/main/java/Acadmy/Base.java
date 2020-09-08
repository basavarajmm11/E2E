package Acadmy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Base
{
	public WebDriver driver;
	public 
	Properties prop;

	public WebDriver initializeDriver() throws IOException
	{
        String dataPath = System.getProperty("user.dir")+"\\src\\main\\resources\\BaseData.properties";
	    prop=new Properties();
		FileInputStream fis=new FileInputStream(dataPath);
		
		//loading properties file 
		prop.load(fis);
		
		//Reading properties file
		
		String browserName = System.getProperty("browser");
		
		//String browserName = prop.getProperty("browser");
		System.out.println(browserName);
		

		
		if(browserName.contains("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "F://Basavaraj//driver//chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
			if(browserName.contains("headless"))
			{
				options.addArguments("headless");
			}
			
			driver = new ChromeDriver(options);
			//driver = new ChromeDriver();
		}
		
		else if(browserName=="firefox")
		{
			//
		}
		
		else if(browserName=="IE")
		{
			//
		}
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
		return driver;
		
	}
	
	
	public String getScreenshotPath(String testCaseName,WebDriver driver) throws IOException
	{
		//------Take SCreenshot---------
		 String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("user.dir")+"\\reports\\"+testCaseName+timeStamp+".png"
				;
		FileUtils.copyFile(source, new File(dest));
		return dest;
		
		//or
		/*String dest = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png");
		FileUtils.copyFile(source, new File(dest));*/
	}
}
