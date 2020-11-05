package zadaniawarsztatowe.address;

import PageObject.LoginPage.LoginPage2;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/Cucumber/Features/ZadanieWarsztatowe1", plugin = {"pretty", "html:out.html"})

public class ExAddressTest {
    private static WebDriver driver;
    @Test public void testAddressData() {
        //nie wiem gdzie i jak dopisać assercje zrobiłam to tutaj oraz w klasie ExAddressPage
//        LoginPage2 loginPage = new LoginPage2(driver);
//        loginPage.loginAs("michal.dobrzycki@coderslab.pl", "CodersLab");
//        Assert.assertEquals("Automated Tester", loginPage.getLoggedUsername());
        ExAddressPage exAddressPage = new ExAddressPage(driver);
        exAddressPage.aliasIsCorrect();

    }
}
