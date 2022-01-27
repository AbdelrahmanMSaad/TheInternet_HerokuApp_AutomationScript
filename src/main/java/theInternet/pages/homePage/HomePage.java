package theInternet.pages.homePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import theInternet.base.Base;
import theInternet.pages.subPages.*;
import theInternet.pages.subPages.formAuth.FormAuthPage;
import theInternet.utils.Utils;

public class HomePage extends Base {
    protected WebDriver driver;
    @FindBy(partialLinkText = "Add/Remove Elements")
    private WebElement addRemoveElementsButton;

    @FindBy(partialLinkText = "Checkboxes")
    private WebElement checkboxesButton;
    @FindBy(partialLinkText = "Dropdown")
    private WebElement dropdownButton;
    @FindBy(partialLinkText = "File Upload")
    private WebElement fileUploadButton;
    @FindBy(partialLinkText = "Form Authentication")
    private WebElement formAuthButton;
    @FindBy(partialLinkText = "Inputs")
    private WebElement inputsButton;
    @FindBy(partialLinkText = "JavaScript Alerts")
    private WebElement javaScriptAlertButton;
    @FindBy(partialLinkText = "Key Presses")
    private WebElement keyPressesButton;


    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * This method is to open the add remove page
     *
     * @return AddRemoveElementsPage object
     */
    public AddRemoveElementsPage openAddRemoveElementsPage() {
        Utils.waitForElementVisibility(this.driver, addRemoveElementsButton);
        addRemoveElementsButton.click();
        return new AddRemoveElementsPage(this.driver);
    }

    /**
     * This method is to open the check boxes page
     *
     * @return CheckboxesPage object
     */
    public CheckboxesPage openCheckboxesPage() {
        Utils.waitForElementVisibility(this.driver, checkboxesButton);
        this.checkboxesButton.click();
        return new CheckboxesPage(this.driver);
    }

    /**
     * This method is to open the dropdown page
     *
     * @return DropdownPage object
     */
    public DropdownPage openDropdownPage() {
        Utils.waitForElementVisibility(this.driver, dropdownButton);
        this.dropdownButton.click();
        return new DropdownPage(this.driver);
    }

    /**
     * This method is to open File Uplaod Page
     * @return  FileUploadPage object
     */
    public FileUploadPage openFileUploadPage(){
        Utils.waitForElementVisibility(this.driver,fileUploadButton);
        fileUploadButton.click();
        return new FileUploadPage(this.driver);
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

    /**
     * This method is to open the javascript Alerts page
     *
     * @return AlertsPage
     */
    public AlertsPage openAlertsPage() {
        Utils.waitForElementVisibility(this.driver, javaScriptAlertButton);
        javaScriptAlertButton.click();
        return new AlertsPage(this.driver);
    }

    public KeyPressesPage openKeyPressesPage() {
        Utils.waitForElementVisibility(this.driver, keyPressesButton);
        keyPressesButton.click();
        return new KeyPressesPage(this.driver);
    }
}
