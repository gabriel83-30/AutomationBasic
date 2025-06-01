package Homerwork.pomExample.tests;

import Homerwork.pomExample.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import tests.BaseTest;

public class LoginTest extends BaseTests {

    @Test
    public void validLoginTest() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.isPageLoaded();
        loginPage.loginWithCedentials();


    }
}
