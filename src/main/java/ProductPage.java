import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductPage extends BasePage{

    @FindBy (xpath = "//button[@data-test-target='add-to-cart-button']")
    WebElement buttonAddToCart;

    @FindBy (xpath = "//div[@class='pip-buy-module__buttons--left']/button/span/span")
    WebElement getButtonAddToCartText;

    public ProductPage(ChromeDriver driver){super(driver);}

    boolean isProductAvailable() {
        if (getButtonAddToCartText.getText().equals("Dodaj u korpu")) {
            return true;
        } else {
            return false;
        }
    }

    public void addProductToShoppingCartIfAvailable() {
        if (isProductAvailable()==true){
            log.info("Product is available, adding to cart.");
            buttonAddToCart.click();
        } else {
            log.info(" Product is not available, searching for different product");
            BasePage basePage = new BasePage(driver);
            basePage.searchRandomProduct().sortProductsByHighestPrice().clickOnFirstProduct().addProductToShoppingCartIfAvailable();
        }
    }



}
