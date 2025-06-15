package Homerwork.pomExample.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.BasePage;

public class LoginPage extends BasePage {

    // locatori specifici paginii
//    private By pageTitle = By.xpath("//div[text()='Sauce Labs Backpack']");
    private By userNameFieldLocator = By.id("user-name");
    private By passwordLocator = By.id("password");
    private By loginButtonLocator = By.id("login-button");

    String userNameText = "standard_user";
    String paswordText = "secret_sauce";



    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void isPageLoaded() {
        Assert.assertEquals(driver.getTitle(),"Swag Labs",
                "Product 'Sauce Labs Backpack' is not displayed");
    }

    public void loginWithCedentials() {
        userNameInput();
        passwordInput();
        clickLogin();
    }


    public void userNameInput() {
        driver.findElement(userNameFieldLocator).sendKeys(userNameText);
    }

    public void passwordInput() {
        driver.findElement(passwordLocator).sendKeys(paswordText);
    }

    public void clickLogin() {
        driver.findElement(loginButtonLocator);

    }


}
