package scenarious.nativeTests;

import base.Hooks;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.IOException;

public class FirstSimpleNativeTest {
    @Test(groups = "native")
    public class FirstSimpleTest extends Hooks {
        protected FirstSimpleTest() throws IOException {
            super();
        }

        @Test(description = "Check contact manager application")
        private void applicationTest() throws Exception {
            String app_package_name = "in.smartappcart.contactmanager:id/";
            By add_btn = By.id(app_package_name + "ll1ss");
            driver().findElement(add_btn).isDisplayed();
            driver().findElement(add_btn).click();
        }
    }
}
