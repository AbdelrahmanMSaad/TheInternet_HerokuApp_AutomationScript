package theInternet.pages.homePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import theInternet.base.Base;
import theInternet.pages.subPages.formAuth.FormAuthPage;
import theInternet.pages.subPages.InputsPage;

public class HomePage extends Base {
    protected WebDriver driver;
    private WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(this.driver, 10);
    }

    @FindBy(partialLinkText = "Form Authentication")
    private WebElement formAuthButton;

    @FindBy(partialLinkText = "Inputs")
    private WebElement inputsButton;

    /**
     * This method is to open the form authentication page
     * @return FormAuthPage object
     */
    public FormAuthPage openFormAuthPage(){
        this.waitForElementVisibility(this.formAuthButton);
        this.formAuthButton.click();
        return new FormAuthPage(this.driver);
    }

    /**
     * This method is to open the inputs page
     * @return  InputsPage object
     */
    public InputsPage openInputsPage() {
        this.waitForElementVisibility(inputsButton);
        inputsButton.click();
        return new InputsPage(this.driver);
    }

    private void waitForElementVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    private void waitForElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
