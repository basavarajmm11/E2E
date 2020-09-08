package Acadmy;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportss {

	  public static ExtentReports extent ;

    public static ExtentReports getReportObject()
    {
    	String timeStamp1 = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
    						;
    	                    
    	 
		//String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
		//String repName="Test-Report-"+timeStamp+".html";
		//String path=System.getProperty("user.dir")+"\\logs\\"+repName;
		
		String path=System.getProperty("user.dir")+"\\reports\\"+"fist"+timeStamp1+".html";
		System.out.println(path);
		
		

      
		
		
		
		ExtentSparkReporter rep=new ExtentSparkReporter(path);
		rep.config().setDocumentTitle("InetBanking Test Project"); // Tile of report
		rep.config().setReportName("Functional Test Automation Report"); // name of the report
		rep.config().setTheme(Theme.DARK);
		
		
		
	    extent = new ExtentReports();
		extent.attachReporter(rep);
		extent.setSystemInfo("Tester","Basavaraj");

         extent.setSystemInfo("Day 8 ", "Extent Report Generation");
         extent.setSystemInfo("Training", "Selenium");
         extent.setSystemInfo("Topic", "ExtentReports");
         
         return extent;
    }
}
