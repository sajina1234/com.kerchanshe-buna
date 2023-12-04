package com.kerchanshe.base;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.kerchanshe.constants.Constants;
import com.kerchanshe.utilities.ScreenShot;
import com.kerchanshe.utilities.WaitUtility;





public class Base {
	public WebDriver driver;
	Properties properties = new Properties();
	FileInputStream fileinputstream;
ScreenShot screenshot=new ScreenShot();
	public Base()  {
		try {
			fileinputstream=new FileInputStream(Constants.CONFIG_FILE_PATH);
			properties.load(fileinputstream);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("an error in config file path");
		}
	}

	public void intialize(String browser, String url) {
		if (browser.equals("chrome")) {
			//ChromeOptions options = new ChromeOptions();
			//options.addArguments("−−incognito");
			//DesiredCapabilities caps = DesiredCapabilities.chrome();
			//caps.setCapability(ChromeOptions.CAPABILITY, options);
			 //driver = new ChromeDriver(options);
			driver = new ChromeDriver();
			
		} else if (browser.equals("firefox")) {
			
			driver = new FirefoxDriver();
		} else if (browser.equals("edge")) {
			
			driver = new EdgeDriver();
		}
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitUtility.IMPLICIT_WAIT));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
@Parameters("browser")
	@BeforeMethod(enabled=false,alwaysRun=true)
	public void launchBrowser(String browser) {
		
		String url=properties.getProperty("url");
		intialize(browser,url);
	}
@BeforeMethod(enabled=true ,alwaysRun=true)
public void launchBrowser() {
	String browser=properties.getProperty("browser");
	String url=properties.getProperty("url");
	intialize(browser,url);
}
	@AfterMethod
	public void terminateBrowser(ITestResult itest) {
		if(itest.getStatus()==ITestResult.FAILURE) {
			screenshot.takeScreenShot(driver, itest.getName());
		}
		driver.close();
	}
}



