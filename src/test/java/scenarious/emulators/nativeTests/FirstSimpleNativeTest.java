package scenarious.emulators.nativeTests;

import base.HooksEmulator;
import org.testng.annotations.Test;

import java.io.IOException;

import static constants.MobileTestingConstants.TITLE1;
import static constants.MobileTestingConstants.TITLE2;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


@Test(groups = "native")
public class FirstSimpleNativeTest extends HooksEmulator {

    public FirstSimpleNativeTest() throws IOException {
        super();
    }

    @Test(description = "Check contact manager application")
    private void contactUs() throws Exception {
        assertTrue(contactManagerPage.contactUs.isDisplayed());
        contactManagerPage.contactUs.click();
        driver().hideKeyboard();
        assertTrue(contactManagerPage.contactName.isDisplayed());
        assertTrue(contactManagerPage.contactEmail.isDisplayed());
        assertTrue(contactManagerPage.contactNaumber.isDisplayed());
        assertTrue(contactManagerPage.contactUsSubmitButton.isDisplayed());
        assertTrue(contactManagerPage.resetPassword.isDisplayed());
    }

    @Test(description = "Contact Manager: Reset password")
    private void resetPassword() throws Exception {
        driver().launchApp();
        assertTrue(contactManagerPage.setPassword.isDisplayed());
        contactManagerPage.setPassword.click();
        assertEquals(contactManagerPage.resetTitle1.getText(), TITLE1);
        assertEquals(contactManagerPage.resetTiltle2.getText(), TITLE2);
        driver().hideKeyboard();
        contactManagerPage.submitPassword();
    }
}

