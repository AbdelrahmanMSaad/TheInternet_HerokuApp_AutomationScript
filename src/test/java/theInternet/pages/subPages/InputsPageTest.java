package theInternet.pages.subPages;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import theInternet.base.Base;

import static org.testng.Assert.*;

public class InputsPageTest extends Base {
    public InputsPage inputsPage;

    private SoftAssert softAssert = new SoftAssert();

    private void openInputsPage(){
        inputsPage = homePage.openInputsPage();
    }

    @Test
    public void testSendingNumbersToTheInputElement(){
        openInputsPage();
        String firstValue = "565", secondValue = "9665", thirdValue = "898771";
        inputsPage.sendTextToNumberInput(firstValue);
        softAssert.assertEquals(inputsPage.getTextInsideNumberInput(),firstValue,"First value is not sent");
        inputsPage.clearNumberInput();
        inputsPage.sendTextToNumberInput(secondValue);
        softAssert.assertEquals(inputsPage.getTextInsideNumberInput(),secondValue,"Second value is not sent");
        inputsPage.clearNumberInput();
        inputsPage.sendTextToNumberInput(thirdValue);
        softAssert.assertEquals(inputsPage.getTextInsideNumberInput(),thirdValue,"Third value is not sent");
        softAssert.assertAll();
    }
}