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


    String expectedText ="This is a sample page";


//    private By newTabButton =

    public WindowsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void isPageLoaded() {
        Assert.assertEquals(driver.findElement(pageTitle).getText(),
                "Browser Windows", "Page is not loaded properly");

    }

    public void interactWithNewTab() {

        driver.findElement(newTabButton).click();
        List<String> windowsList = new ArrayList<>(driver.getWindowHandles()); //declaram o lista de ferestre
        driver.switchTo().window(windowsList.get(1));// ne mutam pe tabul nou deschis
        Assert.assertEquals(driver.findElement(windowsTextValidationLocator).getText(), expectedText, "This is a not displayed properly ");
        driver.close(); // inchide fereastra, driver.quit--> inchide intreaga instanta
        driver.switchTo().window(windowsList.get(0));

    }

    public void interactWithNewWindows() {
        driver.findElement(newWindowsButton).click();
        List<String> windowsList = new ArrayList<>(driver.getWindowHandles()); //declaram o lista de ferestre
        driver.switchTo().window(windowsList.get(1));
        Assert.assertEquals(driver.findElement(newWindowsButton).getText(), expectedText, "This is a not displayed properly ");
        driver.close(); // inchide fereastra, driver.quit--> inchide intreaga instanta
        driver.switchTo().window(windowsList.get(0));

    }

    public void interactWithNewWindowsMessage() {

        driver.findElement(newWindowMessageButton).click();
        List<String> windowsList = new ArrayList<>(driver.getWindowHandles()); //declaram o lista de ferestre
        if (windowsList.size() > 1) {
            System.out.println(" A new window is successfully opened");
        } else {
            System.out.println(" New window can't opened");
        }
        driver.switchTo().window(windowsList.get(1));
        driver.close();
        driver.switchTo().window(windowsList.get(0));
    }


}
