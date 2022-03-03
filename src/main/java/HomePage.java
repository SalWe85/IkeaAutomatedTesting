import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;



public class HomePage extends BasePage{


    @FindBy (xpath = "//*[@id=\"4f9f54f0-671c-11ec-bcb3-23d8b820c4cd\"]/div/div/div/div[2]/div/div/div[1]/div/div/div/span/div[1]/a")
    WebElement dotSofaKlippan;

    @FindBy (xpath = "//*[@id=\"4f9f54f0-671c-11ec-bcb3-23d8b820c4cd\"]/div/div/div/div[2]/div/div/div[1]/div/div/div/span/div[3]/a")
    WebElement dotLampMojna;

    @FindBy (xpath = "//*[@id=\"4f9f54f0-671c-11ec-bcb3-23d8b820c4cd\"]/div/div/div/div[2]/div/div/div[1]/div/div/div/span/div[6]/a")
    WebElement dotPillowHildamaria;

    public HomePage(ChromeDriver driver) {super(driver);}


    public void clickOnPillowDot() {
        print("HomePage: Scrolling to element.");
        Actions actions = new Actions(driver);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", dotLampMojna);
        print("HomePage: Hovering over an element and clicking it.");
        actions.moveToElement(dotPillowHildamaria).perform();
        sleep(2);
        dotPillowHildamaria.click();
    }
}
