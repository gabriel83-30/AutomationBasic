package TestFinalSwagLabs.tests;


import TestFinalSwagLabs.pages.*;
import org.testng.annotations.Test;

public class CheckoutAndConfirmationCompleteTest extends BaseTest {

    @Test
    public void testCompleteOrderSuccessfully() {
        // Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.isPageLoaded();
        loginPage.login("standard_user", "secret_sauce");
        // Add product
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.isPageLoaded();
        productsPage.addSauceLabsBackPackToCart();
        //Navigate to cart
        productsPage.navigateToCart();
        // Checkout
        CartPage cartPage = new CartPage(driver);
        cartPage.verifyBackPackIsInCart();
        cartPage.proceedToCheckout();
        // Fill out checkout info
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.enterCheckoutInformation("John", "Matei", "477171");
        checkoutPage.finishOrder();
        // Verify order confirmation
        ConfirmationPage confirmationPage = new ConfirmationPage(driver);
        confirmationPage.verifyOrderConfirmationMessage();
    }
}
