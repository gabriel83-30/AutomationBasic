package Homerwork;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;


//  homework -> pachet nou
//  Pachete nou java -> 1 , 2 sau 3 siteu-ri unde sa facem initializare browser, gasit un element sau doua, facut o actiune pe el (un click, sau ceva sendkeys)

public class siteTestSwagLabs {

    WebDriver driver;

    @Test
    public void siteTestSwag() {

        //  Se creează o instanță de ChromeDriver, ceea ce înseamnă că se deschide automat un browser Chrome controlat de Selenium.
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com");  // Navigam catre pegina website-ului
        driver.manage().window().maximize();   // Facem fereastra browser-ului maximize
        WebElement userNameField = driver.findElement(By.id("user-name"));    //completam field-ul de user name
        userNameField.sendKeys("standard_user");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce"); // completam field-ul de password
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
//        WebElement selectItemFieldBackPack = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"));
//        selectItemFieldBackPack.click();
//        WebElement selectItemFieldBikeLight = driver.findElement(By.xpath("//div[text()='Sauce Labs Bike Light']"));
//        selectItemFieldBikeLight.click();

        // Căutăm un element <div> care are textul exact „Sauce Labs Backpack”.
        //isDisplayed() ne confirmă dacă e vizibil pe pagină ,dacă nu apare → testul pică cu mesajul nostru.

//        boolean isProductDisplayed = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).isDisplayed();
//        assert isProductDisplayed:"Product 'Suace Labs Backpack' is not displayed";

//        List<WebElement> productElements = driver.findElements(By.className("inventory_item_name")); // preluam toate produsele de pe pagina
//
//        List<String> productNames = new ArrayList<>(); // salvam numele produselor intr-o lista de String
//        for (WebElement product : productElements) {
//            productNames.add(product.getText());
//
//        }
//
//        System.out.println("Products found: " + productNames); // Printam lista
//
//        // Lista asteptata
//        List<String> expectedProducts = Arrays.asList(
//                "Sauce Labs Onesie",
//                "Test.allTheThings() T-Shirt (Red)"
//        );
//
//        //  Verificăm că toate produsele așteptate sunt în lista reală
//        for (String expectedProduct : expectedProducts) {
//            Assert.assertTrue(productNames.contains(expectedProducts), "Unexpected product not found: " + expectedProduct);
//        }

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 300);"); // scroll 500 pixeli
//        WebElement formMeniu = driver.findElement(By.className("inventory_item_name"));
//        js.executeScript("arguments[0].scrollIntoView(true);", formMeniu);

    }

}
