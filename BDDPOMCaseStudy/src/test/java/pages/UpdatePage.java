package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.TestBase;

public class UpdatePage {
	WebDriver driver = TestBase.getDriver();
	@FindBy(xpath="(//a[contains(text(),' Edit Article')])[1]")
	WebElement edit; 
	
	@FindBy(xpath="//input[@placeholder='Article Title']") 
	WebElement articleTitle; 
	
	@FindBy(xpath="//input[@class='form-control ' and @name='description']") 
	WebElement articleAbout; 
	
	@FindBy(xpath="//textArea[@rows='8']") 
	WebElement textArea;
	
	@FindBy(xpath="//input[@placeholder='Enter tags']") 
	WebElement enterTags; 
	
	@FindBy(xpath="//button[contains(text(),'Update Article')]")
	WebElement updateBtn; 
	
	@FindBy(xpath="(//a[@href='#/'])[2]") 
	WebElement homeBtn;
	
	@FindBy(xpath="//button[@class='nav-link ']")
	WebElement globalfeed;
	
//	@FindBy(xpath="//h1[contains(text(),'Article2')]")
//    WebElement updatedTitle;
	
	@FindBy(xpath = "(//a[@class=\"author\"])[1]")
	WebElement profile;
	
//	@FindBy(xpath = "//h1[contains(text(),'Article5')]")
//	WebElement articleHeader;
	
//	@FindBy(xpath="//h1[contains(text(),'Article2')]")
//    WebElement updatedTitle;
	
	public UpdatePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void navigateToProfile()
	{
		profile.click();
		//articleHeader.click();
	}
	
	
	
	public void updateArticle(String strTitle,String strAbout) { 
		edit.click(); 	 	 
		articleTitle.clear(); 	 	
		articleTitle.sendKeys(strTitle); 	 	
		articleAbout.clear(); 	 	
		articleAbout.sendKeys(strAbout); 	 
		updateBtn.click();
		
	}
	public WebElement locateTitle(String strTitle) {
	    String xpathExpression = "//h1[contains(text(),'" + strTitle + "')]";
	    WebElement articleToUpdate = driver.findElement(By.xpath(xpathExpression));
	    return articleToUpdate;
	}

	public String updatedName(String strTitle)
	{
		String xpathExpression ="//h1[contains(text(),'" + strTitle + "')]";
		String updatedTitle =driver.findElement(By.xpath(xpathExpression)).getText();
		return updatedTitle;
	}
	
}
