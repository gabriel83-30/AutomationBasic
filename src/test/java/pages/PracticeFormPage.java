package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PracticeFormPage extends BasePage {

    // locatori specifici paginii
    private By pageTitle = By.xpath("//h1[@class]");
    private By firstNameField = By.id("firstName");
    private By lastNameField = By.id("lastName");
    private By emailField = By.id("userEmail");
    private By genderMale = By.xpath("//label[@for='gender-radio-1']");
    private By genderFemale = By.xpath("//label[@for='gender-radio-2']");
    private By genderOther = By.xpath("//label[@for='gender-radio-3']");
    private By mobilePhoneField = By.id("userNumber");
    private By dateOfBirthInput = By.id("dateOfBirthInput");
    private By monthOfBirthLocator = By.xpath("//select[@class='react-datepicker__month-select']");
    private By yearOfBirthLocator = By.xpath("//select[@class='react-datepicker__year-select']");
    private By dayOfBirthListLocator = By.xpath("//div[contains(@class,'react-datepicker__day')]");
    private By subjectInputlocator = By.id("subjectsInput");
    private By sportHobbyLocator = By.xpath("//label[@for='hobbies-checkbox-1']");
    private By readHobbyLocator = By.xpath("//label[@for='hobbies-checkbox-2']");
    private By musicHobbyLocator = By.xpath("//label[@for='hobbies-checkbox-3']");
    private By uploadFileLocator = By.id("uploadPicture");
    private By addressFieldLocator = By.id("currentAddress");
    private By stateInputLocator = By.id("react-select-3-input");
    private By cityInputLocator = By.id("react-select-4-input");
    private By submitButtonLocator = By.id("submit");
    private By submitTableKeysLocator = By.xpath("//tbody//td[1]");
    private By submitTableValuesLocator = By.xpath("//tbody//td[2]");
//    private By hobbyElementLocator = By.xpath("//input[@type='checkbox' and @class='custom-control-input']");


    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void isPageLoaded() {
        Assert.assertEquals(elementMethods.getTextFromElement(pageTitle), "Practice Form",
                "Page is not loaded properly");
    }

    public void fillEntireForm(Map<String, Object> practiceFormValue) {
        fillFirstName((String) practiceFormValue.get("firstNameText"));
        fillLastName((String) practiceFormValue.get("lastNameText"));
        fillEmail((String) practiceFormValue.get("emailFieldText"));
        elementMethods.scrollPageDown("500");
        chooseGender((String) practiceFormValue.get("genderValueText"));
        fillPhoneNumber((String) practiceFormValue.get("mobilePhoneText"));
        fillDateOfBirth((String) practiceFormValue.get("monthValueText"),
                (String) practiceFormValue.get("dayValueText"), (String) practiceFormValue.get("yearValueText"));
        elementMethods.scrollPageDown("200");
        chooseHobbies((String) practiceFormValue.get("sportValueText"),
                (String) practiceFormValue.get("readValueText"), (String) practiceFormValue.get("musicValueText"));
        elementMethods.scrollPageDown("200");
        chooseSubjects((String) practiceFormValue.get("mathSubjectText"), (String) practiceFormValue.get("physicsSubjectText"));
        uploadPicture((String) practiceFormValue.get("pictureFileText"));
        fillAddress((String) practiceFormValue.get("addressValueText"));
        fillStateAndCity((String) practiceFormValue.get("stateValueText"), (String) practiceFormValue.get("cityValueText"));
        clickOneSubmitButton();
        getExpectedValues(practiceFormValue);
        getActualValues();
//        validateThatExpectedValuesEqualActualValues(practiceFormValue);
    }

    public void fillFirstName(String firstNameValue) {
        elementMethods.fillElement(firstNameField, firstNameValue);
    }

    public void fillLastName(String lastNameValue) {
        elementMethods.fillElement(lastNameField, lastNameValue);
    }

    public void fillEmail(String emailFieldValue) {
        elementMethods.fillElement(emailField, emailFieldValue);
    }

    public void chooseGender(String genderValue) {
        List<WebElement> genderList = List.of(driver.findElement(genderMale),
                driver.findElement(genderFemale), driver.findElement(genderOther)); // declaram lista
        elementMethods.chooseElementFromListByText(genderList, genderValue);
    }

    public void fillPhoneNumber(String mobilePhoneValue) {
        elementMethods.fillElement(mobilePhoneField, mobilePhoneValue);
    }

    public void fillDateOfBirth(String monthValue, String yearValue, String dayValue) {
        elementMethods.clickElement(dateOfBirthInput);
        elementMethods.selectElementByText(monthOfBirthLocator, monthValue);
        elementMethods.selectElementByText(yearOfBirthLocator, yearValue);
        elementMethods.chooseElementFromListByText(dayOfBirthListLocator, dayValue);
    }

    public void chooseSubjects(String mathSubjectValue, String physicsSubjectValue) {
        elementMethods.fillElement(subjectInputlocator, mathSubjectValue);
        elementMethods.fillElement(subjectInputlocator, Keys.ENTER);
        elementMethods.fillElement(subjectInputlocator, physicsSubjectValue);
        elementMethods.fillElement(subjectInputlocator, Keys.ENTER);
    }

    public void chooseHobbies(String sportValue, String readValue, String musicValue) {
        List<WebElement> hobbiesList = List.of(driver.findElement(sportHobbyLocator), driver.findElement(readHobbyLocator),
                driver.findElement(musicHobbyLocator)); //am creat lista cu elementele dorite;
        List<String> hobbyValueTextList = List.of(sportValue, readValue, musicValue);
        for (String hobby : hobbyValueTextList) {
            elementMethods.chooseElementFromListByText(hobbiesList, hobby);
        }
    }

    public void uploadPicture(String pictureFileValue) {
        elementMethods.uploadDocument(uploadFileLocator, pictureFileValue);
    }

    public void fillAddress(String addressValue) {
        elementMethods.fillElement(addressFieldLocator, addressValue);
    }

    public void fillStateAndCity(String stateValue, String cityValue) {
        elementMethods.fillElement(stateInputLocator, stateValue);
        elementMethods.fillElement(stateInputLocator, Keys.ENTER);
        elementMethods.fillElement(cityInputLocator, cityValue);
        elementMethods.fillElement(cityInputLocator, Keys.ENTER);
    }

    public void clickOneSubmitButton() {elementMethods.clickElement(submitButtonLocator);
    }

//    homework : validateFormIsCompletedProperly
//     homework : sa alegem un site si sa facem oop
//                    Base page
//                    Login page

    public HashMap<String, String> getExpectedValues(Map<String, Object> practiceFormData) {
        HashMap<String, String> expectedValues = new HashMap<>();
        expectedValues.put("Student Name", practiceFormData.get("firstNameText") + " " + practiceFormData.get("lastNameText"));
        expectedValues.put("Student Email", (String) practiceFormData.get("emailFieldText"));
        expectedValues.put("Gender", (String) practiceFormData.get("genderValueText"));
        expectedValues.put("Mobile", (String) practiceFormData.get("mobilePhoneText"));
        expectedValues.put("Date of Birth", practiceFormData.get("dayValueText") + " " + practiceFormData.get("monthValueText")
                + "," + practiceFormData.get("yearValueText"));
        expectedValues.put("Subjects", practiceFormData.get("mathSubjectText") + ", " + practiceFormData.get("physicsSubjectText"));
        expectedValues.put("Hobbies", practiceFormData.get("sportValueText") + ", " + practiceFormData.get("readValueText")
                + ", " + practiceFormData.get("musicValueText"));
        expectedValues.put("Picture", (String) practiceFormData.get("pictureFileText"));
        expectedValues.put("Address", (String) practiceFormData.get("addressValueText"));
        expectedValues.put("State and City", practiceFormData.get("stateValueText") + " " + practiceFormData.get("cityValueText"));
        return expectedValues;
    }

    public HashMap<String, String> getActualValues() {
        HashMap<String, String> actualValues = new HashMap<>();
        //indiferent ca alegem submitTablekeys sau values, parcurge oricum ambele liste;
        for (int i = 0; i < elementMethods.getElements(submitTableKeysLocator).size(); i++) {
            actualValues.put(elementMethods.getElements(submitTableKeysLocator).get(i).getText(),
                    elementMethods.getElements(submitTableValuesLocator).get(i).getText());
            //parcurgem fiecare valoare/cheie si luam textul de pe ea si o adagam in HashMap;
        }
        return actualValues;
    }

    public void validateThatExpectedValuesEqualActualValues(Map<String, Object> practiceFormData) {
        Assert.assertEquals(getActualValues(), getExpectedValues(practiceFormData), "Actual Values: "
                + getActualValues() + "are not equal/are not the same with the expected values: " + getExpectedValues(practiceFormData));
    }

}
