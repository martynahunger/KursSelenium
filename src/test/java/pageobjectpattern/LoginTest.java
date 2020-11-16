package pageobjectpattern;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjectpattern.pages.HeaderObject;
import pageobjectpattern.pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        // Uruchom nowy egzemplarz przeglądarki Chrome
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();

        // Zmaksymalizuj okno przeglądarki
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=authentication");
    }

    @Test
    public void loginNoPageObject() {
        WebElement loginInput = driver.findElement(By.name("email"));
        loginInput.clear();
        loginInput.sendKeys("johnd@mail.com");

        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.clear();
        passwordInput.sendKeys("qwerty");

        WebElement signInButton = driver.findElement(By.id("submit-login"));
        signInButton.click();

        String userName = driver.findElement(By.xpath("//*[@id=\"_desktop_user_info\"]//span")).getText();
        Assert.assertEquals("John Doe", userName);
    }

    @Test
    public void loginWithPageObject() {
        // AAA - tego sie nie pisze w testach
        // arrange
        String email = "johnd@mail.com";
        String password = "qwerty";
        String expectedUsername = "John Doe";
        LoginPage loginPage = new LoginPage(driver);
        HeaderObject headerObject = new HeaderObject(driver);

        // act
        loginPage.loginAs(email, password);

        // assert
        Assert.assertEquals(expectedUsername, headerObject.getLoggedUsername());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
