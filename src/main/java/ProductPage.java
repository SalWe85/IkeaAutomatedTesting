import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage{

    @FindBy (xpath = "//button[@data-test-target='add-to-cart-button']")
    WebElement buttonAddToCart;

    @FindBy (xpath = "//button[contains(@class, 'range-revamp-btn')]/span/span")
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
            print("ProductPage: Product is available, adding to cart.");
            buttonAddToCart.click();
        } else {
            print("ProductPage: Product is not available, searching for different product");
            BasePage basePage = new BasePage(driver);
            basePage.searchRandomProduct().sortProductsByHighestPrice().clickOnFirstProduct().addProductToShoppingCartIfAvailable();
        }
    }
}
