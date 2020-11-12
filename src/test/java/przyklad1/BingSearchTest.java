package przyklad1;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BingSearchTest {

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
        driver.get("https://www.bing.com/");
    }

    @Test
    public void testBingSearch() {
        //WebElement element = driver.findElement(By.name("q"));
        //WebElement element = driver.findElement(By.id("sb_form_q"));
        WebElement element = driver.findElement(By.className("sb_form_q"));
        element.clear();
        element.sendKeys("Mistrzostwa Swiata w pilce noznej 2018");
        element.submit();

        //asercje
        String title = driver.getTitle();
        Assert.assertEquals("Mistrzostwa Swiata w pilce noznej 2018 - Bing", title);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
