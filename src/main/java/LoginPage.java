import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy (id = "username")
    WebElement usernameInputField;

    @FindBy (id = "password")
    WebElement passwordInputField;

    @FindBy (xpath = "//button/span/span[.='Nastavi']")
    WebElement loginButton;

    @FindBy (xpath = "//*[@id=\"root\"]/div/div[3]/div[1]/div/div/p")
    WebElement messageFailedLogin;


    public LoginPage(ChromeDriver driver) {
        super(driver);
        waitByXpath(driver, "//button/span/span[.='Nastavi']");
    }

    //Method for entering valid credentials
    public void enterValidCredentialsAndLogIn (){
        print("LoginPage: Entering valid credentials and logging in.");
        usernameInputField.sendKeys(Strings.USERNAME_VALID);
        passwordInputField.sendKeys(Strings.PASSWORD_VALID);
        loginButton.click();
    }

    //Method for entering fake log in credentials using faker
    public void enterInvalidCredentials () {
        print("LoginPage: Entering invalid credentials.");
        Faker faker = new Faker();
        usernameInputField.sendKeys(faker.internet().emailAddress());
        passwordInputField.sendKeys(faker.number().digits(10));
        loginButton.click();
    }

}
