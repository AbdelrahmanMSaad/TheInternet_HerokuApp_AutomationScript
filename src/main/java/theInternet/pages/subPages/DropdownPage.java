package theInternet.pages.subPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import theInternet.base.Base;
import theInternet.utils.Utils;

public class DropdownPage extends Base {
    protected WebDriver driver;

    public DropdownPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "dropdown")
    private WebElement dropdownList;

    /**
     * This method is to select an option from the dropdown list via text
     *
     * @param option String
     */
    public void selectFromTheDropdownList(String option) {
        try{
            Utils.waitForElementVisibility(this.driver, dropdownList);
            getSelectInstanceFromTheDropdownList().selectByVisibleText(option);
        }catch (Exception e){
            System.out.println("The option doesn't exist");
        }
    }

    /**
     * This is to get the selected option
     *
     * @return String
     */
    public String getSelectedOption() {
        Utils.waitForElementVisibility(this.driver, dropdownList);
        return getSelectInstanceFromTheDropdownList().getFirstSelectedOption().getText();
    }

    /**
     * This method is to get a select instance for the dropdown list
     *
     * @return Select object
     */
    private Select getSelectInstanceFromTheDropdownList() {
        return new Select(dropdownList);
    }
}
