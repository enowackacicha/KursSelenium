package PageObject.NewAddress;

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

import java.util.concurrent.TimeUnit;

public class AdressStepDenitions {
    NewAdressPage newAdressPage;
    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver.exe");

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        newAdressPage = new NewAdressPage(driver);
    }

    @Given("^User is logged in to CodersLab shop$")
    public void userIsLooggedInToCodersLabShop() {
        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=authentication");
        LoginPage2 loginPage = new LoginPage2(driver);
        loginPage.loginAs("michal.dobrzycki@coderslab.pl", "CodersLab");
    }

    @When("^User goes to UserAccount$")
    public void userGoesToUserInformationPage() {
        newAdressPage.viewAccount();
//        newAdressPage.viewInformation();
    }

    @And("^User goes to Address$")
    public void userGoesToAddressesPage() {
        newAdressPage.viewAddresses();
        newAdressPage.createNewAddressLnkSubmit();
    }

    //    @And("User changes his birthday to {string}")
    @And("User creates new adress {string}, {string}, {string}")
    public void userCreatesNewAddress(String address, String city, String postalCode) {
        newAdressPage.setAddress1(address);
        newAdressPage.setCityInput(city);
        newAdressPage.setPostalCodeInput(postalCode);
//        userInfoPage.setBirthdate(date);
    }

    @And("^User saves details$")
    public void userSavesDetails() {
        newAdressPage.saveBtn.submit();
    }

    //    @Then("User sees {string}")
//    public void userSees(String message) {
//        Assert.assertEquals(message, userInfoPage.getUpdateInformation());
//    }
    @Then("User sees {string}")
    public void messageIsDiisplayed(String message) {
        Assert.assertEquals(message, newAdressPage.getSuccessInformation());
    }
//    @After
//    public void tearDown() {
//        driver.quit();
//    }

}
