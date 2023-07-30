package utility;

import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Helper {


    public static String takeScreenshot(AndroidDriver driver) {
        String screenShotPath = System.getProperty("user.dir")+"/Screenshots/Report"+getCurrentDateTime();
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File(screenShotPath));
            System.out.println("Screenshot Captured");
        } catch (Exception e) {
            System.out.println("Couldn't capture: "+e.getMessage());
        }
        return screenShotPath;
    }

    public static String getCurrentDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy_hh_mm_ssaa");
        String destFile = dateFormat.format(new Date())+".png";
        return  destFile;
    }
}
