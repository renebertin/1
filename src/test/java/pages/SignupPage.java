package pages;

import config.properties.PropertiesReader;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import java.util.Map;


public class SignupPage extends BasePage {

    private static final String signupName = PropertiesReader.read("signupname");
    private static final String signupEmail = PropertiesReader.read("signupemail");
    private static final String signupPassword = PropertiesReader.read("signuppassword");

    @FindBy(xpath = "//input[@data-qa='signup-name']")
    private WebElement signupNameField;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    private WebElement signupEmailField;

    @FindBy(xpath = "//button[@data-qa='signup-button']")
    private WebElement signupButton;

    @FindBy(xpath = "//div[@class='fc-dialog-content']")
    private WebElement cookiePopUp;

    @FindBy(xpath = "//button[@class='fc-button fc-cta-consent fc-primary-button']")
    private WebElement iAgree;

    @FindBy(xpath = "//li/a[contains(text(), 'Signup / Login')]")
    private WebElement signupLoginPageLink;

    @FindBy(xpath = "//h2[@class='title text-center']/b[text()='Enter Account Information']")
    private WebElement textVerify1;

    // Lokatory elementów formularza
    @FindBy(xpath = "//input[@id='id_gender1']")
    private WebElement titleMr;

    @FindBy(id = "//input[@id='id_gender2']")
    private WebElement titleMrs;

    @FindBy(id = "name")
    private WebElement nameField;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "days")
    private WebElement daysPicker;

    @FindBy(id = "months")
    private WebElement monthsPicker;

    @FindBy(xpath = "//input[@id='newsletter']")
    private WebElement newsletterCheckbox;

    @FindBy(id = "optin")
    private WebElement optinCheckbox;

    @FindBy(id = "first_name")
    private WebElement firstNameField;

    @FindBy(id = "last_name")
    private WebElement lastNameField;

    @FindBy(id = "company")
    private WebElement companyField;

    @FindBy(id = "address1")
    private WebElement address1Field;

    @FindBy(id = "address2")
    private WebElement address2Field;

    @FindBy(id = "country")
    private WebElement countryPicker;

    @FindBy(id = "state")
    private WebElement stateField;

    @FindBy(id = "city")
    private WebElement cityField;

    @FindBy(id = "zipcode")
    private WebElement zipcodeField;

    @FindBy(xpath = "//input[@id='mobile_number']")
    private WebElement mobileNumberField;

    @FindBy(xpath = "//button[contains(text(), 'Create Account')]")
    private WebElement createAccountButton;

    @FindBy(xpath = "//h2[@class='title text-center']/b[text()='Account Created!']")
    private WebElement textAccountCreated;

    @FindBy(xpath = "//div/a[contains(text(), 'Continue')]")
    private WebElement continueButton;

    @FindBy(xpath = "//li/a[contains(text(), 'Delete Account')]")
    private WebElement deleteAccountButton;

@FindBy(xpath = "//li/a[contains(text(), 'Logged in as')]")
    private WebElement loggedTextButton;


    public SignupPage(WebDriver driver) {
        super(driver);
    }

    public void isCookiePopupVisible() {
        if (cookiePopUp.isDisplayed()) {
            iAgree.click();
        }
    }

    public void clickSignupLoginPage() {
        signupLoginPageLink.click();
    }

    public void setSignupName() {
        signupNameField.sendKeys(signupName);
    }

    public void setSignupEmail() {
        signupEmailField.sendKeys(signupEmail);
    }

    public void clickSignupButton() {
        signupButton.click();
    }

    public boolean textVerify1() {
        boolean status = false;
        if (textVerify1.isDisplayed()) {
            status = true;
        }
        return status;
    }

    // Metoda do wyboru tytułu (Mr./Mrs.)
    public void selectTitle(String title) {
        if (title.equalsIgnoreCase("Mr.")) {
            titleMr.click();
        } else {
            titleMrs.click();
        }
        //titleMr.click();
    }

    public void iFillInTheFollowingDetails(DataTable dataTable) {
        // Konwersja DataTable do Mapy
        Map<String, String> details = dataTable.asMap(String.class, String.class);

        // Wypisanie wartości w konsoli (dla testu)
        details.forEach((key, value) -> System.out.println(key + " : " + value));

        // Obsługa pola "Title" (radio button)
        if (details.get("Title").equals("Mr.")) {
            titleMr.click();
        } else if (details.get("Title").equals("Mrs.")) {
            titleMrs.click();
        }

        // Obsługa pól formularza w Selenium WebDriver
        nameField.clear();
        nameField.sendKeys(details.get("Name"));
        // driver.findElement(By.id("password")).sendKeys(details.get("Password"));
        passwordField.clear();
        passwordField.sendKeys("Password");

        // Obsługa daty urodzenia (rozdzielenie daty)
        String[] dob = details.get("Date of birth").split("/");

        // Obsługa wiodących zer (jeśli konieczne)
        String dayValue = String.valueOf(Integer.parseInt(dob[0]));
        String monthValue = String.valueOf(Integer.parseInt(dob[1]));
        System.out.println(dayValue);
        new Select(daysPicker).selectByValue(dayValue);
        new Select(monthsPicker).selectByValue(monthValue);
        new Select(driver.findElement(By.id("years"))).selectByValue(dob[2]);
    }

    public void newsletterCheckBoxClick() {
        newsletterCheckbox.click();
    }

    public void optinCheckboxClick() {
        optinCheckbox.click();
    }

    public void fillAddressDetails(DataTable dataTable) {
        // Konwersja DataTable do Mapy
        Map<String, String> address = dataTable.asMap(String.class, String.class);
        firstNameField.sendKeys(address.get("First name"));
        lastNameField.sendKeys(address.get("Last name"));
        companyField.sendKeys((address.get("Company")));
        address1Field.sendKeys(address.get("Address"));
        address2Field.sendKeys(address.get("Address2"));
        String getCountry = address.get("Country");
        new Select(countryPicker).selectByValue(getCountry);
        stateField.sendKeys(address.get("State"));
        cityField.sendKeys(address.get("City"));
        zipcodeField.sendKeys(address.get("Zipcode"));
        mobileNumberField.sendKeys(address.get("Mobile Number"));
    }

    public void createAccountButtonClick(){
        createAccountButton.click();
    }

    public boolean textAccountCreated() {
        boolean status = false;
        if (textAccountCreated.isDisplayed()) {
            status = true;
        }
        return status;
    }
    public void continueButtonClick(){
        continueButton.click();
    }

    public void deleteAccountButton(){
        deleteAccountButton.click();
    }

    public void loggedTextButtonClick(){
        loggedTextButton.click();
    }

}
