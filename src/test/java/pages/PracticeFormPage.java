package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.io.File;
import java.util.List;

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


    String firstNameText = "Mario";
    String lastNameText = "Luigi";
    String emailFieldText = "test@gmail.com";
    String genderValueText = "Male";
    String mobilePhoneText = "0758967317";
    String monthValueText = "April";
    String yearValueText = "1922";
    String dayValueText = "14";
    String mathSubjectText = "Maths";
    String physicsSubjectText = "Physics";
    String sportValueText = "Sports";
    String readValueText = "Reading";
    String musicValueText = "Music";
    String addressValueText = "Adresa testare 1.";
    String stateValueText = "NCR";
    String cityValueText = "Delhi";


    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void isPageLoaded() {
        Assert.assertEquals(driver.findElement(pageTitle).getText(), "Practice Form",
                "Page is not loaded properly");
    }

    public void fillEntireForm() {
        fillFirstName();
        fillLastName();
        fillEmail();
        scrollPageDown("500");
        chooseGender();
        fillPhoneNumber();
        fillDateOfBirth();
        chooseSubjects();
        scrollPageDown("500");
        chooseHobbies();
        scrollPageDown("500");
        uploadPicture();
        fillAddress();
        fillStateAndCity();
        clickOneSubmitButton();



    }

    public void fillFirstName() {
        driver.findElement(firstNameField).sendKeys(firstNameText);
    }

    public void fillLastName() {
        driver.findElement(lastNameField).sendKeys(lastNameText);

    }

    public void fillEmail() {
        driver.findElement(emailField).sendKeys(emailFieldText);
    }

    public void scrollPageDown(String scrollValue) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0," + scrollValue + ")");
    }

    public void chooseGender() {
        List<WebElement> genderList = List.of(driver.findElement(genderMale), driver.findElement(genderFemale), driver.findElement(genderOther)); // declaram lista
        for (int i = 0; i < genderList.size(); i++) {
            if (genderList.get(i).getText().equals( genderValueText)) {
                genderList.get(i).click();
                break;
            }
        }

    }

    public void fillPhoneNumber() {
        driver.findElement(mobilePhoneField).sendKeys(mobilePhoneText);
    }

    public void fillDateOfBirth() {
        driver.findElement(dateOfBirthInput).click();
        Select selectMonth = new Select(driver.findElement(monthOfBirthLocator));
        selectMonth.selectByVisibleText(monthValueText);
        Select selectYear = new Select(driver.findElement(yearOfBirthLocator));
        selectYear.selectByVisibleText(yearValueText);
        for (int i = 0; i < driver.findElements(dayOfBirthListLocator).size(); i++) {
            if (driver.findElements(dayOfBirthListLocator).get(i).getText().equals(dayValueText)) {
                driver.findElements(dayOfBirthListLocator).get(i).click();
                break;
            }
        }
    }

    public void chooseSubjects() {
        driver.findElement(subjectInputlocator).sendKeys(mathSubjectText);
        driver.findElement(subjectInputlocator).sendKeys(Keys.ENTER);
        driver.findElement(subjectInputlocator).sendKeys(physicsSubjectText);
        driver.findElement(subjectInputlocator).sendKeys(Keys.ENTER);

    }

    public void chooseHobbies() {
        List<WebElement> hobbiesList = List.of(driver.findElement(sportHobbyLocator), driver.findElement(readHobbyLocator),
                driver.findElement(musicHobbyLocator)); //am creat lista cu elementele dorite;
        List<String> hobbyValueTextList = List.of(sportValueText, readValueText, musicValueText);
        for (String hobby : hobbyValueTextList) {
            for (int i = 0; i < hobbiesList.size(); i++) {
                if (hobbiesList.get(i).getText().equals(hobby)) {
                    hobbiesList.get(i).click();
                }
            }
        }
    }

    public void uploadPicture(){
        String pictureFilePath = "src/test/resources/TestImage.png";
        File file = new File(pictureFilePath);
        driver.findElement(uploadFileLocator).sendKeys(file.getAbsolutePath());
    }

    public void fillAddress() {
        driver.findElement(addressFieldLocator).sendKeys(addressValueText);
    }

    public void fillStateAndCity() {
        driver.findElement(stateInputLocator).sendKeys(stateValueText);
        driver.findElement(stateInputLocator).sendKeys(Keys.ENTER);
        driver.findElement(cityInputLocator).sendKeys(cityValueText);
        driver.findElement(cityInputLocator).sendKeys(Keys.ENTER);

    }

    public void clickOneSubmitButton(){
        driver.findElement(submitButtonLocator);
    }

//    homework : validateFormIsCompletedProperly
//     homework : sa alegem un site si sa facem oop
//                    Base page
//                    Login page


}
