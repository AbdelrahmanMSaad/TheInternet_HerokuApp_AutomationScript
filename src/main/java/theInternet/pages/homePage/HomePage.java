package theInternet.pages.homePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import theInternet.base.Base;
import theInternet.pages.subPages.DropdownPage;
import theInternet.pages.subPages.InputsPage;
import theInternet.pages.subPages.formAuth.FormAuthPage;
import theInternet.utils.Utils;

public class HomePage extends Base {
    protected WebDriver driver;
    private WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(this.driver, 10);
    }

    @FindBy(partialLinkText = "Dropdown")
    private WebElement dropdown;

    @FindBy(partialLinkText = "Form Authentication")
    private WebElement formAuthButton;

    @FindBy(partialLinkText = "Inputs")
    private WebElement inputsButton;

    /**
     * This method is to open the dropdown page
     *
     * @return DropdownPage object
     */
    public DropdownPage openDropdownPage() {
        Utils.waitForElementVisibility(this.driver, dropdown);
        this.dropdown.click();
        return new DropdownPage(this.driver);
    }

    /**
     * This method is to open the form authentication page
     *
     * @return FormAuthPage object
     */
    public FormAuthPage openFormAuthPage() {
        Utils.waitForElementVisibility(this.driver, formAuthButton);
        this.formAuthButton.click();
        return new FormAuthPage(this.driver);
    }

    /**
     * This method is to open the inputs page
     *
     * @return InputsPage object
     */
    public InputsPage openInputsPage() {
        Utils.waitForElementVisibility(this.driver, inputsButton);
        inputsButton.click();
        return new InputsPage(this.driver);
    }
}
