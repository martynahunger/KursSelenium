package bdd;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearch {

    private WebDriver driver;

    @Given("an open browser with google.com")
    public void anOpenBrowserWithGoogle() {
        // Skonfiguruj sterownik przeglądarki
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        // Uruchom nowy egzemplarz przeglądarki Chrome
        driver = new ChromeDriver();
        // Zmaksymalizuj okno przeglądarki
        driver.manage().window().maximize();
        // Przejdź do Google
        driver.get("http://www.google.com");
    }

    @When("a keyword (.*) is entered in input field")
    public void aKeywordIsEnteredInInputField(String keyword) {
        // Znajdź element wprowadzania tekstu na podstawie jego nazwy
        WebElement element = driver.findElement(By.name("q"));
        // Wyczyść tekst zapisany w elemencie
        element.clear();
        // Wpisz informacje do wyszukania
        element.sendKeys(keyword);
        // Prześlij formularz
        element.submit();
    }

    @Then("the first one should contain (.*)")
    public void theFirstOneShouldContainSelenium(String expectedText) {
        System.out.println(expectedText);
    }

    @And("close browser")
    public void closeBrowser() {
        driver.quit();
    }
}
