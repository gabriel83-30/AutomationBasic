package TestFinalSwagLabs.tests;

import TestFinalSwagLabs.pages.LoginPage;
import TestFinalSwagLabs.pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Objects;

import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginTestShouldRedirectToInventory() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
    }
}
