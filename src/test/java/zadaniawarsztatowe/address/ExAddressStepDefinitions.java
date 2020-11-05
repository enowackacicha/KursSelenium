package zadaniawarsztatowe.address;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import zadaniawarsztatowe.LoginPageEx;

import java.util.concurrent.TimeUnit;

public class ExAddressStepDefinitions {

    ExAddressPage exAddressPage;
    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver.exe");

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        exAddressPage = new ExAddressPage(driver);
    }

    @Given("^User is logged in to CodersLab shop$")
    public void userIsLooggedInToCodersLabShop() {
        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=authentication");
        LoginPageEx loginPageEx = new LoginPageEx(driver);
        loginPageEx.loginAs("plaqjukqjwcqrfwayl@etochq.com", "123qwe");
    }

    @When("^User goes to UserAccount$")
    public void userGoesToUserInformationPage() {
        exAddressPage.viewAccount();
    }

    @And("^User goes to Address$")
    public void userGoesToAddressesPage() {
        exAddressPage.viewAddresses();
        exAddressPage.createNewAddressLnkSubmit();
    }

    @And("input {string} filled with {string}")
    public void enterValue(String fieldName, String value) {
        driver.findElement(By.name(fieldName)).sendKeys(value);
    }

    @And("next input {string} filled with {string}")
    public void enterNextValue(String fieldName, String value) {
        driver.findElement(By.name(fieldName)).sendKeys(value);
    }


    /*@And("input {string} filled with {string}")
    public void enterCityValue(String field, String city) {
//        driver.findElement(By.name(fieldName)).sendKeys(value);
        exAddressPage.cityInput.getCssValue(field);
        exAddressPage.setCityInput(city);
    }

    @And("User creates new adress {string}, {string}, {string}")
    public void userCreatesNewAddress(String address, String city, String postalCode) {
        exAddressPage.setAddress1(address);
        exAddressPage.setCityInput(city);
        exAddressPage.setPostalCodeInput(postalCode);
//        userInfoPage.setBirthdate(date);
    }*/

    @And("^User saves details$")
    public void userSavesDetails() {
        exAddressPage.saveBtn.submit();
    }

    @Then("User sees {string}")
    public void messageIsDiisplayed(String message) {
        Assert.assertEquals(message, exAddressPage.getSuccessInformation());
    }
//    @After
//    public void tearDown() {
//        driver.quit();
//    }

}
