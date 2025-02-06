package pages;

import config.properties.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    private static final String login = PropertiesReader.read("login");
    private static final String password = PropertiesReader.read("password");

    //*******Locator Repositories***********************//
    @FindBy(xpath = "//h2[text()='Login to your account']")
    private WebElement loginText;

    @FindBy(xpath = "//input[@data-qa='login-email']")
    private WebElement loginEmailField;

    @FindBy(xpath = "//input[@data-qa='login-password']")
    private WebElement loginPasswordField;

    @FindBy(xpath = "//button[@data-qa='login-button']")
    private WebElement loginButton;

    @FindBy(xpath = "//li/a[contains(text(), 'Logged in as')]")
    private WebElement loggedInAsUsernameText;

    @FindBy(xpath = "//li/a[contains(text(), 'Logout')]")
    private WebElement logoutButton;


   public LoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean verifyLoginText() {
        boolean status = false;
        if (loginText.isDisplayed()) {
            status = true;
        }
        return status;
    }

    public void enterLoginEmail() {
        loginEmailField.sendKeys(login);
    }

    public void enterPassword(){
        loginPasswordField.sendKeys(password);
    }

    public void loginButtonClick(){
        loginButton.click();
    }

    public boolean verifyLoggedInAsUsernameText() {
        boolean status = false;
        if (loggedInAsUsernameText.isDisplayed()) {
            status = true;
        }
        return status;
    }

    public void logoutButtonClick(){
        logoutButton.click();
    }

}
