package cucumber.test.google;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleSearch {
//    public String keyword;
    private WebDriver driver;

    //definicje metod
    @Given("an open browser with google.com")//zamiast google.com {string}
    public void openGoogleSearch() {
// Skonfiguruj sterownik przeglądarki
//        System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver.exe");

        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
// Uruchom nowy egzemplarz przeglądarki Chrome
        driver = new ChromeDriver();
//        driver = new FirefoxDriver();
// Zmaksymalizuj okno przeglądarki
        driver.manage().window().maximize();
// Przejdź do Google
        driver.get("http://www.google.com");
    }

    @When("a keyword {string} is entered in input field")//zamiast (.*) trzeba wstawić {string}
    public void enterKeyword(String keyword) {
// Znajdź element wprowadzania tekstu na podstawie jego nazwy
        WebElement element = driver.findElement(By.name("q"));
// Wyczyść tekst zapisany w elemencie
        element.clear();
// Wpisz informacje do wyszukania
        element.sendKeys(keyword);
// Prześlij formularz
        element.submit();
    }

    @Then("the first one should contain {string}")
    public void theFirstOneShouldContainKeyword(String expectedText) {
        WebElement line = driver.findElement(By.xpath("//span[contains(text(),'Selenium')]"));
        line.getText().toLowerCase().contains(expectedText.toLowerCase());
        new WebDriverWait(driver, 2)
                .until(ExpectedConditions.presenceOfElementLocated(By.id("search")));

//        WebElement element = driver.findElement(By.xpath("//span[contains(text(),'Selenium')]"));
//       if (element.getText().contains(expectedText))
//        if (expectedText.contains(keyword))
//        {System.out.println(expectedText);}
        System.out.println(expectedText);
    }

    @And("close browser")
    public void closeBrowser() {
       driver.quit();
    }

    
}
