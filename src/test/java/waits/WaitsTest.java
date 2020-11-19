package waits;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjectpattern.pages.HeaderObject;
import pageobjectpattern.pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class WaitsTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://webdriveruniversity.com/Ajax-Loader/index.html");
    }

    @Test
    public void clickButtonNoWait() {
        driver.findElement(By.cssSelector("#button1 p")).click();
    }

    // nie stosowac! Chyba, ze nie ma innego wyjscia.
    @Test
    public void clickWithThreadSleep() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.cssSelector("#button1 p")).click();
    }

    // umieszczac gdzies na poczatku konfiguracji
    @Test
    public void clickWithImplicitlyWait() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("#button1 p")).click();
    }

    @Test
    public void clickWithExplicitWait() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#button1 p")));
        //driver.findElement(By.cssSelector("#button1 p")).click();
        element.click();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
