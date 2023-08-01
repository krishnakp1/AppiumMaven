package utility;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DeviceFactory {

    public static AndroidDriver initialize(String appPath) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.APP, appPath);
        caps.setCapability(MobileCapabilityType.NO_RESET, true);
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Android");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        System.out.println("Driver initialized");
        System.out.println("driver: "+driver);
        return driver;
    }

    public static void quitDriver(AppiumDriver driver) {
        System.out.println("About to quit driver");
        driver.quit();
        System.out.println("Driver quit performed");
    }
}
