package bstackdemo;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test; 
import pages.CartPage;
import pages.CheckOutPage;
import pages.LoginPage;
import pages.ProductPage; 
public class CheckOutTest extends BaseTest { 

@Test 
   public void TC_007_placeOrderWithValidDetails() {   
	
	LoginPage loginPage = new LoginPage(driver);      
	loginPage.enterUsername("demouser");     
	loginPage.enterPassword("testingisfun99");       
	loginPage.clickLogin(); 

       ProductPage productPage = new ProductPage(driver);       
       productPage.addFirstProductToCart(); 

       CartPage cartPage = new CartPage(driver);        
       cartPage.clickCheckout(); 

       CheckOutPage checkoutPage = new CheckOutPage(driver);       
       checkoutPage.placeOrder(); 

       Assert.assertTrue(checkoutPage.getSuccessMessage().contains("Order placed successfully"), "Order success message missing"); 
   } 
    @Test 
   public void TC_008_checkoutWithoutAddingItems() {        
    	LoginPage loginPage = new LoginPage(driver);       
    	loginPage.enterUsername("demouser");         loginPage.enterPassword("testingisfun99");    
    	loginPage.clickLogin(); 

       CartPage cartPage = new CartPage(driver);        
       cartPage.clickCheckout(); 

       CheckOutPage checkoutPage = new CheckOutPage(driver);     
       checkoutPage.placeOrder(); 

       Assert.assertEquals(checkoutPage.getErrorMessage(), "Your cart is empty!", "Empty cart error message mismatch"); 
   } 
} 
