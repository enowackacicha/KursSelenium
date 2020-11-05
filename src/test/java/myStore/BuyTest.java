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

import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class BuyTest {

    private WebDriver driver;
    private WebDriverWait wait;
    private String[] products = {"mug", "notebook"};

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver.exe");
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 2);
        driver.get("https://prod-kurs.coderslab.pl");
    }

    @Test
    public void searchTest() {
        Random random = new Random();
        int randomInteger = random.nextInt(50);
        WebElement element = driver.findElement(By.name("s"));
        element.sendKeys(products[randomInteger%products.length]);
        element.submit();

        wait.until(ExpectedConditions.urlContains("search"));

        String searchedUrl = driver.getCurrentUrl();

        Set<String> names = new TreeSet<String>();
        List<WebElement> articles = driver.findElements(By.tagName("article"));
        for (int i=0; i<articles.size(); i++) {
            articles.get(i).findElement(By.className("product-thumbnail")).click();
            wait.until(ExpectedConditions.urlContains("id_product"));
            if (driver.findElement(By.cssSelector("button.add-to-cart")).isEnabled()) {
                driver.findElement(By.cssSelector("button.add-to-cart")).click();
                wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.btn-secondary")));
                driver.findElement(By.cssSelector("button.btn-secondary")).click();
                driver.navigate().to(searchedUrl);
                wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("article")));
                articles = driver.findElements(By.tagName("article"));
            } else {
                driver.navigate().to(searchedUrl);
                wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("article")));
                articles = driver.findElements(By.tagName("article"));
                continue;
            }
        }
        driver.findElement(By.xpath("/html/body/main/header/nav/div/div/div[1]/div[2]/div[3]/div/div/a")).click();
        wait.until(ExpectedConditions.urlContains("cart"));
        double sum = 0;
        List<WebElement> prices = driver.findElements(By.cssSelector("span.product-price"));
        for (WebElement price : prices) {
            sum+=Double.parseDouble(price.getText().substring(1));
        }
        Assert.assertEquals(sum, Double.parseDouble(driver.findElement(By.className("cart-total")).findElement(By.className("value")).getText().substring(1)), 0);
    }

    @After
    public void tearDown() {

//        driver.quit();
    }
}
