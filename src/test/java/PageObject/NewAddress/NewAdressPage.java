package PageObject.NewAddress;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewAdressPage {
    private WebDriver driver;

    public NewAdressPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//span[text()=\"Automated Tester\"]")
    private WebElement userName;

    @FindBy(xpath = "//*[@id=\"addresses-link\"]/span")
    private WebElement addressesIcon;

    @FindBy(xpath = "//span[text()= 'Create new address']")
    private WebElement createNewAddressLnk;

    @FindBy(name = "address1")
    WebElement addressInput;

    @FindBy(name = "city")
    WebElement cityInput;

    @FindBy(name = "postcode")
    WebElement postcodeInput;

    @FindBy(xpath = "//button[contains(text(),'Save')]")
    WebElement saveBtn;

    @FindBy(xpath = "//li[contains(text(),'Address successfully added!')]")
    WebElement successInformation;

    public void viewAccount() {
        userName.click();
    }

    public void viewAddresses() {
        addressesIcon.click();
    }

    public void createNewAddressLnkSubmit() {
        createNewAddressLnk.click();
    }

    public void setAddress1(String address1) {
        addressInput.click();
        addressInput.clear();
        addressInput.sendKeys(address1);
    }

    public void setCityInput(String city) {
        cityInput.click();
        cityInput.clear();
        cityInput.sendKeys(city);
    }

    public void setPostalCodeInput(String postalCode) {
        postcodeInput.click();
        postcodeInput.clear();
        postcodeInput.sendKeys(postalCode);
    }

    public String getSuccessInformation() {
        return successInformation.getText();
    }
}
