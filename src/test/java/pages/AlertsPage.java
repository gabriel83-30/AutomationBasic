package pages;

import org.openqa.selenium.*;
import org.testng.Assert;

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
        Assert.assertEquals(elementMethods.getTextFromElement(pageTitle),
                "Alerts","Page is not loaded properly");
    }

    public void interactWithFirstAlert() {
       elementMethods.clickElement(firstAlertButton);
       alertsMethods.alertOk();

    }

    //facem o metoda care sa interactioneze cu prima alerta;
    public void interactWithTimerAlert() {
        elementMethods.clickElement(timerAlertButton);
        //Inainte sa schimbam focusul pe alerta, trebuie sa punem un wait explicit;
       alertsMethods.timerAlert();
    }

    public void interactWithConfirmAlert(String alertValue) {
        elementMethods.clickElement(confirmAlertButton);
        alertsMethods.confirmAlert(alertValue);
        Assert.assertTrue(elementMethods.getTextFromElement(alertResultText).contains(alertValue), "You didn't select Ok. You selected: "
                + elementMethods.getTextFromElement(alertResultText));

    }

    public void interactWithPromptAlert(String alertValue) {
        elementMethods.clickElement(confirmPromptButton);
        alertsMethods.promptAlert(alertValue);// click pe butonul care deschide promptul
        // comutare pe alerta si introducere text

        Assert.assertTrue(elementMethods.getTextFromElement(promptResult).contains(alertValue), "You didn't enter the right name. In the box "
                + elementMethods.getTextFromElement(promptResult));

    }

}
