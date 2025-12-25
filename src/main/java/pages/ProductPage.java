package pages;

import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver; 

public class ProductPage { 

   private WebDriver driver; 

   private By productAddButton = By.xpath("//button[text()='Add to cart']"); 
   private By cartCount = By.id("cart-count"); 

   public ProductPage(WebDriver driver) {  
	   this.driver = driver; 
   } 
   
   public void addFirstProductToCart() { 
       driver.findElement(productAddButton).click(); 
   }  
   
   public int getCartCount() { 
       String countText = driver.findElement(cartCount).getText();   
       return Integer.parseInt(countText); 
   } 
} 

