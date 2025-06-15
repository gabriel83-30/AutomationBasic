package Homerwork.pomExample.tests;

import Homerwork.pomExample.pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginTest() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.isPageLoaded();
        loginPage.loginWithCedentials();


    }
}
