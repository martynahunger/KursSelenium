package pageobjectpattern.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderObject {

    private WebDriver driver;

    public HeaderObject(WebDriver driver) {
        this.driver = driver;
    }

    public String getLoggedUsername() {
        return driver.findElement(By.xpath("//*[@id=\"_desktop_user_info\"]//span")).getText();
    }

    public void clickLoggedUsername() {
        driver.findElement(By.xpath("//*[@id=\"_desktop_user_info\"]//span")).click();
    }
}
