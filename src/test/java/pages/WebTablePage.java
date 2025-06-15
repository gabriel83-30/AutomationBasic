package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class WebTablePage extends BasePage {

    // locatori specifici
    private By pageTitle = By.id("//h1[@class]");
    private By tableRowsList = (By.xpath("//div[@class = 'rt-tbody']/div/div[@class='rt-tr -odd' or @class='rt-tr -even']"));
    private By addNewRecordBtn = By.id("addNewRecordButton");
    private By firstNameField = By.id("firstName");
    private By lastNameField = By.id("lastName");
    private By userEmailField = By.id("userEmail");
    private By ageField = By.id("age");
    private By salaryField = By.id("salary");
    private By departmentField = By.id("department");
    private By submitButton = By.id("submit");

    public int initialTableSize = 0;
    String firstName = "Popescu";
    String lastName = "Florin";
    String email = "test@test.com";
    String age = "25";
    String salary = "15000";
    String department = "Testing Automation";

    public WebTablePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void isPageLoaded() {
        Assert.assertEquals(elementMethods.getTextFromElement(pageTitle),
                "Web Tables", "Page is not loaded properly");
    }


    public void webTablePageFlow() {
        getTableSize();
        clickToAddNewRecord();
        fillFormValues();
        validateThatRecords();
    }

    public int getTableSize() {
        initialTableSize = elementMethods.getElements(tableRowsList).size();
        System.out.println("Numarul initial de randuri este " + initialTableSize);
        return initialTableSize;
    }

    public void clickToAddNewRecord() {
        elementMethods.clickElement(addNewRecordBtn);
    }

    // facem o metoda care sa compleze toate campurile din formular
    public void fillFormValues() {

        elementMethods.fillElement(firstNameField, firstName);
        elementMethods.fillElement(lastNameField, lastName);
        elementMethods.fillElement(userEmailField, email);
        elementMethods.fillElement(ageField, age);
        elementMethods.fillElement(salaryField, salary);
        elementMethods.fillElement(departmentField,department);
        elementMethods.clickElement(submitButton);

    }

    // facem o metoda care sa valideze ce am adaugat, o intrare noua in tabel si sa verifice valorile pe care le-am dat

    public void validateThatRecords() {
        Assert.assertTrue(elementMethods.getElements(tableRowsList).size() > initialTableSize, "There are no new entries in the table! , Initial table size: "
                + initialTableSize + " is the same with actual table size: " + elementMethods.getElements(tableRowsList).size());
        String actualTableValues = elementMethods.getElements(tableRowsList).get(elementMethods.getElements(tableRowsList).size() - 1).getText();
        System.out.println("New record values are: " + actualTableValues);
        Assert.assertTrue(actualTableValues.contains(firstName), "First name value isn't correct, expected firstname: " + firstName);
        Assert.assertTrue(actualTableValues.contains(lastName), "First name value isn't correct, expected firstname: " + lastName);
        Assert.assertTrue(actualTableValues.contains(email), "Email value isn't correct, expected email: " + email);
        Assert.assertTrue(actualTableValues.contains(age), "Age value isn't correct, expected age value:" + age);
        Assert.assertTrue(actualTableValues.contains(salary), "Salary value isn't correct, expected salary: " + salary);
        Assert.assertTrue(actualTableValues.contains(department), "Department name value isn't correct, expected firstname: " + department);

    }
}
