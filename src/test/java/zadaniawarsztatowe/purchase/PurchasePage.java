package zadaniawarsztatowe.purchase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PurchasePage {
    private WebDriver driver;

    public PurchasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#category-3 > a")
    WebElement clothesLnk;


    @FindBy(xpath = "//ul[@class='category-sub-menu']/li[2]")
    WebElement womenLnk;

    @FindBy(css = "#js-product-list > div.products.row > article > div > a")
    WebElement itemLnk;

//    @FindBy(className = "btn btn-primary add-to-cart")
    @FindBy(css = "button[class='btn btn-primary add-to-cart']")
    WebElement addToCartBtn;

@FindBy(css = "#blockcart-modal .modal-content")
    WebElement pupup;
}
