package TestFinalSwagLabs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CartPage extends BasePage {

    // locator pt titlul produsului in cos
    private By cartItemName = By.className("inventory_item_name");
    private By checkoutButton = By.xpath("//button[text()='Checkout']");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void isPageLoaded() {
        Assert.assertTrue(driver.findElement(cartItemName).isDisplayed(),
                "Basket page not loading correctly!");
    }

    public void verifyBackPackIsInCart() {
        String expectedProduct = "Sauce Labs Backpack";
        String actualProduct = driver.findElement(cartItemName).getText();
        Assert.assertEquals(actualProduct, expectedProduct,
                "The product in the basket is not what you expected");
    }

    public void proceedToCheckout() {
//        Assert.assertTrue(driver.getCurrentUrl().contains("cart.html"), "Not on cart page!");
        waitForElement(checkoutButton);
        driver.findElement(checkoutButton).click();
    }
}
