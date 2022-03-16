import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;


public class AutomationSampleTest {
    public AndroidDriver<MobileElement> driver;
    public WebDriverWait wait;

    //Elements By
    By userName_field   = By.id("com.dgotlieb.automationsample:id/userName");
    By passWord_field   = By.id("com.dgotlieb.automationsample:id/userPassword");
    By login_btn        = By.id("com.dgotlieb.automationsample:id/loginButton");
    By error_text       = By.id("com.dgotlieb.automationsample:id/errorTV");

    //Set the Desired Capabilities
    @BeforeMethod
    public void setup() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Nexus 4 API 30");
        caps.setCapability("udid", "emulator-5554");
        caps.setCapability("platform","Android");
        caps.setCapability("platformVersion", "11.0");
        caps.setCapability("skipUnlock", "true");
        caps.setCapability("appPackage", "com.dgotlieb.automationsample");
        caps.setCapability("appActivity", "com.dgotlieb.automationsample.MainActivity");
        driver = new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), caps);
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void basicTest() throws InterruptedException {
        //Input Username and Password
        wait.until(ExpectedConditions.visibilityOfElementLocated(userName_field)).sendKeys("userName");
        wait.until(ExpectedConditions.visibilityOfElementLocated(passWord_field)).sendKeys("password");

        //Click Login
        wait.until(ExpectedConditions.visibilityOfElementLocated(login_btn)).click();

        //assertion: Show an error message
        String error_mgs = wait.until(ExpectedConditions.visibilityOfElementLocated(error_text)).getText();
        Assert.assertEquals(error_mgs, "Wrong username or password");
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
