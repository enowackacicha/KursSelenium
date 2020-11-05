package myStore;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Instant;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class FindTest {

    private WebDriver driver;
    private String[] products = {"mug", "t-shirt", "notebook"};
    private WebDriverWait wait;


    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("https://prod-kurs.coderslab.pl");
        wait = new WebDriverWait(driver, 2);
    }


    @Test
    public void searchTest() {
        Random random = new Random();
        int randomInteger = random.nextInt(50);
        WebElement element = driver.findElement(By.name("s"));
        element.sendKeys(products[randomInteger % products.length]);
        element.submit();

        List<WebElement> articles = driver.findElements(By.tagName("article"));
        for (WebElement article:articles) {
            wait.until(ExpectedConditions.elementToBeClickable(By.className("select-title")));
            String name = article.findElement(By.xpath("div/div/h2/a")).getText();
            Assert.assertTrue(name.toLowerCase().contains(products[randomInteger%products.length]));

        }
    }

    @After
    public void tearDown() {

//        driver.quit();
    }
}
