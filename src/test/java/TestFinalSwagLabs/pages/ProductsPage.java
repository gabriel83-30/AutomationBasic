package TestFinalSwagLabs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ProductsPage extends BasePage {

    // locator pentru pagina de produse
    private By pageTitle = By.className("title");
    // locator pentru butonul"Add to cart" la produsul "Sauce Labs Backpack"
    private By addBackPackButton = By.id("add-to-cart-sauce-labs-backpack");
    // locator pt iconita de cos
    private final By cartIcon = By.className("shopping_cart_link");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void isPageLoaded() {
        Assert.assertEquals(driver.findElement(pageTitle).getText(), "Products",
                "Products page didn't load correctly");
    }

    public void addSauceLabsBackPackToCart(){
        driver.findElement(addBackPackButton).click();
    }

    public void navigateToCart(){
        driver.findElement(cartIcon).click();
    }

}



