package tests.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import pages.HomePage;
import pages.SignupPage;
import tests.TestBase;

import java.util.Objects;

public class SignupSteps extends TestBase {
    private static final Logger log = LoggerFactory.getLogger(SignupSteps.class);
    //WebDriver driver;
    HomePage homePage;
    SignupPage loginPage;

    @Given("I launch the browser")
    public void i_launch_the_browser() {
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        System.out.println("1 step Given");
        super.setUp();
    }

    @When("I navigate to the URL {string}")
    public void i_navigate_to_the_URL(String url) {
        driver.get(url);
        System.out.println("to jest strona" + url);
    }

    @Then("I should see the home page successfully")
    public void i_should_see_the_home_page_successfully() {
        Assert.assertTrue(Objects.requireNonNull(driver.getCurrentUrl()).contains("https://automationexercise.com/"), "To nie jest HomePage");
        System.out.println("3 step Then");
    }

    @When("I click on \"Signup Login\" button")
    public void iClickOnSignupLoginButton() {
        homePage = new HomePage(driver);
        homePage.isCookiePopupVisible();
        homePage.clickSignupLoginPage();
        System.out.println("Clicking on 'Signup/Login' button...");
    }

    @Then("I verify \"New User Signup\" is visible")
    public void i_verify_New_User_Signup_is_visible() {
        Assert.assertTrue(homePage.textVerify(),"Text 'New User Signup' not visible");
    }

    @When("I enter {string} as name and {string} as email address")
    public void i_enter_as_name_and_as_email_address(String name, String email) {
        loginPage = new SignupPage(driver);
        loginPage.setSignupName();
        loginPage.setSignupEmail();
        System.out.println("krok 6 gdy wprowadzam " + name + "i " + email);
    }

    @When("I click {string} button")
    public void i_click_signup_button(String signup) {
        loginPage.clickSignupButton();
        System.out.println("krok 7 Klikam przycisk Signup");
    }

    @Then("I verify that {string} is visible")
    public void i_verify_is_visible(String text) {
        Assert.assertTrue(loginPage.textVerify1(), "Text " + text +" not visible");
    }

    @When("I fill in the following details:")
    public void i_fillIn_the_following_details(DataTable dataTable) {
        //loginPage.selectTitle("Mr.");
        loginPage.iFillInTheFollowingDetails(dataTable);
    }

    @And("I select the checkbox \"Sign up for our newsletter!\"")
    public void i_select_the_checkbox() {
        loginPage.newsletterCheckBoxClick();
    }

    @And("I select the checkbox \"Receive special offers from our partners!\"")
    public void i_select_the_optin_checkbox() {loginPage.optinCheckboxClick();
    }

    @And("I fill in the following address details:")
    public void i_fill_in_the_following_address_details(DataTable dataTable) {
        loginPage.fillAddressDetails(dataTable);
    }

    @And("I click the \"Create Account\" button")
    public void iClickTheButton() {
        loginPage.createAccountButtonClick();
    }

    @Then("I verify \"ACCOUNT CREATED!\" is visible")
    public void i_verify_is_account_created_visible() {
        Assert.assertTrue(loginPage.textAccountCreated(), "Text ACCOUNT CREATED is not visible");
    }

    @When("I click the \"Continue\" button")
    public void i_click_continue_button_() {loginPage.continueButtonClick();
    }
    
    @Then("I verify \"Logged in as John Doe\" is visible")
    public void i_verify_john_doe_is_visible() {loginPage.loggedTextButtonClick();}

    @When("I click the \"Delete Account\" button")
    public void iClickTheDeleteAccountButton() {loginPage.deleteAccountButton();
    }

    @Then("I verify \"ACCOUNT DELETED!\" is visible")
    public void iVerifyIsVisible() {
    }

    @When("I click the \"Continue\" button after account deletion")
    public void iClickTheContinueButton() {loginPage.continueButtonClick();}
}
