package theInternet.pages.subPages;

import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import theInternet.base.Base;

import static org.testng.Assert.*;

public class KeyPressesPageTest extends Base {
    private final SoftAssert softAssert = new SoftAssert();
    protected KeyPressesPage keyPressesPage;

    @BeforeMethod
    public void openKeyPressesPage(){
        keyPressesPage = homePage.openKeyPressesPage();
    }

    @Test
    public void testSendingTextToTheInput(){
        String text = "a";
        keyPressesPage.sendKeysToKeyPressesInput(text);
        softAssert.assertEquals(keyPressesPage.getTextFromTheResult(), keyPressesPage.getTheBasicResultText()+text.toUpperCase());
        softAssert.assertAll();
    }

}