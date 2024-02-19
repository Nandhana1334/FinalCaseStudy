package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.TestBase;

public class ArticlePage {

	
	WebDriver driver = TestBase.getDriver();
//	@FindBy(css = ".nav.navbar-nav.pull-xs-right li:nth-child(2) a")
//	WebElement newArticle;
	@FindBy(xpath="//a[text()='New Article']")
	WebElement newArticle;
	
	
	@FindBy(xpath = "//input[@name='title']")
	WebElement title;
	
	@FindBy(xpath = "//input[@name='description']")
	WebElement desc;
	
	@FindBy(xpath = "//textarea[@name='body']")
	WebElement textArea;
	
	@FindBy(xpath = "//input[@name='tags']")
	WebElement tags;
	
	@FindBy(xpath="//button[@type='submit']") 	 
	WebElement btn;
//	
	
//	@FindBy(xpath="//h1[contains(text(),'Article4')]")
//    WebElement chkHeader;
	
	@FindBy(xpath="//span[text()='Title already exists.. ']")
	WebElement invalidMsg;
	
	
	public ArticlePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void createNewArticle()
	{
		newArticle.click();
	}
	
	public void publishArticle(String strTitle,String strDesc,String strtextArea)
	{
		//newArticle.click();
		title.clear();
		title.sendKeys(strTitle);
		desc.clear();
		desc.sendKeys(strDesc);
		textArea.clear();
		textArea.sendKeys(strtextArea);
		tags.sendKeys("");
		btn.click();
		
	}
	

	public String articleName(String articleName)
	{
		String xpathExpression = "//h1[contains(text(),'" + articleName + "')]";
		WebElement chkHeader = driver.findElement(By.xpath(xpathExpression));
		return chkHeader.getText();
	}
	public String duplicateTitle()
	{
		return invalidMsg.getText();
	}
	
	
}
