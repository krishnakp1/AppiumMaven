package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomeScreen {

    AndroidDriver driver;

    public HomeScreen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"Btn1\"]")
    WebElement enterValueBtn;

    @FindBy(id = "com.code2lead.kwad:id/Et1")
    WebElement enterValueTextInput;

    @FindBy(id = "com.code2lead.kwad:id/Btn1")
    WebElement submitBtn;

    @FindBy(id = "com.code2lead.kwad:id/Tv1")
    WebElement previewText;

    public void enterValueAndValidate(String inputText) {
        enterValueBtn.click();
        enterValueTextInput.sendKeys(inputText);
        submitBtn.click();
        System.out.println("Clicked on Submit");

        Assert.assertEquals(previewText.getText(), inputText);
        System.out.println("Text Preview Matches!");
    }
}
