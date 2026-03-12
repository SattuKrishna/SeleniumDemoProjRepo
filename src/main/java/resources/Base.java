package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	
	
	WebDriver driver;
	public Properties prop;
	public WebDriver intializeBrowser() throws IOException
	{
	    prop=new Properties();
		String propPath=System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties";
		
		
		
		FileInputStream fis=new FileInputStream(propPath);
		
		prop.load(fis);
		
		String BrowserName=prop.getProperty("browser");
		
		if(BrowserName.equalsIgnoreCase("Chrome"))
		{
			 driver=new ChromeDriver();
		}
		else if(BrowserName.equalsIgnoreCase("Edge"))
		{
			 driver=new EdgeDriver();
		}
		else if(BrowserName.equalsIgnoreCase("Firefox"))
		{
		     driver=new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}

}
