package scenarious;


import base.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class FirstSimpleTest extends Hooks {
    protected FirstSimpleTest() throws IOException {
        super();
    }

  /*  @Test//should be for native phone
    public void firstMethod() throws Exception {
        String app_package_name = "in.smartappcart.contactmanager:id/";
        By add_btn = By.id(app_package_name + "ll1ss");
        driver().findElement(add_btn).isDisplayed();
        driver().findElement(add_btn).click();
        System.out.println("Simplest Appuim test done");
    }*/

    @Test
    public void webTest() throws Exception {
        driver().get(SUT);
        driver().getTitle();
        System.out.println(driver().getTitle());
        driverWait().until(ExpectedConditions.urlToBe(SUT+"/"));
        System.out.println("Site opening done");
    }

}
