package testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pages.Base;
import pages.HomeScreen;

public class Launch extends Base {

    @Test
    public void launchApp() {
        logger = reports.createTest("Launching the app");
        logger.info("Starting Application");
        logger.info("Excel data1: "+excel.getStringData(0, 0, 0));
        logger.info("Excel data2: "+excel.getStringData("Login", 0, 1));
        HomeScreen hs = PageFactory.initElements(driver, HomeScreen.class);
        hs.enterValueAndValidate("My World!");
        logger.pass("Validation passed");
    }

    @Test
    public void launchApp2() {
        logger = reports.createTest("Random test");
        logger.fail("Validation failed");
    }

}
