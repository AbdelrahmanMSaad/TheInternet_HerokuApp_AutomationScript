package theInternet.pages.subPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import theInternet.base.Base;
import theInternet.utils.Utils;

public class CheckboxesPage extends Base {
    protected WebDriver driver;
    @FindBy(xpath = "(//input)[1]")
    private WebElement firstCheckbox;
    @FindBy(xpath = "(//input)[2]")
    private WebElement secondCheckbox;

    public CheckboxesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * This method is to click on the first check box
     */
    public void clickOnFirstCheckBox() {
        Utils.waitForElementToBeClickable(this.driver, firstCheckbox);
        firstCheckbox.click();
    }

    /**
     * This method is to check if the first check box is checked or not
     *
     * @return boolean
     */
    public boolean isFirstCheckboxChecked() {
        Utils.waitForElementToBeClickable(this.driver, firstCheckbox);
        return firstCheckbox.isSelected();
    }

    /**
     * This method is to click on the second check box
     */
    public void clickOnSecondCheckBox() {
        Utils.waitForElementToBeClickable(this.driver, secondCheckbox);
        secondCheckbox.click();
    }

    /**
     * This method is to check if the second check box is checked or not
     *
     * @return boolean
     */
    public boolean isSecondCheckboxChecked() {
        Utils.waitForElementToBeClickable(this.driver, secondCheckbox);
        return secondCheckbox.isSelected();
    }
}
