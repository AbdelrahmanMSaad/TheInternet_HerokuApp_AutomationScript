package theInternet.pages.subPages;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import theInternet.base.Base;

public class DropdownPageTest extends Base {
    private final SoftAssert softAssert = new SoftAssert();
    public DropdownPage dropdownPage;

//    private void openDropdownPage(){
//        dropdownPage = homePage.openDropdownPage();
//    }

    @BeforeMethod
    private void openDrpodownPage() {
        dropdownPage = homePage.openDropdownPage();
    }

    @Test
    public void testSelectingOptionsFromTheDropdownList() {
//        openDropdownPage();
        String optionOne = "Option 1";
        dropdownPage.selectFromTheDropdownList(optionOne);
        softAssert.assertEquals(dropdownPage.getSelectedOption(), optionOne);
        String optionTwo = "Option 2";
        dropdownPage.selectFromTheDropdownList(optionTwo);
        softAssert.assertEquals(dropdownPage.getSelectedOption(), optionTwo);
        softAssert.assertAll();
    }

    @Test
    public void testSelectingInvalidOptionFromTheDropdownList() {
//        openDropdownPage();
        String optionOne = "Option1";
        dropdownPage.selectFromTheDropdownList(optionOne);
        softAssert.assertNotEquals(dropdownPage.getSelectedOption(), optionOne);
        softAssert.assertAll();
    }
}