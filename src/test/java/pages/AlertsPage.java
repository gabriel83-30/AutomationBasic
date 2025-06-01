package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class AlertsPage extends BasePage {

// locatori specifi paginii
    private By pageTitle = By.xpath("//h1[@class]");
    private By firstAlertButton = By.id("alertButton");
    private By timerAlertButton = By.id("timerAlertButton");
    private By confirmAlertButton = By.id("confirmButton");
    private By alertResultText = By.id("confirmResult");
    private By confirmPromptButton = By.id("promtButton");
    private By promptResult = By.id("promptResult");


    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void isPageLoaded() {
        Assert.assertEquals(driver.findElement(pageTitle).getText(),
                "Alerts","Page is not loaded properly");
    }

    public void interactWithFirstAlert() {
        driver.findElement(firstAlertButton).click();
        Alert FirstAlert = driver.switchTo().alert();
        FirstAlert.accept();
    }

    //facem o metoda care sa interactioneze cu prima alerta;
    public void interactWithTimerAlert() {
        driver.findElement(timerAlertButton).click();
        //Inainte sa schimbam focusul pe alerta, trebuie sa punem un wait explicit;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert timerAlert = driver.switchTo().alert();
        timerAlert.accept();
    }

    public void interactWithConfirmAlert(String alertValue) {
        driver.findElement(confirmAlertButton).click();
        Alert confirmAlert = driver.switchTo().alert();
        if (alertValue.equals("ok")) {
            confirmAlert.accept();
            Assert.assertTrue(driver.findElement(alertResultText).getText().contains(alertValue), "You didn't select Ok. You selected: "
                    + driver.findElement(alertResultText).getText());
        }
        if (alertValue.equals("Cancel")) {
            confirmAlert.dismiss();
            Assert.assertTrue(driver.findElement(alertResultText).getText().contains(alertValue), "You didn't select Cancel. You selected: "
                    + driver.findElement(alertResultText).getText());
        }
    }


    public void interactWithPromptAlert(String alertValue) {
        driver.findElement(confirmPromptButton).click(); // click pe butonul care deschide promptul
        // comutare pe alerta si introducere text
        Alert promptAlert = driver.switchTo().alert();
        promptAlert.sendKeys(alertValue);
        promptAlert.accept(); // Confirmă alerta (accept).
        Assert.assertTrue(driver.findElement(promptResult).getText().contains(alertValue), "You didn't enter the right name. In the box "
                + driver.findElement(promptResult).getText());

    }

}
