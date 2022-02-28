import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{


    /**
     * Log in with valid credentials
     * 1. Navigate to home page
     * 2. Click on header log in button, to open modal
     * 3. Click on log in button inside a modal
     * 4. Enter valid credentials
     * 5. Click on log in button
     *
     * Expected results:
     * 1. Verify that you are on log in page
     * 2. Verify that you are on loyalty-hub page
     */
    @Test
    public void loginToSiteWithValidCredentials() {
        ChromeDriver driver = openChromeDriver();

        try{
       //Open in ikea website, clicking on header log in button to open a modal.
        BasePage basePage = new BasePage(driver);
        basePage.clickHeaderLoginButton();

        //Click log in button on modal, navigate to log in page.
        basePage.clickModalLoginButton();
        assert driver.getCurrentUrl().contains(Strings.LOGIN_PAGE) : "Error. Expected: " + Strings.LOGIN_PAGE
                    + ". Actual: " + driver.getCurrentUrl();
        print("Assert passed. Log in page opened.");

        //Log in with valid credentials
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterValidCredentialsAndLogIn();

        //Waiting for new page to load
        BasePage.sleep(5);

        assert driver.getCurrentUrl().contains(Strings.LOYALTY_HUB_PAGE) : "Error. Expected: " + Strings.LOYALTY_HUB_PAGE
                + ". Actual: " + driver.getCurrentUrl();
        print("Assert passed. Successfully logged in.");

    } finally {
           driver.quit();
        }
    }


    /**
     * Log in with invalid credentials
     * 1. Navigate to home page
     * 2. Click on header log in button, to open modal
     * 3. Click on log in button inside modal
     * 4. Enter invalid random generated credentials
     * 5. Click on log in button
     *
     * Expected results:
     * 1. Verify that you are on log in page
     * 2. Verify that you are still on log in page after failed log in attempt
     */
    @Test
    public void loginToSiteWithInvalidCredentials() {
        ChromeDriver driver = openChromeDriver();

        try {
            //Open in ikea website, clicking on header log in button to open a modal.
            BasePage basePage = new BasePage(driver);
            basePage.clickHeaderLoginButton();

            //Click log in button on modal, navigate to log in page.
            basePage.clickModalLoginButton();
            assert driver.getCurrentUrl().contains(Strings.LOGIN_PAGE) : "Error. Expected: " + Strings.LOGIN_PAGE
                    + ". Actual: " + driver.getCurrentUrl();
            print("Assert passed. Log in page opened.");

            //Enter random credentials.
            LoginPage loginPage = new LoginPage(driver);
            loginPage.enterInvalidCredentials();

            //Wait for page to process data
            BasePage.sleep(2);

            assert driver.getCurrentUrl().contains(Strings.LOGIN_PAGE) : "Error. Expected: " + Strings.LOGIN_PAGE
                    + ". Actual: " + driver.getCurrentUrl();
            print("Assert passed. Log in failed.");

        }finally {
            driver.quit();
        }

    }

}
