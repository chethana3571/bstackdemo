package Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.util.Assert;

public class WaitUtils {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com/practice-test-login/");
    }

    @Test
    public void loginTestUsingWaitUtils() {

        WaitUtils.waitForVisibility(driver, By.id("username"), 10)
                .sendKeys("student");

        WaitUtils.waitForVisibility(driver, By.id("password"), 10)
                .sendKeys("Password123");

        WaitUtils.waitForClickable(driver, By.id("submit"), 10)
                .click();

        boolean titleStatus = WaitUtils.waitForTitle(driver, "Logged In", 10);
        Assert.assertTrue(titleStatus, "Login failed");
    }

    private static boolean waitForTitle(WebDriver driver2, String string, int i) {
		// TODO Auto-generated method stub
		return false;
	}

	private static Object waitForVisibility(WebDriver driver2, By id, int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
