package find;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FunkcjeTest {

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
        driver.get("https://pl.wikipedia.org/");

    }

    @Test
    public void testWikiSearch() {

      /*  WebElement element = driver.findElement(By.id("main-page-column1"));
        System.out.println(element.getText());*/

//        driver.get("https://pl.wikipedia.org/");
        String atrybut = driver.findElement(By.id("main-page-content")).getAttribute("class");
        System.out.println(atrybut);

        driver.get("https://pl.wikipedia.org/");
        String tag = driver.findElement(By.id("main-page-content")).getTagName();
        System.out.println(tag);

        /*WebElement search = driver.findElement(By.id("searchInput"));
        if (search.isEnabled()) {
            search.sendKeys("Selenium");
            search.submit();
        } else {
            Assert.fail();
        }*/

        WebElement search = driver.findElement(By.id("searchInput"));
        if(search.isDisplayed()) {
            search.sendKeys("Selenium");
            search.submit();
        }else {
            Assert.fail();
        }

        // Znajdź element wprowadzania tekstu na podstawie jego nazwy
        /*WebElement element = driver.findElement(By.name("_username"));
        WebElement passwordelement = driver.findElement(By.name("_username"));
        WebElement loginbtn = driver.findElement(By.cssSelector("button[class='btn btn-info block full-width m-b']"));*/
//        WebElement userName = driver.findElement(By.xpath("/html/body/div/div/div/form/div/input"));
//        WebElement password = driver.findElement(By.xpath("//input[@name='_password']"));
//        WebElement userName1 = driver.findElement(By.cssSelector("input.form-control"));
//        List<WebElement> controls = driver.findElements(By.className("form-control"));
//        System.out.println(controls.size());
//        Assert.assertEquals(2, controls.size());
        //input[@name='password']
            /*/html/body/div/div/div/form/div/input
Assert.assertEquals("Should be _username", "_username", username.getAttribute("name"));
System.out.println(password.getAttribute("name"));
*/
        /*/html/body/div/div/div/form/div/input
Assert.assertEquals("Should be _username", "_username", username.getAttribute("name"));
System.out.println(password.getAttribute("name"));
//input
//input[@name='_password']
*/


        // Wyczyść teskst zapisany w elemencie
        //element.clear();

        // Wpisz informacje do wyszukania
//            element.sendKeys("Testowanie Selenium WebDriver");


        // Prześlij formularz
        //element.submit();
    }

    @After
    public void tearDown() throws Exception {
        // Zamknij przeglądarkę
        driver.quit();
    }
}



