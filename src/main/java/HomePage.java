import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;



public class HomePage extends BasePage{


    @FindBy (xpath = "//a[@aria-labelledby='pub__shoppable-image-art,20430141']")
    WebElement dotFullspackad;

    @FindBy (xpath = "//a[@aria-labelledby='pub__shoppable-image-spr,69898415']")
    WebElement dotTarno;

    @FindBy (id = "pub__shoppable-image-spr,69898415")
    WebElement dotTooltipTarno;

    public HomePage(ChromeDriver driver) {super(driver);}


    public void clickOnPillowDot() {
        log.info("Scrolling to element.");
        Actions actions = new Actions(driver);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", dotFullspackad);
        log.info("Hovering over an element and clicking it.");
        actions.moveToElement(dotTarno).perform();
        sleep(2);
        dotTooltipTarno.click();
    }
}
