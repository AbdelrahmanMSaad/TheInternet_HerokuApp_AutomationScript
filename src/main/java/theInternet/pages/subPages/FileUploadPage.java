package theInternet.pages.subPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import theInternet.base.Base;
import theInternet.utils.Utils;

public class FileUploadPage extends Base {
    protected WebDriver driver;

    public FileUploadPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By inputFieldBy = By.id("file-upload");
    private final By uploadButton = By.id("file-submit");
    private final By uploadedFilesSection = By.id("uploaded-files");

    /**
     * This method is to send the file absolute path to the input field
     *
     * @param fileAbsolutePath String
     */
    public void sendFilePathToInputField(String fileAbsolutePath) {
        Utils.waitForElementVisibility(this.driver, this.driver.findElement(inputFieldBy));
        driver.findElement(inputFieldBy).sendKeys(fileAbsolutePath);
    }

    /**
     * This method is to click on the upload button
     */
    public void clickOnUploadButton() {
        Utils.waitForElementToBeClickable(this.driver, this.driver.findElement(uploadButton));
        this.driver.findElement(uploadButton).click();
    }

    /**
     * This method is the get the name of the uploaded file
     *
     * @return String
     */
    public String getTheUploadedFileName() {
        Utils.waitForElementVisibility(this.driver, this.driver.findElement(uploadedFilesSection));
        return this.driver.findElement(uploadedFilesSection).getText();
    }

}
