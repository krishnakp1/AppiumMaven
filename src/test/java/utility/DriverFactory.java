package utility;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DriverFactory {

    public static AndroidDriver initialize(String appPath) throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options()
                .setApp(appPath)
                .setNoReset(true);
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
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
