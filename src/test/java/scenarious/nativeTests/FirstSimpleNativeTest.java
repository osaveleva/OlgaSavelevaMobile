package scenarious.nativeTests;

import base.Hooks;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.IOException;

import static constants.MobileTestingConstants.TITLE1;
import static constants.MobileTestingConstants.TITLE2;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


@Test(groups = "native")
public class FirstSimpleNativeTest extends Hooks {

    public FirstSimpleNativeTest() throws IOException {
        super();
    }

    @Test(description = "Check contact manager application")
    private void contactUs() {
        assertTrue(nativeTestBase.contactUs.isDisplayed());
        nativeTestBase.contactUs.click();
        assertTrue(nativeTestBase.crname.isDisplayed());
        assertTrue(nativeTestBase.textcremail.isDisplayed());
        assertTrue(nativeTestBase.textcrcontact.isDisplayed());
        assertTrue(nativeTestBase.crsubmit2.isDisplayed());
        assertTrue(nativeTestBase.crreset2.isDisplayed());
    }

    @Test(description = "Reset password")
    private void resetPassword() {
        assertTrue(nativeTestBase.setPassword.isDisplayed());
        nativeTestBase.setPassword.click();
        assertEquals(nativeTestBase.texttitle1.getText(), TITLE1);
        assertEquals(nativeTestBase.testtiltle2.getText(), TITLE2);
        nativeTestBase.submitPassword();
    }
}

