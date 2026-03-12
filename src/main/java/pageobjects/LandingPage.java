package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="input-email")
	 WebElement email;
	@FindBy(id="input-password")
	 WebElement  password;
	@FindBy(xpath="//input[@value='Login']")
	 WebElement login;
	
	
	public WebElement email()
	{
		return email;
	}
	
	public WebElement password()
	{
		return password;
	}
	
	public WebElement login()
	{
		return login;
	}
	
}
