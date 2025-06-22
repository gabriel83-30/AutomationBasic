package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CommonPage;
import pages.FramesPage;
import pages.HomePage;

import static constants.MenuConstants.ALERTS_FRAMES_WINDOWS_MENU;
import static constants.SubMenuConstants.FRAMES_SUBMENU;

public class FramesTest extends BaseTest {


    @Test
    public void FramesTest(){

        HomePage homePage = new HomePage(driver);
        homePage.isPageLoaded();
        homePage.goToDesiredMenu(ALERTS_FRAMES_WINDOWS_MENU);
        CommonPage commonPage = new CommonPage(driver);
        commonPage.isPageLoaded();
        commonPage.goToDesiredSubMenu(FRAMES_SUBMENU);
        FramesPage framesPage = new FramesPage(driver);
        framesPage.isPageLoaded();
        framesPage.interactWithFrameOne();
        framesPage.interactWithFrameTwo();

    }

//    public void openBrowser() {
//        driver = new ChromeDriver();
////        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.manage().window().maximize();
//        driver.get("https://demoqa.com/");
//    }

//    // facem o metoda care alege un meniu
//    public void chooseMenu() {
//        WebElement alertsFrameWindows = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].scrollIntoView(true);", alertsFrameWindows);
//        alertsFrameWindows.click();
//    }
//
//    public  void scrollToElement(WebElement element){
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].scrollIntoView(true);", element);
//    }
//
//    // facem o metoda care sa selecteze sub-meniul
//    public void chooseSubMenu() {
//        WebElement alertsSubMenu = driver.findElement(By.xpath("//span[text()='Frames']"));
//        alertsSubMenu.click();
//    }
//
//    public void closeBrowser() {
//        driver.quit();
//    }
//
//    public void interactWithFrameOne(){
//        WebElement frameOneElement = driver.findElement(By.id("frame1"));
//        driver.switchTo().frame(frameOneElement);// ne mutam de pe pagina principala pe tabul nou deschis
//        WebElement frameOneTextValue = driver.findElement(By.id("sampleHeading"));
//        String expectedText = "This is a sample page";
//        Assert.assertEquals(frameOneTextValue.getText(), expectedText, "This is a not displayed properly ");
//        System.out.println("Frame one is: " + frameOneTextValue.getText());
//        driver.switchTo().defaultContent(); // schimbam focusul pe pagina initiala
//    }
//
//    public void interactWithFrameTwo(){
//        WebElement frameTwoElement = driver.findElement(By.id("frame2"));
//        driver.switchTo().frame(frameTwoElement);// ne mutam de pe pagina principala pe tabul nou deschis
//        WebElement frameTwoTextValue = driver.findElement(By.id("sampleHeading"));
//        String expectedText = "This is a sample page";
//        Assert.assertEquals(frameTwoTextValue.getText(), expectedText, "This is a not displayed properly ");
//        System.out.println("Frame two is: " + frameTwoTextValue.getText());
//        driver.switchTo().defaultContent();
//    }
}

