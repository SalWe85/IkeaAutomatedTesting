import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import java.util.List;


public class ProductSearchTest extends BaseTest{



    /**
     * Search random product and check if search result is correct
     * 1. Navigate to home page
     * 2. Enter random product name in header search field
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
            print("Assert passed. Search result page opened.");

            //Collect product names listed in search result page and verify that first product corresponds to searched keyword.
            waitByXpath(driver, "//span[@class = 'range-revamp-header-section__title--small notranslate']");
            List<WebElement> searchedProductsList = driver.findElements(By.xpath("//span[@class = 'range-revamp-header-section__title--small notranslate']"));
            String test = searchedProductsList.get(0).getText();
            String searchedWord = driver.findElement(By.xpath("//b[@class = 'notranslate']")).getText();
            assert searchedWord.equals(test) : "Error. Expected: " + searchedWord + ". Actual: " + test;
            print("Assert passed. Searched keyword: " + test + ", is same as first product listed in search results.");


        } finally {
           driver.quit();
        }
    }



}
