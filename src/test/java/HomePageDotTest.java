import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HomePageDotTest extends BaseTest{


    /**
     * On Home page scroll to 'dot' buttons, hover over one and click it
     * 1. Navigate to home page and accept cookies
     * 2. Scroll to first 'dot' button
     * 3. Hover over one of the buttons for 2 sec
     * 4. Click on it
     *
     * Expected result
     * 1. Verify that correct product page is opened.
     */
    @Test
    public void scrollToAndHoverAndClickOnDot () {

        ChromeDriver driver = openChromeDriver();

        try {
            HomePage homePage = new HomePage(driver);
            homePage.clickOnPillowDot();

            assert driver.getCurrentUrl().contains(Strings.TARNO_PRODUCT_PAGE) : "Error, expected: " + Strings.TARNO_PRODUCT_PAGE
                    + ", Actual: " + driver.getCurrentUrl();
            log.info("Assert passed. Correct product selected.");
        }finally {
            driver.quit();
        }

    }

}
