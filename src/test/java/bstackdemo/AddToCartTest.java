package bstackdemo;


import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.ProductPage;

public class AddToCartTest extends BaseTest {

    @Test
    public void TC_004_addSingleItemToCart() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("demouser");
        loginPage.enterPassword("testingisfun99");
        loginPage.clickLogin();

        ProductPage productPage = new ProductPage(driver);
        productPage.addFirstProductToCart();

        Assert.assertEquals(
            productPage.getCartCount(),
            1,
            "Cart count should be 1 after adding single item"
        );
    }
    @Test
    public void TC_005_addMultipleItemsToCart() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("demouser");
        loginPage.enterPassword("testingisfun99");
        loginPage.clickLogin();

        ProductPage productPage = new ProductPage(driver);
        productPage.addFirstProductToCart();
        productPage.addFirstProductToCart();
        productPage.addFirstProductToCart();

        Assert.assertEquals(
            productPage.getCartCount(),
            3,
            "Cart count should be 3 after adding three items"
        );
    }
}


