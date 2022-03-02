import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ShoppingCartTest extends BaseTest{


    /**
     * Search for random product from a list of product names and add the most expensive one to the shopping cart
     * 1. Navigate to home page
     * 2. Enter random product name in header search field from a list of product names
     * 3. Navigate to new search result page
     * 4. Sort by prices, high to low
     * 5. Open most expensive one
     * 6. Navigate to product page
     * 7. Add product to shopping cart
     * 8. Navigate to shopping cart page
     *
     * Expected results:
     * 1. Verify that you are on shopping cart page.
     * 2. Verify that product is successfully added to shopping cart.
     */
    @Test
    public void addingMostExpensiveRandomProductToShoppingCart() {

        ChromeDriver driver = openChromeDriver();

        try {
            HomePage homePage = new HomePage(driver);

            //Search random product and sort it by highest price. Click on most expensive product and add it to shopping cart. Navigate to shopping cart.
            homePage.searchRandomProduct().sortProductsByHighestPrice().clickOnFirstProduct().addProductToShoppingCartIfAvailable();
            homePage.clickOnHeaderShoppingCartButton();

            //Verify that we are on shopping cart page.
            waitByXpath(driver, "//a[@data-tracking-label='ikea-logo']");
            assert driver.getCurrentUrl().contains(Strings.SHOPPING_CART_PAGE) : "Error, expected url: " + Strings.SHOPPING_CART_PAGE
                    + ", Actual url: " + driver.getCurrentUrl();
            print("Assert passed. Shopping cart page opened.");

            //Verify that product is added to shopping cart.
            ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
            String isRemoveButtonPresent = String.valueOf(shoppingCartPage.isRemoveButtonIsPresent());
            assert isRemoveButtonPresent.equals("true") : "Error, shopping cart is empty, no product remove button present.";
            print("Assert passed. Product is added to shopping cart.");


        } finally {
//            driver.quit();
        }

    }

}
