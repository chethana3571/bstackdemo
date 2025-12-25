package bstackdemo;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void TC_001_validLogin() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("demouser");
        loginPage.enterPassword("testingisfun99");
        loginPage.clickLogin();

        Assert.assertTrue(
            driver.getCurrentUrl().contains("product"),
            "User is not on product page after login"
        );
    }

    @Test
    public void TC_002_invalidLogin() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("wronguser");
        loginPage.enterPassword("wrongpass");
        loginPage.clickLogin();

        Assert.assertEquals(
            loginPage.getErrorMessage(),
            "Invalid username or password!",
            "Error message mismatch"
        );
    }

    @Test
    public void TC_003_emptyCredentials() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("");
        loginPage.enterPassword("");
        loginPage.clickLogin();

        Assert.assertEquals(
            loginPage.getErrorMessage(),
            "Username and Password required!",
            "Error message mismatch"
        );
    }
}


 
