package cucumber.test.gloapps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GloApps {
    private static WebDriver driver;

    @Given("an open browser")
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @And("the browser with {string}")
    public void openBrowser(String url) {
        driver.get("https://" + url);
    }

    @When("input {string} filled with {string}")
    @And("next input {string} filled with {string}")
    public void enterValue(String fieldName, String value) {
        driver.findElement(By.name(fieldName)).sendKeys(value);
    }

    @And("button {string} clicked")
    @And("input {string} clicked")
    public void clickButton(String fieldId) {
        driver.findElement(By.id(fieldId)).click();
    }

    @And("next page {string} opened")
    @Then("page {string} opened")
    public void checkPage(String url) {
        new WebDriverWait(driver, 2).until(ExpectedConditions.urlContains(url));
        driver.getCurrentUrl().contains(url);
    }

    @And("close browser")
    public void tearDown() {
        driver.quit();
    }
}



