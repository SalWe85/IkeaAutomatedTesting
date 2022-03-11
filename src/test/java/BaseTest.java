import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.openqa.selenium.WebDriver;

public class BaseTest {

    public static WebDriver driver;
    public static Logger log = LogManager.getLogger();

    @BeforeSuite
    public void setUp() {
        if (driver == null) {
            log.info("Test started!");
        }
    }

    @AfterSuite
    public void tearDown() {
        log.info("Test has finished!");
        if (driver != null) {
            driver.quit();
        }
    }

    public ChromeDriver openChromeDriver() {
        log.info("Opening Chrome Driver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments(new String[]{"--start-maximized"});
        options.addArguments(new String[]{"--ignore-certificate-errors"});
        options.addArguments(new String[]{"--disable-popup-blocking"});
        options.addArguments(new String[]{"--incognito"});
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        ChromeDriver driver = new ChromeDriver(options);
        driver.get(Strings.HOME_PAGE_URL);
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='onetrust-accept-btn-handler']")));
        driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//button[@id='onetrust-accept-btn-handler']")));
        return driver;
    }


    public static void waitByXpath (ChromeDriver driver, String xpath) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

}
