import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ProductSortingTest extends BaseTest{


    /**
     * Search for random product from a list of product names and sort it by highest value.
     * 1. Navigate to home page
     * 2. Enter in search field random product name from a list of product names
     * 3. On search result page, sort products by highest price
     *
     * Expected results:
     * 5. Verify that product list is sorted by highest price
     */
    @Test
    public void sortRandomProductsByHighestPrice(){
        ChromeDriver driver = openChromeDriver();

        try {
       //Search random product and sort it by highest price
        BasePage basePage = new BasePage(driver);
        basePage.searchRandomProduct().sortProductsByHighestPrice();

        //Verify that products are sorted by highest price.
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        String isFirstProductMostExpensive = String.valueOf(searchResultsPage.areProductsSortedByHighestPrice());
        assert isFirstProductMostExpensive.equals("true") : "Error, sorting by highest price failed";
        log.info("Assert successful. Products are sorted by highest price.");

        } finally {
            driver.quit();
        }

    }

}
