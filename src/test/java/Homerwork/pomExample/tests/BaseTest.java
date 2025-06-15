package Homerwork.pomExample.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    // de facut un exemplu cu un scenariu de test folosind POM
    // BaseTest + clasa de test
    // BasePage + clasa de page

   public WebDriver driver;

    @BeforeMethod // această metodă se rulează înainte de fiecare test.
    public void openBrowser() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
