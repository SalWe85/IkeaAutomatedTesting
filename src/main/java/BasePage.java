import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    ChromeDriver driver = null;

    @FindBy (xpath = "//a[@data-tracking-label='profile']")
    WebElement loginHeaderButton;

    @FindBy (xpath = "//span[.='Prijavi se']")
    WebElement loginModalButton;

    @FindBy (xpath = "//span[.='Odjavi se']")
    WebElement signOutModalButton;

    public BasePage(ChromeDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void clickHeaderLoginButton () {
        print("BasePage: Clicking on header log in button.");
        waitByXpath(driver, "//a[@data-tracking-label='profile']");
        loginHeaderButton.click();
    }

    public LoginPage clickModalLoginButton () {
        print("BasePage: Clicking on modal log in button.");
        waitByXpath(driver, "//span[.='Prijavi se']" );
        loginModalButton.click();
        return new LoginPage(driver);
    }

    //Metoda za sve wait-ove
    public static void waitByXpath (ChromeDriver driver, String xpath) {
    WebDriverWait wait = new WebDriverWait(driver, 5);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    public static void sleep(int seconds){
        try{
            Thread.sleep(seconds*1000);
        } catch (Exception e) {}
    }

    public static void print (String x) {
        System.out.println(x);
    }
}

