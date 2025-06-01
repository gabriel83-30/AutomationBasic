package Homerwork.pomExample;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBoxTest {

    WebDriver driver;

    @Test
    public void CheckBoxTest() {
        openBrowser();
        chooseMeniu();
        chooseSubMenu();
        toggleHomeFolder();
        toggleDesktopFolder();
        toggleDocumentsFolder();
        toggleDownloadsFolder();
        selectDesktop();
        selectAllCheckBoxes();


    }

    // facem o metoda care deschide un browser
    public void openBrowser() {
        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/");
    }

    // facem o metoda care alege un meniu
    public void chooseMeniu() {
        WebElement elementsMenu = driver.findElement(By.xpath("//h5[text()='Elements']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", elementsMenu);
        elementsMenu.click();
    }

    // facem o metoda care sa selecteze sub-meniul
    public void chooseSubMenu() {
        WebElement elementsSubMenu = driver.findElement(By.xpath("//span[text()='Check Box']"));
        elementsSubMenu.click();
    }

    // facem o metoda care sa extinda folderul "Home"
    public void toggleHomeFolder() {
        WebElement toggleHome = driver.findElement(By.cssSelector("button[title='Toggle']"));
        toggleHome.click();
    }
//
//    // facem o metoda care sa extinda folderul "Desktop"
        public void toggleDesktopFolder() {
            WebElement toggleDesktop = driver.findElement(By.xpath("//span[text()='Desktop']/preceding::button[1]"));
            toggleDesktop.click();
        }
//
//    // facem o metoda care sa extinda folderul "Documents"
    public void toggleDocumentsFolder() {
        WebElement toggleDocuments = driver.findElement(By.xpath("//span[text()='Documents']/preceding::button[1]"));
        toggleDocuments.click();
    }
//
//    // facem o metoda care sa extinda folderul "Downloads"
    public void toggleDownloadsFolder() {
        WebElement toggleDownloads = driver.findElement(By.xpath("//span[text()='Downloads']/preceding::button[1]"));
        toggleDownloads.click();
    }

//     facem o metoda care sa selecteze folder-ul Desktop
    public void selectDesktop() {
        WebElement expandDesktop = driver.findElement(By.xpath("//span[text()='Desktop']/preceding::span[@class='rct-checkbox'][1]"));
        expandDesktop.click();
        WebElement result = driver.findElement(By.id("result"));
        Assert.assertTrue(result.getText().contains("desktop"), "Folder-ul Desktop NU a fost selectat.");
    }

//     facem o metoda in care Selectăm toate checkbox-urile (selectăm Home)
    public void selectAllCheckBoxes(){
        WebElement homeCheckBox = driver.findElement(By.xpath("//span[@class='rct-checkbox'][1]"));
        homeCheckBox.click();
        WebElement result = driver.findElement(By.id("result"));
        Assert.assertTrue(result.getText().toLowerCase().contains("home"), "Folder-ul Home NU a fost selectat.");
        Assert.assertTrue(result.getText().toLowerCase().contains("desktop"), "Folder-ul Desktop NU a fost selectat.");

    }

    // Folderele au fost extinse.
    //Checkbox-urile pot fi bifate.
    //Se confirmă selecția în zona de output (#result).




}
