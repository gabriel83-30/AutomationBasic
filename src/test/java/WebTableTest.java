import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class WebTableTest {

    WebDriver driver;
    public int initialTableSize = 0;
    String firstName = "Popescu";
    String lastName = "Florin";
    String email = "test@test.com";
    String age = "25";
    String salary = "15000";
    String department = "Testing Automation";


    @Test
    public void webTableTest() {
        openBrowser();
        chooseMenu();
        chooseSubMenu();
        getTableSize();
        clickToAddNewRecord();
        fillFormValues();
        validateThatRecords();
    }

    // facem o metoda care deschide un browser
    public void openBrowser() {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();


    }

    // facem o metoda care alege un meniu
    public void chooseMenu() {
        // Identificam meniul dorit si facem click pe el folosind xpath
        WebElement elementsMenu = driver.findElement(By.xpath("//h5[text()='Elements']"));
        // Facem scroll pana in dreptul elementului pe care vrem sa-l actionam
        scrollToElement(elementsMenu);
        // Acum facem click pe meniul de mai sus
        elementsMenu.click();
    }

    // facem o metoda care face scroll
    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    //    // facem o metoda care sa selecteze sub-meniul
    public void chooseSubMenu() {
        WebElement elementSubMenu = driver.findElement(By.xpath("//span[text()='Web Tables']"));
        elementSubMenu.click();

    }


    public int getTableSize() {
        List<WebElement> tableRowsList = driver.findElements(By.xpath("//div[@class = 'rt-tbody']/div/div[@class='rt-tr -odd' or @class='rt-tr -even']"));
        initialTableSize = tableRowsList.size();
        System.out.println("Numarul initial de randuri este " + initialTableSize);
        return initialTableSize;

    }

    // facem o metoda care sa faca click pe adaugare rand nou in tabel
    public void clickToAddNewRecord() {
        WebElement addNewRecordBtn = driver.findElement(By.id("addNewRecordButton"));
        addNewRecordBtn.click();

    }

    // facem o metoda care sa compleze toate campurile din formular
    public void fillFormValues() {
        WebElement firstNameField = driver.findElement(By.id("firstName"));
        firstNameField.sendKeys(firstName);
        WebElement lastNameField = driver.findElement(By.id("lastName"));
        lastNameField.sendKeys(lastName);
        WebElement userEmailField = driver.findElement(By.id("userEmail"));
        userEmailField.sendKeys(email);
        WebElement ageField = driver.findElement(By.id("age"));
        ageField.sendKeys(age);
        WebElement salaryField = driver.findElement(By.id("salary"));
        salaryField.sendKeys(salary);
        WebElement departmentField = driver.findElement(By.id("department"));
        departmentField.sendKeys(department);
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

    }

    // facem o metoda care sa valideze ce am adaugat, o intrare noua in tabel si sa verifice valorile pe care le-am dat

    public void validateThatRecords() {
        List<WebElement> tableRowsList = driver.findElements(By.xpath("//div[@class = 'rt-tbody']/div/div[@class='rt-tr -odd' or @class='rt-tr -even']"));
        Assert.assertTrue(tableRowsList.size() > initialTableSize, "There are no new entries in the table! , Initial table size: " + initialTableSize +
                " is the same with actual table size: " + tableRowsList.size());
        String actualTableValues = tableRowsList.get(tableRowsList.size() - 1).getText();
        System.out.println("New record values are: " + actualTableValues);
        Assert.assertTrue(actualTableValues.contains(firstName), "First name value isn't correct, expected firstname: " + firstName);
        Assert.assertTrue(actualTableValues.contains(lastName), "First name value isn't correct, expected firstname: " + lastName);
        Assert.assertTrue(actualTableValues.contains(email), "Email value isn't correct, expected email: " + email);
        Assert.assertTrue(actualTableValues.contains(age), "Age value isn't correct, expected age value:" + age);
        Assert.assertTrue(actualTableValues.contains(salary), "Salary value isn't correct, expected salary: " + salary);
        Assert.assertTrue(actualTableValues.contains(department), "Department name value isn't correct, expected firstname: " + department);

    }
}

// Homework : site-ul demoqa.com -> elments -> check box.











