import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class WindowsTest {

    WebDriver driver;

    @Test
    public void WindowsTest() {
        openBrowser();
        chooseMeniu();
        chooseSubMenu();
        interactWithNewTab();
        interactWithNewWindows();
//        closeBrowser();
        interactWithNewWindowsMessage();

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
        WebElement alertsSubMenu = driver.findElement(By.xpath("//span[text()='Browser Windows']"));
        alertsSubMenu.click();
    }

    public void interactWithNewTab() {
        WebElement newTabButton = driver.findElement(By.id("tabButton"));
        newTabButton.click();
        List<String> windowsList = new ArrayList<>(driver.getWindowHandles()); //declaram o lista de ferestre
        driver.switchTo().window(windowsList.get(1));// ne mutam pe tabul nou deschis
        WebElement tabTextValue = driver.findElement(By.id("sampleHeading"));
        String expectedText = "This is a sample page";
        Assert.assertEquals(tabTextValue.getText(), expectedText, "This is a not displayed properly ");
        driver.close(); // inchide fereastra, driver.quit--> inchide intreaga instanta
        driver.switchTo().window(windowsList.get(0));

    }

    public void interactWithNewWindows() {
        WebElement newWindowsButton = driver.findElement(By.id("windowButton"));
        newWindowsButton.click();
        List<String> windowsList = new ArrayList<>(driver.getWindowHandles()); //declaram o lista de ferestre
        driver.switchTo().window(windowsList.get(1));// ne mutam pe tabul nou deschis
        WebElement windowsTextValue = driver.findElement(By.id("sampleHeading"));
        String expectedText = "This is a sample page";
        Assert.assertEquals(windowsTextValue.getText(), expectedText, "This is a not displayed properly ");
        driver.close(); // inchide fereastra, driver.quit--> inchide intreaga instanta
        driver.switchTo().window(windowsList.get(0));

    }

    public void closeBrowser() {
        driver.quit();
    }

    public void interactWithNewWindowsMessage() {
        WebElement newWindowsButton = driver.findElement(By.id("messageWindowButton"));
        newWindowsButton.click();
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
