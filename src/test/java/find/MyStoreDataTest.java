package find;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Random;

public class MyStoreDataTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        // Uruchom nowy egzemplarz przeglądarki Chrome
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();

        // Zmaksymalizuj okno przeglądarki
        driver.manage().window().maximize();
        // Przejdź do Google
        driver.get("https://prod-kurs.coderslab.pl/");

    }

    @Test
    public void testPrestaShopCreateAccount() {
        WebElement sigInElement = driver.findElement(By.xpath("//span[text()='Sign in']"));
        sigInElement.click();
        WebElement createElement = driver.findElement(By.xpath("//a[contains(text(),'Create one here')]"));
        createElement.click();
        int userLimit=3;
        String[] names = {"id_gender", "firstname", "lastname", };
        String[] valuesNames={"1","Karol", "Kowalski","buuu@gmail.com"};
        //String[] names = {"first-name", "last-name"};
//        String[] values = {"Karol", "Kowalski"};
//        for (int i = 0; i < names.length; i++) {
//            WebElement field = driver.findElement(By.name(names[i]));
//            field.sendKeys(values[i]);

    }
    @After
    public void tearDown() throws Exception {
        // Zamknij przeglądarkę
//        driver.quit();
    }
}
