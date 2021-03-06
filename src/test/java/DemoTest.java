import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;

import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static org.testng.Assert.assertEquals;
public class DemoTest {

    private WebDriver driver;
    private static String appiumServiceUrl;
    private static AppiumDriverLocalService server;

    @BeforeClass
    public void setup () throws MalformedURLException {
        startAppiumServer();
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "10");
        caps.setCapability("deviceName", "emulator-5555");
        caps.setCapability("browserName", "Chrome");
        caps.setCapability("chromedriverExecutable", System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe");
        caps.setCapability("app", System.getProperty("user.dir") + "/src/test/resources/chrome.apk");
       // driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"),caps);
        driver = new AndroidDriver<>(server.getUrl(),caps);
    }

    private static void startAppiumServer()   {
        server =  AppiumDriverLocalService.buildDefaultService();
        server.start();
        appiumServiceUrl = server.getUrl().toString();

    }

    @Test
    public void testAndroid () {
        String website = "https://www.google.co.in";
        driver.get(website);
        String actualTitle = driver.getTitle();
        assertEquals(actualTitle, "Google");

    }




    @AfterClass(alwaysRun = true)
    public void tearDown () {
        driver.quit();
        server.stop();
    }
}
