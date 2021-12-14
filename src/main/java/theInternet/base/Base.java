package theInternet.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import theInternet.pages.subPages.DropdownPage;
import theInternet.pages.homePage.HomePage;
import theInternet.utils.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {
    protected WebDriver driver;

    private File file;
    private FileInputStream fileInputStream;
    private Properties properties;

    private String browser;

    private  String uRL;

    public HomePage homePage;

    public void initializeConfigurations(){
        file = new File(Utils.getConfigFilePath());
        try {
            fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        properties = new Properties();
        try {
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        browser = properties.getProperty("browser");
        uRL = properties.getProperty("URL");
    }

    /**
     *This method is to open the home page
     * @return  HomePage Object
     */
    public HomePage openHomePage(){
        if(browser.equalsIgnoreCase("chrome")){
            driver = Utils.openChrome();
        }else if(browser.equalsIgnoreCase("firefox")){
            driver = Utils.openFirefox();
        }
        //open the website
        driver.get(uRL);

        //give the driver 10 seconds implicit wait
        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return new HomePage(this.driver);
    }
//
//    public static void main(String[] args) {
//        Base base = new Base();
//        base.initializeConfigurations();
//        HomePage homePage = base.openHomePage();
//        DropdownPage dropdownPage = homePage.openDropdownPage();
//        String option = "Option 2";
//        dropdownPage.selectFromTheDropdownList(option);
//        System.out.println(dropdownPage.getSelectedOption());
//    }

    /**
     * This method is to close the current tab
     */
    public void closeCurrentTab() {
        this.driver.close();
    }

    /**
     * This method is to terminate the driver
     */
    public void tearDown() {
        this.driver.quit();
    }

    @BeforeSuite
    public void beforeSuite() {

    }

    @BeforeTest
    public void beforeTest() {
        this.initializeConfigurations();
    }

    @BeforeClass
    public void beforeClass() {
    }

    @BeforeMethod
    public void beforeMethod() {
        this.homePage = this.openHomePage();
    }

    @AfterMethod
    public void afterMethod() {
        this.closeCurrentTab();
    }

    @AfterClass
    public void afterClass() {

    }

    @AfterTest
    public void afterTest() {
        this.tearDown();
    }

    @AfterSuite
    public void afterSuite() {

    }
}
