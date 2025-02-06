package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import pages.SignupPage;

public class TestBase {
    public WebDriver driver;
    SignupPage loginPage;
    HomePage homePage;
    SignupPage signupPage;

    @BeforeMethod
    public void setUp() {
        //System.out.println("Setup: Initialize browser and navigate to base URL");
        // Ścieżka do sterownika ChromeDriver
        //System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

//    public void setupLoginPage() {
//        loginPage = new SignupPage(driver);
//        homePage = new HomePage(driver);
//        signupPage = new SignupPage(driver);
//    }
//    @BeforeMethod
//    public void setupLoginPage(){
//        loginPage = new SignupPage(driver);
//        homePage = new HomePage(driver);
//        signupPage = new SignupPage(driver);
//    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            //driver.quit();
        }
    }
}
