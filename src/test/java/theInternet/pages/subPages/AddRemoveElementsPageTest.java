package theInternet.pages.subPages;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import theInternet.base.Base;

import static org.testng.Assert.*;

public class AddRemoveElementsPageTest extends Base {
    public AddRemoveElementsPage addRemoveElementsPage;
    private final SoftAssert softAssert = new SoftAssert();

    @BeforeMethod
    private void openAddRemoveElementsPage(){
        addRemoveElementsPage = homePage.openAddRemoveElementsPage();
    }

    @Test
    public void addElementAndCheckThatTheDeleteElementIsVisible(){
        addRemoveElementsPage.addSingleElement();
        assertTrue(addRemoveElementsPage.isAnyDeleteElementsDisplayed());
        softAssert.assertAll();
    }

    @Test
    public void addMultipleElementsAndCheckThatTheDeleteElementAreVisible(){
        addRemoveElementsPage.addMultipleElements(5);
        softAssert.assertEquals(addRemoveElementsPage.getDeleteElementsCount(),5);
    }

    @Test
    public void testDeletingAllDisplayedElements(){
        addRemoveElementsPage.addMultipleElements(6);
        addRemoveElementsPage.deleteAllDisplayedDeleteBtns();
        softAssert.assertEquals(addRemoveElementsPage.getDeleteElementsCount(),0);
    }
}