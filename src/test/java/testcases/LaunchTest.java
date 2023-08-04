package testcases;

import org.testng.annotations.Test;
import pages.Base;
import pages.HomeScreen;

public class LaunchTest extends Base {
    HomeScreen hs;

    @Test
    public void launchAppTest() {
        logger = reports.createTest("Launching the app"); //Tests title in the Extent Report
        System.out.println(("Excel data1: "+excel.getStringData(0, 0, 0)));
        System.out.println(("Excel data2: "+excel.getStringData("Login", 0, 1)));

        logger.info(("Excel data1: "+excel.getStringData(0, 0, 0)));
        logger.info("Excel data2: "+excel.getStringData("Login", 0, 1));

        hs = new HomeScreen(driver);
        hs.enterValueAndValidate("My World!");
        logger.pass("Validation passed"); //Test log in the Extent Report, show with Pass tag
    }

    @Test
    public void launchApp2() {
        logger = reports.createTest("Random test");
        logger.fail("Validation failed");
    }

}
