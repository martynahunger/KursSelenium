package pageobjectpattern.userData;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjectpattern.pages.HeaderObject;
import pageobjectpattern.pages.LoginPage;
import pageobjectpattern.pages.UserInformationPage;

import java.util.concurrent.TimeUnit;

public class ChangeUserInfoSteps {

    private WebDriver driver;

    private UserInformationPage userInformationPage;

    @Given("^User is logged in to CodersLab shop$")
    public void userIsLoggedInToCodersLabShop() {
        // Uruchom nowy egzemplarz przeglądarki Chrome
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();

        // Zmaksymalizuj okno przeglądarki
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=authentication");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("johnd@mail.com", "qwerty");

        userInformationPage = new UserInformationPage(driver);
    }

    @When("^User goes to UserInformationPage$")
    public void userGoesToUserInformationPage() {
        HeaderObject headerObject = new HeaderObject(driver);
        headerObject.clickLoggedUsername();
        // todo: stworzyc nowy page object
        driver.findElement(By.id("identity-link")).click();
    }

    @And("^User signs up for our newsletter$")
    public void userSignsUpForOurNewsletter() {
        userInformationPage.signInForNewsletter();
    }

    //@And("^User changes birth date to (\\d+)/(\\d+)/(\\d+)$")
    @And("^User changes birth date to 10/10/2020$")
    public void userChangesBirthDateTo() {
        userInformationPage.setBirthdate("10/10/2020");
    }

    @And("^User saves information$")
    public void userSavesInformation() {
        userInformationPage.submitUserInfo("qwerty");
    }

    @Then("^User sees \"([^\"]*)\"$")
    public void userSees(String expectedMessage) {
        Assert.assertEquals(expectedMessage, userInformationPage.getUpdateInformation());
    }
}
