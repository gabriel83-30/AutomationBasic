package TestFinalSwagLabs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ConfirmationPage extends BasePage {

    private By confirmationMessage = By.className("complete-header");

    public ConfirmationPage(WebDriver driver) {
        super(driver);
    }

    public void verifyOrderConfirmationMessage(){
        String actualMessage = driver.findElement(confirmationMessage).getText();
        Assert.assertEquals(actualMessage, "THANK YOU FOR YOUR ORDER",
                "The confirmation message is not correct!");
    }

    @Override
    public void isPageLoaded() {
Assert.assertTrue(driver.findElement(confirmationMessage).isDisplayed(),
        "Confirmation Page did not load properly.");
    }
}
