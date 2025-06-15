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
        Assert.assertEquals(elementMethods.getTextFromElement(pageTitle),
                "Droppable", "Page is not loaded properly");
    }

    public void pickAndDropElement() {
        String initialTargetText = elementMethods.getTextFromElement(droppabbleElement);
        elementMethods.pickAndDropElemnent(draggableElement,droppabbleElement);
        Assert.assertNotEquals(elementMethods.getTextFromElement(droppabbleElement), initialTargetText, "Initial text is the same with actual text after element dropped");
        System.out.println("Initial text is: " + initialTargetText + " Text after successfully drop: " + elementMethods.getTextFromElement(droppabbleElement));

    }
}
