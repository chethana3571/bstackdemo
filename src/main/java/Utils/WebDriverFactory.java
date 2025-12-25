package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions; 


public class WebDriverFactory {

    public static WebDriver createDriver() {
        // Automatically manage ChromeDriver binary
        WebDriverManager.chromedriver().setup();

        // Optional: Chrome options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized"); // start browser maximized
        // options.addArguments("--headless"); // if you want headless mode

        // Create ChromeDriver instance
        WebDriver driver = new ChromeDriver(options);
        return driver;
    }
}

