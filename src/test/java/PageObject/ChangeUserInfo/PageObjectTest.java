package PageObject.ChangeUserInfo;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/Cucumber/Features/POP", plugin = {"pretty", "html:out.html"})
public class PageObjectTest {
}
