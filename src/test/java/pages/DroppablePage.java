package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class DroppablePage extends BasePage{

    //locatori specifici paginii
    private By pageTitle = By.id("//h1[@class]");
    private By draggableElement = By.id("draggable");
    private By droppabbleElement = (By.xpath("//div[@id='simpleDropContainer']//div[@id='droppable']"));







    public DroppablePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void isPageLoaded() {
        Assert.assertEquals(driver.findElement(pageTitle).getText(),
                "Droppable", "Page is not loaded properly");
    }

    public void pickAndDropElement() {


        String initialTargetText = driver.findElement(droppabbleElement).getText();
        Actions action = new Actions(driver);// clasa ne aujuta sa imitam click and hold ,
        action.dragAndDrop(driver.findElement(draggableElement), driver.findElement(droppabbleElement)).release().perform();
        Assert.assertNotEquals(driver.findElement(droppabbleElement).getText(), initialTargetText, "Initial text is the same with actual text after element dropped");
        System.out.println("Initial text is: " + initialTargetText + " text after successfully drop: " + driver.findElement(droppabbleElement).getText());


    }
}
