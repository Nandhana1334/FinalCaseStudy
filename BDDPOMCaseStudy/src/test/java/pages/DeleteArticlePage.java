package pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DeleteArticlePage {
	
	WebDriver driver;
//	@FindBy(xpath = "//button[@class='btn btn-sm'][1]")
//	WebElement deleteBtn;
	
	@FindBy(xpath = "(//a[@class=\"author\"])[1]")
	WebElement profile;
	
//	@FindBy(xpath = "//h1[contains(text(),'Article2')]")
//	WebElement articleHeader;
	
	@FindBy(xpath="(//button[text()=' Delete Article'])[2]")
    WebElement deleteBtn;
	
//	@FindBy(xpath="//div[contains(text(),'Articles not available.')]")
//	WebElement deletionText;
	
	public DeleteArticlePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	public void navigateToProfile()
	{
		profile.click();
		
	}
	public WebElement  locateTitle(String strTitle) {
	    String xpathExpression = "//h1[contains(text(),'" + strTitle + "')]";
	    WebElement articleToDelete=driver.findElement(By.xpath(xpathExpression));
	    return articleToDelete;
	}
	
	public void deleteArticle()
	{
		
 	 
		deleteBtn.click();
		
		Alert alert=driver.switchTo().alert();
		Assert.assertEquals(alert.getText(), "Want to delete the article?");
		alert.accept();
     	
		
		
	}
	public String deleteCheck(String deletionMsg) {

	    String xpathExpression = "//div[contains(text(),'" + deletionMsg + "')]";
	    WebElement deletionText = driver.findElement(By.xpath(xpathExpression));
	    return deletionText.getText();
	}

	

}
