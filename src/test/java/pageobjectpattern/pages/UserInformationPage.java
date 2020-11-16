package pageobjectpattern.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserInformationPage {

    private WebDriver driver;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(name = "birthday")
    private WebElement birthdayInput;

    @FindBy(name = "newsletter")
    private WebElement newsletterCheckbox;

    @FindBy(css = "#customer-form footer button")
    private WebElement submitButton;

    @FindBy(css = "#notifications li")
    private WebElement successInformation;

    public UserInformationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void signInForNewsletter() {
        if (!newsletterCheckbox.isSelected())
            newsletterCheckbox.click();
    }

    public void signOutFromNewsletter() {
        if (newsletterCheckbox.isSelected())
            newsletterCheckbox.click();
    }

    public void setBirthdate(String birthDate) {
        birthdayInput.click();
        birthdayInput.clear();
        birthdayInput.sendKeys(birthDate);
    }

    public void submitUserInfo(String password) {
        passwordInput.sendKeys(password);
        submitButton.click();
    }

    public String getUpdateInformation() {
        return successInformation.getText();
    }
}
