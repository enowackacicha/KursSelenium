package find;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.junit.*;

public class FormTest {

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
        driver.get("https://katalon-test.s3.amazonaws.com/demo-aut/dist/html/form.html");

    }

    @Test
    public void testFormFillIn() {
//        String[] names = {"first-name", "last-name"};
//        String[] values = {"Karol", "Kowalski"};
//        for (int i = 0; i < names.length; i++) {
//            WebElement field = driver.findElement(By.name(names[i]));
//            field.sendKeys(values[i]);
//        }
        // Znajdź firsNameTxt wprowadzania tekstu na podstawie jego nazwy
        WebElement firsNameTxt = driver.findElement(By.id("first-name"));
        // Wpisz informacje do wyszukania
        firsNameTxt.sendKeys("Karol");
        WebElement lastNameTxt = driver.findElement(By.id("last-name"));
        lastNameTxt.sendKeys("Kowalski");
        //WebElement radioGender = driver.findElement(By.xpath("//label[text()='Male']"));
        WebElement radioGender = driver.findElement(By.name("gender"));
        radioGender.click();
        WebElement dateOfBirth = driver.findElement(By.id("dob"));
        dateOfBirth.sendKeys("05/22/2010");
        WebElement adress = driver.findElement(By.id("address"));
        adress.sendKeys("Prosta 51");
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("karol.kowalski@mailinator.com");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Pass123");
        WebElement company = driver.findElement(By.id("company"));
        company.sendKeys("Coders Lab");
        WebElement comment = driver.findElement(By.id("comment"));
        comment.sendKeys("To jest mój pierwszy automat\n" +
                "testowy");
        WebElement submitBtn = driver.findElement(By.id("submit"));
        submitBtn.click();


        // Prześlij formularz
        // firsNameTxt.submit();
    }

    @After
    public void tearDown() throws Exception {
        // Zamknij przeglądarkę
//        driver.quit();
    }
}

