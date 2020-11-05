package myStore;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;

public class FilterTest {

    private WebDriver driver;
    private WebDriverWait wait;
    private String[] products = {"mug", "t-shirt", "notebook"};
    private String[] filters = {"Name, A to Z", "Name, Z to A", "Price, low to high", "Price, high to low"};

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

        wait.until(ExpectedConditions.elementToBeClickable(By.className("select-title")));

        WebElement filter = driver.findElement(By.className("select-title"));
        filter.click();
        driver.findElement(By.linkText(filters[0])).click();
        Set<String> names = new TreeSet<String>();
        List<WebElement> articles = driver.findElements(By.tagName("article"));
        for (WebElement article : articles) {
            String name = article.findElement(By.xpath("//div/div/h2/a")).getText();
            names.add(name);
        }
        int i=0;
        for (String name : names)
            Assert.assertEquals(name, articles.get(i++).findElement(By.xpath("div/div/h2/a")).getText());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
