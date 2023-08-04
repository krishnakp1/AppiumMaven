package pages;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.appium.java_client.android.AndroidDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;
import utility.ConfigDataProvider;
import utility.DeviceFactory;
import utility.ExcelDataProvider;
import utility.Helper;
import java.io.File;
import java.net.MalformedURLException;

public class Base {
    public AndroidDriver driver;
    public ConfigDataProvider config;
    public ExcelDataProvider excel;
    public ExtentReports reports;
    public ExtentTest logger;


    @BeforeSuite
    public void setUpSuite() {
        Reporter.log("Starting the activity", true);
        config = new ConfigDataProvider();
        excel = new ExcelDataProvider();
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(new File(System.getProperty("user.dir")+"/Reports/ExtentReport"+Helper.getCurrentDateTime()+".html"));
        reports = new ExtentReports();
        reports.attachReporter(sparkReporter);
        Reporter.log("Ending the activity", true);
    }

    @Parameters({"appPath", "env", "tags", "url"})
    @BeforeClass
    public void setUp(String appPath, String env, String tags, String url) throws MalformedURLException {
//        System.out.println("App Path: "+config.getDataFromConfig("appPath"));
//        driver = DeviceFactory.initialize(config.getDataFromConfig("appPath"));
        System.out.println("App path: " + appPath);
        System.out.println("Env: "+env);
        System.out.println("Tags: "+tags);
        System.out.println("Url: "+url);
        driver = DeviceFactory.initialize(appPath);
    }

    @AfterClass
    public void tearDown() {
        DeviceFactory.quitDriver(driver);
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.takeScreenshot(driver)).build());
        }
        else if (result.getStatus() == ITestResult.SUCCESS) {
            logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.takeScreenshot(driver)).build());
        }
     }

    @AfterSuite
    public void generateReport() {
        reports.flush();
    }
}
