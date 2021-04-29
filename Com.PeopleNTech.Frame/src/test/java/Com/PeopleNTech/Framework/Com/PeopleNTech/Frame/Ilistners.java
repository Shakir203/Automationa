package Com.PeopleNTech.Framework.Com.PeopleNTech.Frame;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;



public class Ilistners extends Usability implements ITestListener {
    public Logger lg=Logger.getLogger(Ilistners.class.getName());
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("started");
		PropertyConfigurator.configure(System.getProperty("user.dir")+"\\target\\log4j.properties");
	    lg.info("Starting the test");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		 String Path=System.getProperty("user.dir");
		Date dt=new Date();
		String sw=dt.toString().replace(" ", "_").replace(":", "_");
		this.driver = ((Usability)result.getInstance()).driver;
		File ds=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(ds, new File(Path+"\\Pictures\\Passed\\"+sw+"Pictures.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		 String Path=System.getProperty("user.dir");
		 Date dt=new Date();
			String sw=dt.toString().replace(" ", "_").replace(":", "_");
			this.driver = ((Usability)result.getInstance()).driver;
			File ds=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try {
				FileHandler.copy(ds, new File(Path+"\\Pictures\\Failed\\"+sw+"Shots.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
	}
	

}
