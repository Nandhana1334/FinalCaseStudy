package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.TestBase;

public class LoginPage {
	
	
	WebDriver driver = TestBase.getDriver();
	
	@FindBy(css =".nav.navbar-nav.pull-xs-right li:nth-child(2) a")
	WebElement loginButton;
	
	@FindBy(name="email")
	WebElement email;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath ="//button[contains(text(),'Login')]")
	WebElement login;
	
	@FindBy(xpath="//img[@alt='Nandhana']")
	WebElement chckName;
	
	@FindBy(xpath="//ul[@class='error-messages']//li[text()='Wrong email/password combination']")
    WebElement invalidmsg;
	
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public boolean nameAfterLogin()
	{
		WebElement chckName=driver.findElement(By.xpath("//img[@alt='Nandhana']"));
		boolean nameDisplayed= chckName.isDisplayed();
		
		return nameDisplayed;
	}
	public void login(String mailId,String pwd)
	{
		loginButton.click();
		email.clear();
		email.sendKeys(mailId);
		password.clear();
		password.sendKeys(pwd);
		login.click();

	}
	
//	public void login(String strMail,String strPwd)
//	{
//		driver.findElement(By.cssSelector(".nav.navbar-nav.pull-xs-right li:nth-child(2) a")).click();
//		driver.findElement(By.name("email")).clear();
//		driver.findElement(By.name("email")).sendKeys(strMail);
//		driver.findElement(By.name("password")).clear();
//		driver.findElement(By.name("password")).sendKeys(strPwd);
//		driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
//	}
	
	public String invalidMsg()
		{
		
			//WebElement invalidmsg = driver.findElement(By.xpath("//ul[@class='error-messages']//li[text()='Wrong email/password combination']"));
			return invalidmsg.getText();
		}
	

}
