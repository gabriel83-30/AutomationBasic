package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class WindowsPage extends BasePage {

    // locatori specific paginii
    private By pageTitle = By.id("//h1[@class]");
    private By newTabButton = By.id("tabButton");
    private By windowsTextValidationLocator = By.id("sampleHeading");
    private By newWindowsButton = By.id("windowButton");
    private By newWindowMessageButton = By.id("messageWindowButton");


    String expectedText = "This is a sample page";

    public WindowsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void isPageLoaded() {
        Assert.assertEquals(elementMethods.getTextFromElement(pageTitle),
                "Browser Windows", "Page is not loaded properly");

    }

    public void interactWithNewTab() {
        elementMethods.clickElement(newTabButton);
        windowsMethods.switchToWindow(1);
        Assert.assertEquals(elementMethods.getTextFromElement(windowsTextValidationLocator), expectedText, "This is a not displayed properly ");
        windowsMethods.closeWindowOrTab(); // inchide fereastra, driver.quit--> inchide intreaga instanta
        windowsMethods.switchToWindow(0);
    }

    public void interactWithNewWindows() {
        elementMethods.clickElement(newWindowsButton);
        windowsMethods.switchToWindow(1);
        Assert.assertEquals(elementMethods.getTextFromElement(windowsTextValidationLocator), expectedText, "This is a not displayed properly ");
        windowsMethods.closeWindowOrTab(); // inchide fereastra, driver.quit--> inchide intreaga instanta
        windowsMethods.switchToWindow(0);
    }

    public void interactWithNewWindowsMessage() {
        elementMethods.clickElement(newWindowMessageButton);
        windowsMethods.newMessageWindow();
        windowsMethods.switchToWindow(1);
        windowsMethods.closeWindowOrTab();
        windowsMethods.switchToWindow(0);
    }

}
