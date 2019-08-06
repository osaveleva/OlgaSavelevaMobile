package scenarious.mobileTests.nativeTests;

import base.Hooks;
import org.testng.annotations.Test;

import java.io.IOException;

import static constants.MobileTestingConstants.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


@Test(groups = "native")
public class NativeTest extends Hooks {

    public NativeTest() throws IOException {
        super();
    }

    @Test(description = "Check contact manager application", groups = "device")
    private void contactUsDevice() throws Exception {
        driver().launchApp();
        assertTrue(contactManagerPage.contactUs.isDisplayed());
        contactManagerPage.contactUs.click();
        assertTrue(contactManagerPage.contactName.isDisplayed());
        assertTrue(contactManagerPage.contactEmail.isDisplayed());
        assertTrue(contactManagerPage.contactNaumber.isDisplayed());
        assertTrue(contactManagerPage.contactUsSubmitButton.isDisplayed());
        assertTrue(contactManagerPage.resetPassword.isDisplayed());
    }

    @Test(description = "Reset password", groups = "device")
    private void resetPasswordDevice() throws Exception {
        //It's a workaround as I do not know how to turn back on application's home page
        driver().launchApp();
        assertTrue(contactManagerPage.setPassword.isDisplayed());
        contactManagerPage.setPassword.click();
        assertEquals(contactManagerPage.resetTitle1.getText(), TITLE1.getRecord());
        assertEquals(contactManagerPage.resetTiltle2.getText(), TITLE2.getRecord());
        contactManagerPage.submitPassword();
    }

    @Test(description = "Check contact manager application", groups = "emulator")
    private void contactUsEmulator() throws Exception {
        assertTrue(contactManagerPage.contactUs.isDisplayed());
        contactManagerPage.contactUs.click();
        //It's a workaround. As keyboard is visible on emulator and part of the screen is not available cause of that
        driver().hideKeyboard();
        assertTrue(contactManagerPage.contactName.isDisplayed());
        assertTrue(contactManagerPage.contactEmail.isDisplayed());
        assertTrue(contactManagerPage.contactNaumber.isDisplayed());
        assertTrue(contactManagerPage.contactUsSubmitButton.isDisplayed());
        assertTrue(contactManagerPage.resetPassword.isDisplayed());
    }

    @Test(description = "Contact Manager: Reset password", groups = "emulator")
    private void resetPasswordEmulator() throws Exception {
        //It's a workaround as I do not know how to turn back on application's home page
        driver().launchApp();
        assertTrue(contactManagerPage.setPassword.isDisplayed());
        contactManagerPage.setPassword.click();
        assertEquals(contactManagerPage.resetTitle1.getText(), TITLE1.getRecord());
        assertEquals(contactManagerPage.resetTiltle2.getText(), TITLE2.getRecord());
        driver().hideKeyboard();
        contactManagerPage.submitPassword();
    }
}

