package base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import setup.DriverSetup;

import java.io.IOException;

import static constants.MobileTestingConstants.PASSWORD;

public class NativeTestBase extends DriverSetup {
    public NativeTestBase() throws IOException {
        super();
    }

    @FindBy(id = "in.smartappcart.contactmanager:id/ll2")
    public WebElement contactUs;

    @FindBy(id = "in.smartappcart.contactmanager:id/crname")
    public WebElement crname;

    @FindBy(id = "in.smartappcart.contactmanager:id/textcrcontact")
    public WebElement textcrcontact;

    @FindBy(id = "in.smartappcart.contactmanager:id/textcremail")
    public WebElement textcremail;

    @FindBy(id = "in.smartappcart.contactmanager:id/crsubmit2")
    public WebElement crsubmit2;

    @FindBy(id = "in.smartappcart.contactmanager:id/crreset2")
    public WebElement crreset2;

    @FindBy(id = "in.smartappcart.contactmanager:id/ll1")
    public WebElement setPassword;

    @FindBy(id = "in.smartappcart.contactmanager:id/texttitle1")
    public WebElement texttitle1;

    @FindBy(id = "in.smartappcart.contactmanager:id/texttitle2")
    public WebElement testtiltle2;

    @FindBy(id = "in.smartappcart.contactmanager:id/texttitle2")
    private WebElement crpass;

    @FindBy(id = "in.smartappcart.contactmanager:id/crsubmit")
    private WebElement submitPasswordButton;


    public void submitPassword(){
        crpass.sendKeys(PASSWORD);
        submitPasswordButton.click();
    }

    public String titleValue(WebElement element){
        return element.getText();
    }
}
