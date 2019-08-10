package scenarious.mobilecloud.nativeTests;

import base.Hooks;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


@Test(groups = {"native"})
public class CloudNativeTest extends Hooks {

    public CloudNativeTest() throws IOException {
        super();
    }

    @Test(description = "Check calculator application")
    private void calculatorAdd() {
        int result = Integer.valueOf(calculator.digit2.getText()) + Integer.valueOf(calculator.digit5.getText());
        assertTrue(calculator.digit2.isDisplayed());
        calculator.digit2.click();
        assertEquals(calculator.formula.getText(), calculator.digit2.getText());
        calculator.add.click();
        calculator.digit5.click();
        calculator.eq.click();
        assertEquals(calculator.formula.getText(), String.valueOf(result));
    }
}

