import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage{

    @FindBy (xpath = "//div[@class='productControls_remove__2hC2w']")
    WebElement removeButton;

    public ShoppingCartPage(ChromeDriver driver){super(driver);}

    boolean isRemoveButtonIsPresent (){
        print("ShopingCartPage: Checking if remove button is present.");
        if (removeButton.isDisplayed()) {
            return true;
        } else {
            print("ShopingCartPage: remove button is not present");
            return false;
        }
    }
}
