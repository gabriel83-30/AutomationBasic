package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CommonPage;
import pages.DroppablePage;
import pages.HomePage;

public class DrappobleTest extends BaseTest {


    @Test
    public void DrappobleTest() {

        HomePage homePage = new HomePage(driver);
        homePage.isPageLoaded();
        homePage.goToDesiredMenu("Interactions");
        CommonPage commonPage = new CommonPage(driver);
        commonPage.isPageLoaded();
        commonPage.goToDesiredSubMenu("Droppable");
        DroppablePage droppablePage = new DroppablePage(driver);
        droppablePage.isPageLoaded();
        droppablePage.pickAndDropElement();
    }

//    public void openBrowser() {
//        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.manage().window().maximize();
//        driver.get("https://demoqa.com/");
//    }

    // facem o metoda care alege un meniu
//    public void chooseMenu() {
//        WebElement interectionMenu = driver.findElement(By.xpath("//h5[text()='Interactions']"));
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].scrollIntoView(true);", interectionMenu);
//        interectionMenu.click();
//    }
//
//    public void scrollToElement(WebElement element) {
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].scrollIntoView(true);", element);
////        js.executeScript("window.scrollTo(0, 500);"); // scroll 500 pixeli
//
//    }
//
//    // facem o metoda care sa selecteze sub-meniul
//    public void chooseSubMenu() {
//        WebElement alertsSubMenu = driver.findElement(By.xpath("//span[text()='Droppable']"));
//        alertsSubMenu.click();
//    }

//    public void closeBrowser() {
//        driver.quit();
//    }

//    public void pickAndDropElement() {
//        WebElement draggableElement = driver.findElement(By.id("draggable"));
//        WebElement droppableElement = driver.findElement(By.xpath("//div[@id='simpleDropContainer']//div[@id='droppable']"));
//        String initialTargetText = droppableElement.getText();
//        Actions action = new Actions(driver);// clasa ne aujuta sa imitam click and hold ,
//        action.dragAndDrop(draggableElement, droppableElement).release().perform();
//        Assert.assertNotEquals(droppableElement.getText(), initialTargetText, "Initial text is the same with actual text after element dropped");
//        System.out.println("Initial text is: " + initialTargetText + " text after successfully drop: " + draggableElement.getText());
//
//
//    }
}
