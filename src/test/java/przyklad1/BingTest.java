package przyklad1;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.junit.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BingTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        // Uruchom nowy egzemplarz przeglądarki Chrome
        System.setProperty("webdriver.gecko.driver",
//                "src/main/resources/drivers/chromedriver.exe");
                "src/main/resources/drivers/geckodriver.exe");
//        driver = new ChromeDriver();
        driver = new FirefoxDriver();

        // Zmaksymalizuj okno przeglądarki
        driver.manage().window().maximize();
        // Przejdź do Google
//        driver.get("http://www.google.com");
        driver.get("http://www.bing.com");
    }

    @Test
    public void testGoogleSearch() {
        // Znajdź element wprowadzania tekstu na podstawie jego nazwy
        WebElement element = driver.findElement(By.name("q"));
        // Wyczyść teskst zapisany w elemencie
        element.clear();

        // Wpisz informacje do wyszukania
//        element.sendKeys("Testowanie Selenium WebDriver");
        element.sendKeys("Mistrzostwa Świata w piłce nożnej 2018");


        // Prześlij formularz
        element.submit();
    }

    @After
    public void tearDown() throws Exception {
        // Zamknij przeglądarkę
//        driver.quit();
    }
}

