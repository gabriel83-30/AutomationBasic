package tests;

import org.openqa.selenium.*;
import org.testng.annotations.Test;
import pages.CommonPage;
import pages.HomePage;
import pages.PracticeFormPage;
import propertyUtility.PropertyUtility;

import java.util.Map;

import static constants.MenuConstants.FORMS_MENU;
import static constants.SubMenuConstants.PRACTICE_FORM_SUBMENU;

public class PracticeFormTest extends BaseTest {



    @Test
    public void practiceFormTest() {


        HomePage homePage = new HomePage(driver);
        homePage.isPageLoaded();
        homePage.goToDesiredMenu(FORMS_MENU);
        CommonPage commonPage = new CommonPage(driver);
        commonPage.isPageLoaded();
        commonPage.goToDesiredSubMenu(PRACTICE_FORM_SUBMENU);
        PracticeFormPage practiceFormPage = new PracticeFormPage(driver);
        propertyUtility = new PropertyUtility("PracticeFormTest");
        Map<String, Object> PracticeFormData = propertyUtility.getAllProperties();
        practiceFormPage.isPageLoaded();
        practiceFormPage.fillEntireForm(PracticeFormData);
        practiceFormPage.validateThatExpectedValuesEqualActualValues(PracticeFormData);



// proiectul , implementarea BRUTA( MINIM NOTA 7)
//        driver = new ChromeDriver();
//        // Navigam catre pegina website-ului
//        driver.get("https://demoqa.com/");
//        // Facem fereastra browser-ului maximize
//        driver.manage().window().maximize();
        // Identificam meniul dorit si facem click pe el
//        WebElement formMeniu = driver.findElement(By.xpath("//h5[text()='Forms']"));
//        // Facem scroll pana in dreptul elementului pe care vrem sa-l actionam
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].scrollIntoView(true);", formMeniu);
//        // Acum facem click pe meniul de mai sus
//        formMeniu.click();
//        // Identifam submeniul dorit si facem click pe el
//        WebElement PracticeFormSubMenu = driver.findElement(By.xpath("//span[text()='Practice Form']"));
//        PracticeFormSubMenu.click();
        // Identificam elemnetele din formular si facem actiuni corespunzatoare pe fiecare

        //completam field-ul de first name
//        WebElement firstNameField = driver.findElement(By.id("firstName"));
//        String firstNameText = "Mario"; // cream o variabila locala
//        firstNameField.sendKeys(firstNameText);

        //completam field-ul de last name
//        WebElement lastNameField = driver.findElement(By.id("lastName"));
//        String lastNameText = "Luigi"; // cream o variabila locala
//        lastNameField.sendKeys(lastNameText);

        //completam field-ul de email
//        WebElement emailField = driver.findElement(By.id("userEmail"));
//        String emailFieldText = "test@gmail.com";
//        emailField.sendKeys(emailFieldText);

        // Facem scroll pana in dreptul elementului pe care vrem sa-l actionam
//        js.executeScript("window.scrollTo(0, 500);"); // scroll 500 pixeli

        // selectem gender
        // declaram o lista de web elemnente
//        WebElement genderMale = driver.findElement(By.xpath("//label[@for='gender-radio-1']"));
//        WebElement genderFemale = driver.findElement(By.xpath("//label[@for='gender-radio-2']"));
//        WebElement genderOther = driver.findElement(By.xpath("//label[@for='gender-radio-3']"));
//        String genderValueText = "Male";
//        List<WebElement> genderList = List.of(genderMale, genderFemale, genderOther); // declaram lista
//        for (int i = 0; i < genderList.size(); i++) {
//            if (genderList.get(i).getText().equals(genderValueText)) {
//                genderList.get(i).click();
//                break;
//            }
//        }

        // 14.04.2025 -> -> -> Continuare Lectie :

//        // introducem numarul de telefon
//        WebElement mobilePhoneField = driver.findElement(By.id("userNumber"));
//        mobilePhoneField.sendKeys("0758967317");

        // alegem ziua de nastere
//        WebElement dateOfBirthInput = driver.findElement(By.id("dateOfBirthInput"));
//        dateOfBirthInput.click();
//
//        // alegem luna de nastere
//        WebElement monthOfBirthElement = driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']"));
//        Select selectMonth = new Select(monthOfBirthElement);
//        selectMonth.selectByVisibleText("April");
//
//        //select[@class='react-datepicker__year-select']
//        WebElement yearOfBirthElement = driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']"));
//        Select selectYear = new Select(yearOfBirthElement);
//        selectYear.selectByVisibleText("1922");

        // selectam data exacta
//        WebElement dayOfBirthElement = driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']"));
//        Select selectDay = new Select(yearOfBirthElement);
//        selectDay.selectByVisibleText("14");

        // alegem ziua nasterii dintr-o lista de zile posibile( sa faca click cand ajunge la ce ne dorim)
        // div[contains(@class,'react-datepicker__day')]
//        List<WebElement> dayOfBirthList = driver.findElements(By.xpath("//div[contains(@class,'react-datepicker__day')]"));
//        for (int i = 0; i < dayOfBirthList.size(); i++) {
//            if (dayOfBirthList.get(i).getText().equals("14")) {
//                dayOfBirthList.get(i).click();
//                break;
//            }
//        }

//        // completam subject
//        WebElement subjectInputElement = driver.findElement(By.id("subjectsInput"));
//        subjectInputElement.sendKeys("Maths");
//        subjectInputElement.sendKeys(Keys.ENTER);
//        subjectInputElement.sendKeys("Physics");
//        subjectInputElement.sendKeys(Keys.ENTER);

        // selectam sporthobby
//        WebElement sportHobbyElement = driver.findElement(By.xpath("//label[@for='hobbies-checkbox-1']"));
//        sportHobbyElement.click();
//        WebElement readingtHobbyElement = driver.findElement(By.xpath("//label[@for='hobbies-checkbox-2']"));
//        readingtHobbyElement.click();
//        // completam musichobby
//        WebElement musicHobbyElement = driver.findElement(By.xpath("//label[@for='hobbies-checkbox-3']"));
//        musicHobbyElement.click();
//        js.executeScript("window.scrollTo(0, 500);"); // facem scrool

//         incarcare poza
//        WebElement uploadFileElement = driver.findElement(By.id("uploadPicture"));
//        String pictureFilePath = "src/test/resources/TestImage.png";
//        File file = new File(pictureFilePath);
//        uploadFileElement.sendKeys(file.getAbsolutePath());

        // completarea adresei
//        WebElement addressField = driver.findElement(By.id("currentAddress"));
//        addressField.sendKeys("Adresa testare 1.");

        // identificam statul
//        WebElement stateInputElement = driver.findElement(By.id("react-select-3-input"));
//        stateInputElement.sendKeys("NCR");
//        stateInputElement.sendKeys(Keys.ENTER);
//
//        // identificam orasul
//        WebElement cityInputElement = driver.findElement(By.id("react-select-4-input"));
//        cityInputElement.sendKeys("Delhi");
//        cityInputElement.sendKeys(Keys.ENTER);

        // apasam butonul submit
//        WebElement submitButton = driver.findElement(By.id("submit"));
//        submitButton.click();
        // validam datele de intrare folosite

        // 16.04.2025 -> -> -> Continuare lectie

        // facem un hashmap cu expected values
//        HashMap<String, String> expectedValues = new HashMap<>();
//        expectedValues.put("Student Name", firstNameText + " " + lastNameText);
//        expectedValues.put("Student Email", emailFieldText);
//        expectedValues.put("Gender", genderValueText);
//        expectedValues.put("Mobile", "0758967317");
//        expectedValues.put("Date of Birth", );

    }

}
