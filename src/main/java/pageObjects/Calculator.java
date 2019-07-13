package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import setup.DriverSetup;

import java.io.IOException;

import static constants.MobileTestingConstants.PASSWORD;

/**
 * PageObject for Calculator application
 */

public class Calculator extends DriverSetup {
    public Calculator() throws IOException {
        super();
    }

    @FindBy(id = "com.google.android.calculator:id/digit_2")
    public WebElement digit2;

    @FindBy(id = "com.google.android.calculator:id/digit_5")
    public WebElement digit5;

    @FindBy(id = "com.google.android.calculator:id/eq")
    public WebElement eq;

    @FindBy(className = "android.widget.TextView")
    public WebElement formula;

    @FindBy(id = "com.google.android.calculator:id/op_add")
    public WebElement add;
}
