package TestFinalSwagLabs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages.BasePage;

public class LoginPage extends BasePage {

    // locatori specifici paginii

    private By userNameFieldLocator = By.id("user-name");
    private By passwordLocator = By.id("password");
    private By loginButtonLocator = By.id("login-button");
    private By loginErrorMesageLocator = By.xpath("//h3[@data-test='error']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String username, String password) {
        driver.findElement(userNameFieldLocator).sendKeys(username);
        driver.findElement(passwordLocator).sendKeys(password);
        driver.findElement(loginButtonLocator).click();
    }

    public boolean isErrorMessageDisplayed(){
        return driver.findElement(loginErrorMesageLocator).isDisplayed();
    }

    public String getErrorMessageText(){
        return driver.findElement(loginErrorMesageLocator).getText();
    }

    @Override
    public void isPageLoaded() {
        Assert.assertEquals(driver.getTitle(), "Swag Labs",
                "Product is not displayed");
    }

}
