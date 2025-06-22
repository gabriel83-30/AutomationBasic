package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import propertyUtility.PropertyUtility;

import static extentUtility.ExtentHelper.*;

public class BaseTest {

    WebDriver driver;
    public PropertyUtility propertyUtility;
    public String testName;


    @BeforeSuite
    public void initializeReport(){
        initiateReport();

    }
    @BeforeMethod
    // facem o metaoda care sa deschida un browser
    public void openBrowser() {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
        testName = this.getClass().getSimpleName();
        createTest(testName);
    }

    @AfterMethod
    public void closeBrowser(ITestResult results) {
        if(results.getStatus() == ITestResult.FAILURE){
            String errorMessage = results.getThrowable().getMessage();
            logFailScreenshot(driver, errorMessage);
        }
        if(driver!= null){
            driver.quit();
        }
        finishTest(testName);
    }

    @AfterSuite
    public  void finalizeReport(){
        generateReport();
    }

}
