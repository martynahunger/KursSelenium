package pageobjectpattern.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourAddressesPage {

    private WebDriver driver;

    @FindBy(css = "#notifications li")
    private WebElement successAlert;

    public YourAddressesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getAlertMessage() {
        if (!successAlert.isDisplayed()) {
            throw new NoSuchElementException("Element nie jest wyświetlony! Uzywac bezposrednio po dodaniu adresu");
        }
        return successAlert.getText();
    }
}
