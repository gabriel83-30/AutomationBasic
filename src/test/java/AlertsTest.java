import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertsTest {

    WebDriver driver;

    @Test
    public void alertsTest() {
        openBrowser();
        chooseMeniu();
        chooseSubMenu();
        interactWithFirstAlert();
//        interactWithTimerAlert();
        interactWithConfirmAlertDoi("Cancel");
        interactWithPromptAlert();
//        interactWithPromptAlertSecond();

    }

    public void openBrowser() {
        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/");
    }

    // facem o metoda care alege un meniu
    public void chooseMeniu() {
        WebElement alertsFrameWindows = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", alertsFrameWindows);
        alertsFrameWindows.click();
    }

    // facem o metoda care sa selecteze sub-meniul
    public void chooseSubMenu() {
        WebElement alertsSubMenu = driver.findElement(By.xpath("//span[text()='Alerts']"));
        alertsSubMenu.click();
    }

    public void interactWithFirstAlert() {
        WebElement firstAlertButton = driver.findElement(By.id("alertButton"));
        firstAlertButton.click();
        Alert FirstAlert = driver.switchTo().alert();
        FirstAlert.accept();
    }

    public void interactWithTimerAlert() {
        WebElement timerAlertButton = driver.findElement(By.id("timerAlertButton"));
        timerAlertButton.click();
        // Inainte sa schimbam focusulpe alerta, Trebuie sa punem un wait explicit
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert timerAlert = driver.switchTo().alert();
        timerAlert.accept();
    }


//    public void interactWithConfirmAlert() {
//        WebElement confirmtAlertButton = driver.findElement(By.id("confirmButton"));
//        confirmtAlertButton.click();
//        Alert confirmAlert = driver.switchTo().alert();
//        confirmAlert.dismiss();
//        WebElement alertResultText = driver.findElement(By.id("confirmResult"));
//        Assert.assertTrue(alertResultText.getText().contains("cancel"), "You didn't select Cancel.You selected: " + alertResultText.getText());
//
//    }

    //    sau
    public void interactWithConfirmAlertDoi(String alertValue) {
        WebElement confirmtAlertButton = driver.findElement(By.id("confirmButton"));
        confirmtAlertButton.click();
        Alert confirmAlert = driver.switchTo().alert();
        if (alertValue.equals("ok")) {
            confirmAlert.accept();
            WebElement alertResultText = driver.findElement(By.id("confirmResult"));
            Assert.assertTrue(alertResultText.getText().contains(alertValue), "You didn't select ok. You selected: " + alertResultText);
        }
        if (alertValue.equals("Cancel")) {
            confirmAlert.dismiss();
            WebElement alertResultText = driver.findElement(By.id("confirmResult"));
            Assert.assertTrue(alertResultText.getText().contains(alertValue), "You didn't select Cancel.You selected: " + alertResultText.getText());

        }
    }

    // homework continuare

    public void interactWithPromptAlert() {
        WebElement promptAlertButton = driver.findElement(By.id("promtButton")); // click pe butonul care deschide promptul
        promptAlertButton.click();

        // comutare pe alerta si introducere text
        Alert promptAlert = driver.switchTo().alert();
        String inputText = "Gabi";
        promptAlert.sendKeys(inputText);
        promptAlert.accept(); // Confirmă alerta (accept).

        // Verificam dc textul introdus „You entered gabi” este afisat pe pagina
        WebElement promptResultText = driver.findElement(By.id("promptResult")); //
        Assert.assertTrue(promptResultText.getText().contains("Gabi"), "The message in the prompt is wrong!"); // Asigură că mesajul afișat conține textul „gabi”.

    }




//    public void interactWithPromptAlertSecond(){
//        WebElement promptAlertButton = driver.findElement(By.id("promtButton")); // click pe butonul care deschide promptul
//        promptAlertButton.click();
//
//        // comutare pe alerta si introducere text
//        Alert promptAlert = driver.switchTo().alert();
//        String inputText = "Gabi";
//        promptAlert.sendKeys(inputText);
//        promptAlert.accept(); // Confirmă alerta (accept).
//        WebElement resultText = driver.findElement(By.id("promptResult"));

//         //  Validare cu IF
//        if (resultText.getText().contains(inputText)){
//            System.out.println("Test PASSED: Mesajul afișat conține textul introdus: " + inputText);
//        } else {
//            System.out.println("Test FAILED: Mesajul afișat NU conține textul introdus.");
//            System.out.println("Mesaj afișat: " + resultText);
//        }





//        // Textul așteptat complet (exact cum apare pe site)
//        String expectedText = "You entered " + inputText;
//
//        // Obține textul afișat pe pagină
//        String actualText = driver.findElement(By.id("promptResult")).getText();
//
//        // Comparația exactă
//        Assert.assertEquals(actualText, expectedText, "The text displayed after the alert is not what you expected.");
    }





