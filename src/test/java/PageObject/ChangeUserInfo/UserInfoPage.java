package PageObject.ChangeUserInfo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserInfoPage {
    private WebDriver driver;

    public UserInfoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class='account']")
    private WebElement userName;

    @FindBy(id="identity-link")
    private WebElement information;

    @FindBy(name = "birthday")
    private WebElement birthdayInput;

    @FindBy(name = "newsletter")
    private WebElement newsletterCheckbox;

    @FindBy(css = ".btn.btn-primary.form-control-submit")
    private WebElement submitButton;

    @FindBy(css = ".alert.alert-success")
    private WebElement successInformation;

    @FindBy(name = "password")
    private WebElement passwordInput;

    public void viewAccount() {
        userName.click();
    }

    public void viewInformation() {
        information.click();
    }

    public void signInForNewsletter() {
        if (!newsletterCheckbox.isSelected())
            newsletterCheckbox.click();
    }

    public void signOutFromNewsletter() {
        if (newsletterCheckbox.isSelected())
            newsletterCheckbox.click();
    }

    public void setBirthdate(String birthDate) {
        birthdayInput.click();
        birthdayInput.clear();
        birthdayInput.sendKeys(birthDate);
    }

    public void submitUserInfo() {
        passwordInput.sendKeys("CodersLab");
        submitButton.click();
    }

    public String getUpdateInformation() {
        return successInformation.getText();
    }

}

