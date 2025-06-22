package TestFinalSwagLabs.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.Map;

public class BaseTest {

    public WebDriver driver;
    ChromeOptions options = new ChromeOptions();

    @BeforeMethod // această metodă se rulează înainte de fiecare test.
    public void openBrowser() {

        // Dezactivam Google Password Manager
        options.addArguments("--disable-save-password-bubble");
        options.addArguments("--incognito");
        options.setExperimentalOption("prefs", Map.of("credentials_enable_service", false,
                "profile.password_manager_enabled", false));

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
