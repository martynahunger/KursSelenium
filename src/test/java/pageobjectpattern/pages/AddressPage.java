package pageobjectpattern.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressPage {

    private WebDriver driver;

    @FindBy(name = "address1")
    private WebElement addressInput;

    @FindBy(name = "city")
    private WebElement cityInput;

    @FindBy(name = "postcode")
    private WebElement zipCodeInput;

    @FindBy(css = "#content button")
    private WebElement saveButton;

    public AddressPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addNewAddress(String street, String city, String postcode) {
        addressInput.sendKeys(street);
        cityInput.sendKeys(city);
        zipCodeInput.sendKeys(postcode);
        saveButton.click();
    }
}
