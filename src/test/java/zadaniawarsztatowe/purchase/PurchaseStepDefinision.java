package zadaniawarsztatowe.purchase;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import zadaniawarsztatowe.LoginPageEx;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class PurchaseStepDefinision {
    PurchasePage purchasePage;
    WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver.exe");

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        purchasePage = new PurchasePage(driver);
    }

    @Given("^User is logged in to CodersLab shop$")
    public void userIsLooggedInToCodersLabShop() {
        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=authentication");
        LoginPageEx loginPageEx = new LoginPageEx(driver);
        loginPageEx.loginAs("plaqjukqjwcqrfwayl@etochq.com", "123qwe");
    }

    @When("^User selects Hummingbird printed sweater$")
    public void selectHummingbirdPrintedSweater() {
        purchasePage.clothesLnk.click();
        purchasePage.womenLnk.click();
        purchasePage.itemLnk.click();
    }

    @And("input {string} filled with {string}")
    public void enterValue
            (String fieldName, String value) {
        List<WebElement> elements = driver.findElements(By.name(fieldName));
        for (WebElement element : elements) {
            driver.findElement(By.name(fieldName));
            element.sendKeys(value);
            element.submit();
        }

    }

    @And("next input {string} filled with {string}")
    public void enterNextValue
            (String fieldName, String value) {
        driver.findElement(By.id(fieldName)).sendKeys(value);
        WebElement element = driver.findElement(By.id(fieldName));
//        driver = new FirefoxDriver();
//        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        element.clear();
        element.sendKeys(value);
        element.submit();
    }

    @And("^User adds items to cart$")
    public void addToCart() {
        driver.findElement(By.cssSelector("button.add-to-cart")).isEnabled();
        driver.findElement(By.cssSelector("button.add-to-cart")).click();
    }

    @And("^User confirms Proceed to checkout in 2 places$")
    public void confirmPurchase() {
        purchasePage.pupup.isDisplayed();
        //wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.btn-secondary")));
        //driver.findElement(By.cssSelector("button.btn-secondary")).click();
    }

}
