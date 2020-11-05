package PageObject.ChangeUserInfo;

import PageObject.LoginPage.LoginPage2;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import pl.coderslab.selenium.pageObject.LoginPage2;

import java.util.concurrent.TimeUnit;

public class ChangeUserInfoSteps {
    UserInfoPage userInfoPage;
    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver.exe");

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        userInfoPage = new UserInfoPage(driver);
    }

    @Given("^User is logged in to CodersLab shop$")
    public void userIsLooggedInToCodersLabShop() {
        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=authentication");
        LoginPage2 loginPage = new LoginPage2(driver);
        loginPage.loginAs("michal.dobrzycki@coderslab.pl", "CodersLab");
    }

    @When("^User goes to UserInformationPage$")
    public void userGoesToUserInformationPage() {
        userInfoPage.viewAccount();
        userInfoPage.viewInformation();
    }

    @And("User changes his birthday to {string}")
    public void userChangesHisBirthdayTo(String date) {
        userInfoPage.setBirthdate(date);
    }

    @And("^User signs up for our newsletter$")
    public void userSignsUpForOurNewsletter() {
        userInfoPage.signInForNewsletter();
    }

    @And("^User saves information$")
    public void userSavesInformation() {
        userInfoPage.submitUserInfo();
    }

    @Then("User sees {string}")
    public void userSees(String message) {
        Assert.assertEquals(message, userInfoPage.getUpdateInformation());
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
