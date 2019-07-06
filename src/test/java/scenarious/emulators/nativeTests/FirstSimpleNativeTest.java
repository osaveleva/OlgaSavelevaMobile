package scenarious.emulators.nativeTests;

import base.HooksEmulator;
import io.appium.java_client.android.AndroidDriver;
import javafx.scene.input.ScrollEvent;
import org.testng.annotations.Test;

import java.io.IOException;

import static constants.MobileTestingConstants.TITLE1;
import static constants.MobileTestingConstants.TITLE2;
import static org.openqa.selenium.Keys.PAGE_DOWN;
import static org.openqa.selenium.Keys.TAB;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


@Test(groups = "native")
public class FirstSimpleNativeTest extends HooksEmulator {

    public FirstSimpleNativeTest() throws IOException {
        super();
    }

    @Test(description = "Check contact manager application")
    private void contactUs() throws Exception {
        assertTrue(nativeTestBase.contactUs.isDisplayed());
        nativeTestBase.contactUs.click();
        driver().hideKeyboard();
        assertTrue(nativeTestBase.contactName.isDisplayed());
        assertTrue(nativeTestBase.contactEmail.isDisplayed());
        assertTrue(nativeTestBase.contactNaumber.isDisplayed());
        assertTrue(nativeTestBase.contactUsSubmitButton.isDisplayed());
        assertTrue(nativeTestBase.resetPassword.isDisplayed());
    }

    @Test(description = "Reset password")
    private void resetPassword() throws Exception {
        driver().launchApp();
        assertTrue(nativeTestBase.setPassword.isDisplayed());
        nativeTestBase.setPassword.click();
        assertEquals(nativeTestBase.resetTitle1.getText(), TITLE1);
        assertEquals(nativeTestBase.resetTiltle2.getText(), TITLE2);
        driver().hideKeyboard();
        nativeTestBase.submitPassword();
    }
}

