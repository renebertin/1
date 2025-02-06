//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package pages;

import config.properties.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    private static final String signupName = PropertiesReader.read("signupname");
    private static final String signupEmail = PropertiesReader.read("signupemail");
    @FindBy(
        xpath = "<title>Automation Exercise</title>"
    )
    private WebElement getTitle;
    @FindBy(
        xpath = "//li/a[contains(text(), 'Signup / Login')]"
    )
    private WebElement signupLoginPageLink;
    @FindBy(
        xpath = "//div[@class='fc-dialog-content']"
    )
    private WebElement cookiePopUp;
    @FindBy(
        xpath = "//button[@class='fc-button fc-cta-consent fc-primary-button']"
    )
    private WebElement iAgree;
    @FindBy(
        xpath = "//h2[text()='New User Signup!']"
    )
    private WebElement textVerify;
    @FindBy(
        xpath = "//input[@data-qa='signup-name']"
    )
    private WebElement signupNameField;
    @FindBy(
        xpath = "//input[@data-qa='signup-email']"
    )
    private WebElement signupEmailField;
    @FindBy(
        xpath = "//button[@data-qa='signup-button']"
    )
    private WebElement signupButton;
    @FindBy(
        xpath = "//input[@data-qa='login-email']"
    )
    private WebElement loginEmail;
    @FindBy(
        xpath = "//input[@data-qa='login-password']"
    )
    private WebElement loginPassword;
    @FindBy(
        xpath = "//button[@data-qa='login-button']"
    )
    private WebElement loginButton;

    public void setSignupName() {
        this.signupNameField.sendKeys(new CharSequence[]{signupName});
    }

    public void setSignupEmail() {
        this.signupEmailField.sendKeys(new CharSequence[]{signupEmail});
    }

    public void clickSignupButton() {
        this.signupButton.click();
    }

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public String getHomePageTitle() {
        this.driver.get("http://automationexercise.com");
        String title = this.driver.getTitle();
        return title;
    }

    public void isCookiePopupVisible() {
        if (this.cookiePopUp.isDisplayed()) {
            this.iAgree.click();
        }

    }

    public void clickSignupLoginPage() {
        this.signupLoginPageLink.click();
    }

    public void textVisible() {
        this.textVerify.isDisplayed();
    }

    public boolean textVerify() {
        boolean status = false;
        if (this.textVerify.isDisplayed()) {
            status = true;
        }

        return status;
    }
}
