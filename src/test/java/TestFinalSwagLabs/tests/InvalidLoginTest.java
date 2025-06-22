package TestFinalSwagLabs.tests;

import TestFinalSwagLabs.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class InvalidLoginTest extends BaseTest {

    @Test
    public void testInvalidLoginShowsErrorMessage(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.isPageLoaded();
        // Test cu parola incorecta
        loginPage.login("standard_user", "wrong123");
        // Verificam daca mesajul de eroare este afisat
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message is not displayed!");
        Assert.assertEquals(loginPage.getErrorMessageText(), "Epic sadface: Username and password do not match any user in this service",
                "Error message is not displayed!");
    }


}
