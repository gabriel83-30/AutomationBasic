package TestFinalSwagLabs.tests;

import org.apache.commons.exec.CommandLine;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertTrue;


//  homework -> pachet nou
//  Pachete nou java -> 1 , 2 sau 3 siteu-ri unde sa facem initializare browser, gasit un element sau doua, facut o actiune pe el (un click, sau ceva sendkeys)

public class siteTestSwagLabs {

    ChromeOptions options = new ChromeOptions();

    WebDriver driver;

    @Test
    public void siteTestSwag() {

        options.addArguments("--disable-save-password-bubble");
        options.addArguments("--incognito");
        options.setExperimentalOption("prefs", Map.of("credentials_enable_service", false,
                "profile.password_manager_enabled", false));


//        //  Se creează o instanță de ChromeDriver, ceea ce înseamnă că se deschide automat un browser Chrome controlat de Selenium.
//        WebDriver driver = new ChromeDriver();
//
//        driver.manage().window().maximize();   // Facem fereastra browser-ului maximize
//        driver.get("https://www.saucedemo.com");  // Navigam catre pegina website-ului
//
//
//        driver.findElement(By.id("user-name")).sendKeys("standard_user");
//
//        driver.findElement(By.id("password")).sendKeys("secret_sauce"); // completam field-ul de password
//
//        driver.findElement(By.id("login-button")).click();
//
//        // Căutăm un element <div> care are textul exact „Sauce Labs Backpack”.
//        //isDisplayed() ne confirmă dacă e vizibil pe pagină ,dacă nu apare → testul pică cu mesajul nostru.
//        // Verificăm că produsele principale sunt vizibile
//
//        boolean isBackPackVisible = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).isDisplayed();
//        boolean isBikeLightVisible = driver.findElement(By.xpath("//div[text()='Sauce Labs Bike Light']")).isDisplayed();
//        boolean isTShirtVisible = driver.findElement(By.xpath("//div[text()='Sauce Labs Bolt T-Shirt']")).isDisplayed();
//        boolean isOnesieVisible = driver.findElement(By.xpath("//div[text()='Sauce Labs Onesie']")).isDisplayed();
//
//        Assert.assertTrue(isBackPackVisible, "Backpack is not displayed");
//        Assert.assertTrue(isBikeLightVisible, "Bike Light is not displayed");
//        Assert.assertTrue(isTShirtVisible, "T-Shirt is not displayed");
//        Assert.assertTrue(isOnesieVisible, "Sauce Labs Onesie is not displayed");
//
//        // Verificăm dacă alte produse așteptate apar pe pagină
//        List<WebElement> productElements = driver.findElements(By.className("inventory_item_name")); // preluam toate produsele de pe pagina//
//        List<String> productNames = new ArrayList<>(); // salvam numele produselor intr-o lista de String
//        for (WebElement product : productElements) {
//            productNames.add(product.getText());//
////        }
////
//            System.out.println("Products found: " + productNames); // Printam lista
////
////        // Lista asteptata
//            List<String> expectedProducts = Arrays.asList("Sauce Labs Onesie", "Test.allTheThings() T-Shirt (Red)");
////
////        //  Verificăm că toate produsele așteptate sunt în lista reală
//            for (String expectedProduct : expectedProducts) {
//                Assert.assertTrue(productNames.contains(expectedProduct), "Unexpected product not found: " + expectedProduct);
//            }
//
////            JavascriptExecutor js = (JavascriptExecutor) driver;
////            js.executeScript("window.scrollTo(0, 300);"); // scroll 500 pixeli
////
////            WebElement formMeniu = driver.findElement(By.className("inventory_item_name"));
////            js.executeScript("arguments[0].scrollIntoView(true);", formMeniu);
//
//            driver.quit();
//
//        }

    }

}
