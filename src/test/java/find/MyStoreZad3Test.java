package przyklad1;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.junit.*;

import java.util.Random;

public class MyStoreZad3Test {

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
    public void testPrestaShopSearch() {
        String[] products = {"mug", "t-shirt", "frame", "picture"};
        Random random = new Random();
        int randomInteger = random.nextInt(products.length);
        // Znajdź element wprowadzania tekstu na podstawie jego nazwy
        WebElement element = driver.findElement(By.name("s"));
        // Wyczyść tekst zapisany w elemencie
        element.clear();
        // Wpisz informacje do wyszukania
        element.sendKeys(products[randomInteger]);
        // Prześlij formularz
        element.submit();
    }

    @After
    public void tearDown() throws Exception {
        // Zamknij przeglądarkę
//        driver.quit();
    }
}

/*Rozwiązanie z %
* element.sendKeys(products[randomInteger % products.length]);
randomInteger to losowa liczba z tych 50
która generuje sobie wcześniej
Random random = new Random();
    int randomInteger = random.nextInt(50);
to do tego generowania
i po tym randomInteger ma losowa liczbe z tego zakresu*/


