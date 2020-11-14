package bdd;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class QloRegister {

    private WebDriver driver;

    @Given("^user is on authentication page$")
    public void userIsOnAuthenticationPage() {
        // Skonfiguruj sterownik przeglądarki
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        // Uruchom nowy egzemplarz przeglądarki Chrome
        driver = new ChromeDriver();
        // Zmaksymalizuj okno przeglądarki
        driver.manage().window().maximize();
        // dodaj wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.MINUTES);
        // Przejdź do strony z mozliwoscia zalozenia konta
        driver.get("https://qloapps.coderslab.pl/pl/logowanie?back=my-account");
    }

    @When("^user inputs email address and click create an account button$")
    public void userInputsEmailAddressAndClickCreateAnAccountButton() {
        driver.findElement(By.id("email_create")).sendKeys("johnd@mail.com");
        driver.findElement(By.id("SubmitCreate")).click();
    }

    @When("^user inputs first name, last name and password$")
    public void userInputsFirstNameLastNameAndPassword() {
        driver.findElement(By.id("customer_firstname")).sendKeys("John");
        driver.findElement(By.id("customer_lastname")).sendKeys("Doe");
        driver.findElement(By.id("passwd")).sendKeys("qwerty");
    }

    @And("^user clicks Register$")
    public void userClicksRegister() {
        driver.findElement(By.id("submitAccount")).click();
    }

    @Then("^user is registered$")
    public void userIsRegistered() {
        String successMessage = driver.findElement(By.className("alert-success")).getText();
        Assert.assertEquals("Your account has been created.", successMessage);
    }
}
