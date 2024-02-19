package stepDefinitions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import base.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ArticlePage;
import pages.DeleteArticlePage;
import pages.LoginPage;
import pages.UpdatePage;

public class ArticleFunctions {
	
	WebDriver driver = TestBase.getDriver();
	ArticlePage articlePage;
	DeleteArticlePage deleteArticlePage;
	LoginPage loginPage;
	UpdatePage updateArticlePage;
	
	public ArticleFunctions()
	{
		articlePage = new ArticlePage(driver);
		deleteArticlePage = new DeleteArticlePage(driver);
		loginPage = new LoginPage(driver);
		updateArticlePage = new UpdatePage(driver);
		
	}
	
	@Given("User is on login Page")
	public void user_is_on_login_page() {
	    driver.get("https://conduit-realworld-example-app.fly.dev/#/");
	}
	@When("User enter Invalid Credentials")
	public void user_enter_invalid_credentials(io.cucumber.datatable.DataTable dataTable) {
		List<List<String>> users = dataTable.asLists();
		
		String strUser = users.get(1).get(0);
		String strPwd = users.get(1).get(1);
		loginPage.login(strUser, strPwd);
	}
	@Then("Should display the invalid login message")
	public void should_display_the_invalid_login_message(io.cucumber.datatable.DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
		List<List<String>> invalidMsg = dataTable.asLists();
		String msg = invalidMsg.get(1).get(0);
		Assert.assertEquals(loginPage.invalidMsg(msg),msg);
	}
	
	@When("User enter Valid Credentials")
	public void user_enter_valid_credentials(io.cucumber.datatable.DataTable dataTable) {

		List<List<String>> users = dataTable.asLists();
		String strUser = users.get(1).get(0);
		String strPwd = users.get(1).get(1);
		loginPage.login(strUser, strPwd);
	}
	@Then("Should display the success login message")
	public void should_display_the_success_login_message(io.cucumber.datatable.DataTable dataTable) {
		List<List<String>> userName = dataTable.asLists();
		String strUser = userName.get(1).get(0);
		boolean displayedName=loginPage.nameAfterLogin(strUser);
		 
		Assert.assertTrue(displayedName);
	}
	
	@Given("User is on newArticleCreationPage")
	public void user_is_on_new_article_creation_page() {
	   articlePage.createNewArticle();
	}
	@When("User Create the duplicate article")
	public void user_create_the_duplicate_article(io.cucumber.datatable.DataTable dataTable) {
		List<List<String>> articleDetails = dataTable.asLists();
		String strTitle = articleDetails.get(1).get(0);
		String strAbout = articleDetails.get(1).get(1);
		String strDesc = articleDetails.get(1).get(2);
		articlePage.publishArticle(strTitle, strAbout, strDesc);
	    
	}
	@Then("Should display the duplicate article message")
	public void should_display_the_duplicate_article_message() {
//		List<List<String>> duplicateMsg = dataTable.asLists();
//		String duplicateTitleMsg = duplicateMsg.get(1).get(0);
		Assert.assertEquals(articlePage.duplicateTitle(),"Title already exists..");
	}
	
	@When("User create the new Article")
	public void user_create_the_new_article(io.cucumber.datatable.DataTable dataTable) {
		List<List<String>> articleDetails = dataTable.asLists();
		String strTitle = articleDetails.get(1).get(0);
		String strAbout = articleDetails.get(1).get(1);
		String strDesc = articleDetails.get(1).get(2);
		articlePage.publishArticle(strTitle, strAbout, strDesc);
	    
	}
	@Then("Should display the new Article Title")
	public void should_display_the_new_article_title(io.cucumber.datatable.DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
		List<List<String>> articleDetails = dataTable.asLists();
		String strTitle = articleDetails.get(0).get(0);
	    String articleTitle = articlePage.articleName(strTitle);
	    Assert.assertEquals(articleTitle,strTitle);
	}
	@Given("User is on updateArticlePage")
	public void user_is_on_update_article_page(io.cucumber.datatable.DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
		List<List<String>> articleNameToUpdate = dataTable.asLists();
		String strUpdateTitle = articleNameToUpdate.get(1).get(0);
		updateArticlePage.navigateToProfile();
	    updateArticlePage.locateTitle(strUpdateTitle).click();
	}
	@When("User Update the Article")
	public void user_update_the_article(io.cucumber.datatable.DataTable dataTable) {
		List<List<String>> articleUpdateDetails = dataTable.asLists();
		String strUpdateTitle = articleUpdateDetails.get(1).get(0);
		String strUpdateAbout = articleUpdateDetails.get(1).get(1);
		//String strUpdateDesc = articleUpdateDetails.get(1).get(2);
		updateArticlePage.updateArticle(strUpdateTitle, strUpdateAbout);
	}
	@Then("Should display the updated Article Title")
	public void should_display_the_updated_article_title(io.cucumber.datatable.DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
		List<List<String>> articleUpdatedName= dataTable.asLists();
		String strUpdateTitle = articleUpdatedName.get(1).get(0);
		String updatedTitle = updateArticlePage.updatedName(strUpdateTitle);
		Assert.assertEquals(updatedTitle,strUpdateTitle);
	}
	
	@Given("User is on deleteArticlePage")
	public void user_is_on_delete_article_page(io.cucumber.datatable.DataTable dataTable) {
		List<List<String>> articleNameToDelete = dataTable.asLists();
		String strArticleToDelete = articleNameToDelete.get(1).get(0);
		deleteArticlePage.navigateToProfile();
		deleteArticlePage.locateTitle(strArticleToDelete).click();
	}
	@When("User delete the Article")
	public void user_delete_the_article() {
	   deleteArticlePage.deleteArticle();
	}
	@Then("Should display the article deletion msg")
	public void Should_display_the_article_deletion_msg(io.cucumber.datatable.DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
		List<List<String>> deletionMsg = dataTable.asLists();
		String deletionText = deletionMsg.get(1).get(0);
	    //deleteArticlePage.deleteCheck();
		Assert.assertEquals(deleteArticlePage.deleteCheck(deletionText),deletionText);
	}


	

}
