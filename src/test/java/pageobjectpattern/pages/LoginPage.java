package pageobjectpattern.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

class PageBase {

    protected WebDriver driver;

    public PageBase(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}

public class LoginPage extends PageBase {

    //private WebDriver driver;

    @FindBy(name = "email")
    private WebElement loginInput;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(id = "submit-login")
    private WebElement signInButton;

    public LoginPage(WebDriver driver) {
        super(driver);
        //this.driver = driver;
        //PageFactory.initElements(driver, this);
    }

    public void loginAs(String email, String password) {
        loginInput.clear();
        loginInput.sendKeys(email);
        passwordInput.clear();
        passwordInput.sendKeys(password);
        signInButton.click();
    }
}
