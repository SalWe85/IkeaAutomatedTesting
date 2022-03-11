import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultsPage extends BasePage{

    public SearchResultsPage(ChromeDriver driver) {super(driver);}

    @FindBy (xpath = "//span[@class = 'range-revamp-header-section__title--small notranslate']")
    WebElement searchResultProductNames;

    @FindBy (id = "SORT")
    WebElement sortMainButton;

    @FindBy (xpath = "//input[@value='sort_by_price_high']")
    WebElement sortOptionByPriceHigh;



    public SearchResultsPage sortProductsByHighestPrice () {
        log.info("Sorting products by highest price.");
        waitByXpath(driver, "//button[@id='SORT']");
        sortMainButton.click();
        sortOptionByPriceHigh.click();
        sortMainButton.click();
        return new SearchResultsPage(driver);
    }

    boolean areProductsSortedByHighestPrice () {
        waitByXpath(driver, "//span[@class = 'pip-price__integer']");
        List<WebElement> productPrices = driver.findElements(By.className("pip-price__integer"));
        double firstProductPrice = Double.parseDouble(productPrices.get(0).getText());
        double secondProductPrice = Double.parseDouble(productPrices.get(1).getText());
        if (firstProductPrice >= secondProductPrice) {
            return true;
        } else {
            return false;
        }
    }

    public ProductPage clickOnFirstProduct() {
        log.info("Clicking on first product.");
        waitByXpath(driver,"//span[@class = 'pip-price__integer']");
        List<WebElement> products = driver.findElements(By.className("pip-price__integer"));
        products.get(0).click();
        return new ProductPage(driver);
    }

    public String getNameOfFirstItemFromSearchPage() {
        waitByXpath(driver, "//span[@class = 'pip-header-section__title--small notranslate']");
        List<WebElement> searchedProductsList = driver.findElements(By.xpath("//span[@class = 'pip-header-section__title--small notranslate']"));
        return searchedProductsList.get(0).getText();
    }

    public String getSearchedWordFromTitle() {
        return driver.findElement(By.xpath("//b[@class = 'notranslate']")).getText();
    }
}
