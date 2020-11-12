package zadanie1dodatkowe;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;

public class RandomProductSearchTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        // Uruchom nowy egzemplarz przeglądarki Chrome
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();

        // Zmaksymalizuj okno przeglądarki
        driver.manage().window().maximize();
        // Przejdź do Google
        driver.get("https://prod-kurs.coderslab.pl/index.php");
    }

    @Test
    public void testRandomizedProductSearch() {
        String[] products = { "Sweater", "Mug", "T-Shirt", "Cushion"};
        Random random = new Random();
        int randomInteger = random.nextInt(products.length); //losuje liczby w przedziale 0 - dlugosc tablicy products
        String productToSearch = products[randomInteger];

        WebElement searchInput = driver.findElement(By.name("s"));
        searchInput.sendKeys(productToSearch);
        searchInput.submit();
    }

//    @After
//    public void tearDown() {
//        driver.quit();
//    }
}
