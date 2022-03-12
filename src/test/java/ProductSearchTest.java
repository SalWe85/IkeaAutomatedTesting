import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;



public class ProductSearchTest extends BaseTest{



    /**
     * Search for random product from a list of product names and check if search result is correct
     * 1. Navigate to home page
     * 2. Enter random product name in header search field from a list of product names
     * 3. Navigate to new search result page
     * 4. Collect all listed products
     *
     * Expected results:
     * 1. Verify that you are on search result page
     * 2. Verify that entered search keyword corresponds to first product listed in search results.
     */
    @Test
    public void searchForRandomPredefinedProduct() {

        ChromeDriver driver = openChromeDriver();

        try {
            BasePage basePage = new BasePage(driver);

            //Search for random predefined product and navigate to search result page.
            basePage.searchRandomProduct();

            //Verify that we opened search result page
            assert driver.getCurrentUrl().contains(Strings.SEARCH_RESULT_PAGE) : "Error. Expected: " + Strings.SEARCH_RESULT_PAGE
                    + ". Actual: " + driver.getCurrentUrl();

            // Log4j
            log.info("Assert passed. Search result page opened.");

            //Testng
            //Reporter.log("Assert passed. Search result page opened.<br>");

            //Collect product names listed in search result page and verify that first product corresponds to searched keyword.
            SearchResultsPage searchResultsPage = new SearchResultsPage(driver);

            assert searchResultsPage.getNameOfFirstItemFromSearchPage().equals(searchResultsPage.getSearchedWordFromTitle()) : "Error. Expected: " + searchResultsPage.getSearchedWordFromTitle()
                    + ". Actual: " + searchResultsPage.getNameOfFirstItemFromSearchPage();

            // Log4j
            log.info("Assert passed. Searched keyword: " + searchResultsPage.getSearchedWordFromTitle() + ", is same as first product listed in search results.");

            //Testng
            //Reporter.log("Assert passed. Searched keyword: " + searchResultsPage.getSearchedWordFromTitle() + ", is same as first product listed in search results.");

        } finally {
          driver.quit();
        }
    }



}
