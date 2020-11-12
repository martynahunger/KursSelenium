package zadanie2;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class KatalonTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        // Uruchom nowy egzemplarz przeglądarki Chrome
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();

        // Zmaksymalizuj okno przeglądarki
        driver.manage().window().maximize();
        // Przejdź do Katalon-test
        driver.get("https://katalon-test.s3.amazonaws.com/demo-aut/dist/html/form.html");
    }

    @Test
    public void fillFormTest() {
        // przygotowanie danych
        String firstNameText = "Jan";
        String lastNameText = "Kowalski";

        // znajdz i wypelnij First name
        WebElement firstNameInput = driver.findElement(By.id("first-name"));
        if (firstNameInput.isDisplayed()) {
            firstNameInput.sendKeys(firstNameText);
            WebElement firstNameLabel = driver.findElement(By.cssSelector("label[for='first-name']"));
            System.out.println(firstNameLabel.getText() + " : " + firstNameText);
        } else {
            Assert.fail("firstNameInput is not displayed.");
        }

        // znajdz i wypelnij Last name
        WebElement lastNameInput = driver.findElement(By.id("last-name"));
        if (lastNameInput.isDisplayed()) {
            lastNameInput.sendKeys(lastNameText);
            WebElement lastNameLabel = driver.findElement(By.cssSelector("label[for='last-name']"));
            System.out.println(lastNameLabel.getText() + " : " + lastNameText);
        } else {
            Assert.fail("lastNameInput is not displayed.");
        }

        // wybierz male
        WebElement maleRadioButton = driver.findElement(By.xpath("//*[@id=\"infoForm\"]/div[3]/div/div/label[1]/input"));
        maleRadioButton.click();

        // select
        Select roleDropdown = new Select(driver.findElement(By.id("role")));
        roleDropdown.selectByVisibleText("QA");

        driver.findElement(By.id("submit")).click();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
