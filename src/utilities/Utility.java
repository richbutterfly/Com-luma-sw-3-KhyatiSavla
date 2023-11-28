package utilities;

import browserfactory.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

/** 2. Create the package utilities and create the class
 with the name ‘Utility’ inside the ‘utilities’
 package. And write the all the utility methods in
 it’.
 */
public class Utility extends BaseTest {

    // This Method will click on any element whatever locator we are passing
    public void clickOnElement(By by) {
        driver.findElement(by).click();
    }

    // This Method will send text on element
    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    // This Method will get Text from Element
    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }
    public void clearText (By by){
        driver.findElement(by).clear();
    }
    //*******************************Select Method ***************************//

    //This method will select the option by visible value
    public void selectByVisibleTextFromDropdown(By by, String text) {
        WebElement dropdown = driver.findElement(by);
        //Create an object of Select class
        Select select = new Select(dropdown);
        select.selectByVisibleText(text);
    }

    //This method will select the value from dropdown
    public void selectByValueFromDropdown(By by, String text) {
        WebElement value = driver.findElement(by);
        //Create an object of Select class
        Select select = new Select(value);
        select.selectByValue(text);
    }

    //This method will select the number from dropdown
    public void selectByValueFromDropdown(By by, int number) {
        WebElement index = driver.findElement(by);
        //Create an object of Select class
        Select select = new Select(index);
        select.selectByIndex(number);
    }
    //************************* Action Method *************************//
    public void mouseHoverToElement(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).build().perform();
    }
    public void mouseHoverToElementAndClick(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).click().build().perform();
    }
}
