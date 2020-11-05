package PageObject.LoginPage;
import PageObject.LoginPage.LoginPage2;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;
public class LoginTest {
    private static WebDriver driver;
    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver",
//                "src/main/resources/drivers/chromedriver.exe");
                "src/main/resources/drivers/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=authentication");
    }
    @Test
    public void testLoginWithProperCredentials() {
        LoginPage2 loginPage = new LoginPage2(driver);
        loginPage.loginAs("michal.dobrzycki@coderslab.pl", "CodersLab");
        Assert.assertEquals("Automated Tester", loginPage.getLoggedUsername());
    }
    @After
    public void tearDown() {
//        driver.quit();
    }
}