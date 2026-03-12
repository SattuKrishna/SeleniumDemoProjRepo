package test;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.AccountPage;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import resources.Base;

public class LoginTest extends Base {
	
	
	
	
	Logger log;
	WebDriver driver;
	@Test(dataProvider="getlogindata")
	public void login(String email,String password,String expectedResult) throws IOException, InterruptedException
	{
	    
	    
		LoginPage loginpage=new LoginPage(driver);
		
		loginpage.homepage().click();
		log.debug("Clicked on my application");
		loginpage.loginbutton().click();
		log.debug("Clicked on login option");
		
		LandingPage landingpage=new LandingPage(driver);
		
		
		landingpage.email().sendKeys(email);
		log.debug("Email Got Entered");
		landingpage.password().sendKeys(password);
		log.debug("Password got entered");
		landingpage.login().click();
		log.debug("Clicked on login option");
		AccountPage accountpage=new AccountPage(driver);
		String actualResult = null; 
		try {
		if(accountpage.accountPage().isDisplayed())
		{
		
		actualResult="Successfull";
		
		
		}
		}
		catch(Exception e)
		{
			System.out.print("Inside catch block");
			actualResult="Failure";
		}
		
		Assert.assertEquals(actualResult, expectedResult);
	
	
	}
	
	@BeforeMethod
	public void openapplication() throws IOException
	{
		log = LogManager.getLogger(LoginTest.class.getName());
		driver=intializeBrowser();
		log.debug("Browser Got Lauched");
		driver.get(prop.getProperty("url"));
		log.debug("Navigated to the application URL");
		
	}
	
	@AfterMethod
	public void closebrowser()
	{
		driver.close();
	}
	
	@DataProvider()
	public Object[][] getlogindata()
	{
		Object[][] data= {{"KrishnaSelenium@gmail.com","12345678","Successfull"},{"KrishnaSelenium123@gmail.com","123456789","Failure"}};
		return data;
	}
	
	

}
