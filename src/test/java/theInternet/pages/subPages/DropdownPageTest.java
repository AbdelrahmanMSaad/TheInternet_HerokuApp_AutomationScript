package theInternet.pages.subPages;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import theInternet.base.Base;

import static org.testng.Assert.*;

public class DropdownPageTest extends Base {
    public DropdownPage dropdownPage;

    private SoftAssert softAssert = new SoftAssert();

    @BeforeMethod
    public void beforeMethod(){
        super.beforeMethod();
        dropdownPage = homePage.openDropdownPage();
    }

    @Test
    public void testSelectingOptionsFromTheDropdownList(){
        String optionOne = "Option 1";
        dropdownPage.selectFromTheDropdownList(optionOne);
        softAssert.assertEquals(dropdownPage.getSelectedOption(),optionOne);
        String optionTwo = "Option 2";
        dropdownPage.selectFromTheDropdownList(optionTwo);
        softAssert.assertEquals(dropdownPage.getSelectedOption(),optionTwo);
        softAssert.assertAll();
    }

    @Test
    public void testSelectingInvalidOptionFromTheDropdownList(){
        String optionOne = "Option1";
        dropdownPage.selectFromTheDropdownList(optionOne);
        softAssert.assertNotEquals(dropdownPage.getSelectedOption(),optionOne,"Invalid option or option doesn't exist");
        softAssert.assertAll();
    }
}