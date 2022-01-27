package theInternet.pages.subPages;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import theInternet.base.Base;

public class FileUploadPageTest extends Base {
    public FileUploadPage fileUploadPage;
    private final Assertion assertion = new Assertion();

    @BeforeMethod
    public void openFileUploadPage(){
        this.fileUploadPage = homePage.openFileUploadPage();
    }

    @Test
    public void testUploadingFile(){
        String fileAbsolutePath = System.getProperty("user.dir") + "\\src\\main\\resources\\fileUpload.jpg";
        String fileName = "fileUpload.jpg";
        System.out.println(fileAbsolutePath);
        fileUploadPage.sendFilePathToInputField(fileAbsolutePath);
        fileUploadPage.clickOnUploadButton();
        assertion.assertEquals(fileUploadPage.getTheUploadedFileName(),fileName,"The uploaded file is incorrect");
    }

}