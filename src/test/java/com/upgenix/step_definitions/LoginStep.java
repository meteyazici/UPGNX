package com.upgenix.step_definitions;

import com.upgenix.pages.LoginPage;
import com.upgenix.utilities.ConfigurationReader;
import com.upgenix.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginStep {

    LoginPage loginPage = new LoginPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);

    @Given("User is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("website"));
    }

    @Then("User should see in title and it should contains {string}")
    public void userShouldSeeInTitleAndItShouldContains(String titleHomePage) {
        wait.until(ExpectedConditions.titleContains(titleHomePage));
        Assert.assertTrue(Driver.getDriver().getTitle().contains(titleHomePage));
    }

    @When("salesmanager enters {string} to to email input")
    public void salesmanagerEntersToToEmailInput(String username1) {
        loginPage.usernameBox.sendKeys(username1);
    }

    @And("salesmanager enter {string} to password input")
    public void salesmanagerEnterToPasswordInput(String password1) {
        loginPage.passwordBox.sendKeys(password1);
    }

    @And("user clicks login button")
    public void userClicksLoginButton() {
        loginPage.loginButton.click();
    }
    @Then("salesmanager should see the #Inbox - Odoo as title")
    public void salesmanager_should_see_the_ınbox_odoo_as_title() {
        wait.until(ExpectedConditions.titleContains("#Inbox - Odoo"));
        Assert.assertTrue(Driver.getDriver().getTitle().equalsIgnoreCase("#Inbox - Odoo"));
    }

    @When("posmanager enters {string} to to email input")
    public void posmanagerEntersToToEmailInput(String emailPos) {
        loginPage.usernameBox.sendKeys(emailPos);
    }

    @And("posmanager enter {string} to password input")
    public void posmanagerEnterToPasswordInput(String passwordPos) {
        loginPage.passwordBox.sendKeys(passwordPos);
    }

    @Then("posmanager should see the #Inbox - Odoo as title")
    public void posmanagerShouldSeeTheInboxOdooAsTitle() {
        wait.until(ExpectedConditions.titleContains("#Inbox - Odoo"));
        Assert.assertTrue(Driver.getDriver().getTitle().equalsIgnoreCase("#Inbox - Odoo"));
    }

    @When("User click to Log in button")
    public void userClickToLogInButton() {
        loginPage.loginButton.click();
    }

    @Then("User should see message {string} under the email box")
    public void userShouldSeeMessageUnderTheEmailBox(String message) {
        message = loginPage.passwordBox.getAttribute("validationMessage");
        Assert.assertEquals("Lütfen bu alanı doldurun.",message);
    }

    @Then("salesmanager should see the {string} alert")
    public void salesmanagerShouldSeeTheAlert(String wrongPandUmessage) {
        wait.until(ExpectedConditions.visibilityOf(loginPage.wrongMessageAlert));
        Assert.assertEquals(wrongPandUmessage,loginPage.wrongMessageAlert.getText());
    }

    @Then("posmanager should see the {string} alert")
    public void posmanagerShouldSeeTheAlert(String wrongPandUmessage) {
        wait.until(ExpectedConditions.visibilityOf(loginPage.wrongMessageAlert));
        Assert.assertEquals(wrongPandUmessage,loginPage.wrongMessageAlert.getText());
    }

    @When("user enters {string} to to email input")
    public void userEntersToToEmailInput(String username) {
        loginPage.usernameBox.sendKeys(username);
    }

    @And("user enter {string} to password input")
    public void userEnterToPasswordInput(String password) {
        loginPage.passwordBox.sendKeys(password,Keys.ENTER);
    }

    @And("user clicks enter button")
    public void userClicksEnterButton() {
        wait.until(ExpectedConditions.titleContains("#Inbox - Odoo"));
    }

    @Then("user should see the #Inbox - Odoo as title")
    public void userShouldSeeTheInboxOdooAsTitle() {
        Assert.assertTrue(Driver.getDriver().getTitle().equalsIgnoreCase("#Inbox - Odoo"));
    }
}
