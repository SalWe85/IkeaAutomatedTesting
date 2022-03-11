import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage{

    @FindBy (xpath = "//div[@class='productControls_remove__2hC2w']")
    WebElement removeButton;

    public ShoppingCartPage(ChromeDriver driver){super(driver);}

    boolean isRemoveButtonIsPresent (){
        log.info("Checking if remove button is present.");
        if (removeButton.isDisplayed()) {
            return true;
        } else {
           log.error("Remove button is not present");
            return false;
        }
    }
}
