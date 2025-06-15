package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class FramesPage extends BasePage{

    // locatori specifici paginii
    private By pageTitle = By.xpath("//h1[@class]");
    private By frameOneLocator = By.id("frame1");
    private By frameTextValueLocator = By.id("sampleHeading");
    private By frameTwoLocator = By.id("frame2");



    String expectedText = "This is a sample page";

    public FramesPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void isPageLoaded() {
        Assert.assertEquals(elementMethods.getTextFromElement(pageTitle),"Frames","Page is not loaded properly");

    }

    public void interactWithFrameOne(){
        frameMethods.switchToFrame(frameOneLocator); // ne mutam de pe pagina principala pe tabul nou deschis
        Assert.assertEquals(elementMethods.getTextFromElement(frameTextValueLocator), expectedText, "This is a not displayed properly ");
        System.out.println("Frame one is: " + elementMethods.getTextFromElement(frameTextValueLocator));
        frameMethods.switchToDefaultPage(); ; // schimbam focusul pe pagina initiala
    }

    public void interactWithFrameTwo(){
        frameMethods.switchToFrame(frameTwoLocator);// ne mutam de pe pagina principala pe tabul nou deschis
        Assert.assertEquals(elementMethods.getTextFromElement(frameTextValueLocator), expectedText, "This is a not displayed properly ");
        System.out.println("Frame two is: " + elementMethods.getTextFromElement(frameTextValueLocator));
        frameMethods.switchToDefaultPage();
    }
}
