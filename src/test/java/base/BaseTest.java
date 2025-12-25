package base;
import org.openqa.selenium.WebDriver; 
import org.testng.annotations.AfterMethod; 
import org.testng.annotations.BeforeMethod;

import Utils.WebDriverFactory; 

public class BaseTest { 

   protected WebDriver driver; 

   @BeforeMethod   
   public void setup() { 
	   
 
       driver = WebDriverFactory.createDriver();        
       driver.manage().window().maximize();      
       driver.get("https://bstackdemo.com/"); 
       }
   
   @AfterMethod  
   public void tearDown() {   
	   if(driver != null) {     
		   driver.quit(); 
       } 
   } 
}



