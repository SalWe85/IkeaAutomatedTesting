import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class SearchResultsPage extends BasePage{

    public SearchResultsPage(ChromeDriver driver) {super(driver);}

    @FindBy (xpath = "//span[@class = 'range-revamp-header-section__title--small notranslate']")
    WebElement searchResultProductNames;

    public void openFirstSearchedProduct () {
        print("SearchResultsPage: Opening first searched product.");
    }

}
