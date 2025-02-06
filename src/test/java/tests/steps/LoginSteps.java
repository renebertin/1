package tests.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;
import tests.TestBase;

import java.util.Objects;

public class LoginSteps extends TestBase {
    HomePage homePage;
    LoginPage loginPage;

    @Given("the user launches the browser")
    public void the_user_launches_the_browser() {
        super.setUp();
    }

    @When("the user navigates to URL {string}")
    public void the_user_navigates_to_URL(String url) {
        driver.get(url);
    }

    @Then("the home page should be visible successfully")
    public void the_home_page_should_be_visible_successfully() {
        Assert.assertTrue(Objects.requireNonNull(driver.getCurrentUrl()).contains("https://automationexercise.com/"), "To nie jest HomePage");
   }

    @When("the user clicks on the \'Signup Login\' button")
    public void the_user_clicks_on_the_signup_login_button() {
        homePage = new HomePage(driver);
        homePage.isCookiePopupVisible();
        homePage.clickSignupLoginPage();
    }

    @Then("the \'Login to your account\' section should be visible")
    public void the_login_to_your_account_section_should_be_visible() {
        loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.verifyLoginText(),"Text 'Login to your account' not visible");
    }

    @When("the user enters the correct email address and password")
    public void the_user_enters_the_correct_email_address_and_password() {
        loginPage.enterLoginEmail();
        loginPage.enterPassword();
    }

    @And("clicks the \'login\' button")
    public void clicks_the_login_button() {
        loginPage.loginButtonClick();
    }

    @Then("the message \'Logged in as username\' should be visible")
    public void the_message_logged_in_as_username_should_be_visible() {
        loginPage.verifyLoggedInAsUsernameText();
    }

    @When("the user clicks on the \'Logout\' button")
    public void the_user_clicks_on_the_delete_account_button() {
        loginPage.logoutButtonClick();
    }

    @Then("the message \'Login to your account\' should be visible")
    public void the_message_login_to_your_account_should_be_visible() {
        Assert.assertTrue(loginPage.verifyLoginText(),"Text 'Login to your account' not visible");
    }
}
