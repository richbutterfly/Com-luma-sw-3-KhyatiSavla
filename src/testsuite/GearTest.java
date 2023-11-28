package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

/** 6.Write down the following test into ‘GearTest’ class
 1. userShouldAddProductSuccessFullyTo
 ShoppinCart()
 * Mouse Hover on Gear Menu
 * Click on Bags
 * Click on Product Name ‘Overnight Duffle’
 * Verify the text ‘Overnight Duffle’
 * Change Qty 3
 * Click on ‘Add to Cart’ Button.
 * Verify the text
 ‘You added Overnight Duffle to your shopping cart.’
 * Click on ‘shopping cart’ Link into
 message
 * Verify the product name ‘Cronus Yoga Pant’
 * Verify the Qty is ‘3’
 * Verify the product price ‘$135.00’
 * Change Qty to ‘5’
 * Click on ‘Update Shopping Cart’ button
 * Verify the product price ‘$225.00
 *
 */
public class GearTest extends Utility {

    String baseURL = "https://magento.softwaretestingboard.com/";

    //Method to open the browser
    @Before
    public void setUp() {
        openBrowser(baseURL);
    }

    @Test
    public void userShouldAddProductSuccessFullyToShoppingCart() {
        //Mouse Hover on Gear Menu
        mouseHoverToElement(By.xpath("//span[normalize-space()='Gear']"));
        // Click on Bags
        clickOnElement(By.xpath("//span[contains(text(),'Bags')]"));
        // Click on Product Name ‘Overnight Duffle’
        clickOnElement(By.xpath("//img[@alt='Overnight Duffle']"));
        // Verify the text ‘Overnight Duffle’
        String expectedText = "Overnight Duffle";
        String actualText = getTextFromElement(By.xpath("//span[@class='base']"));
        Assert.assertEquals(expectedText, actualText);
        // Change Qty 3
        clearText(By.xpath("//input[@id='qty']"));
        sendTextToElement(By.xpath("//input[@id='qty']"), "3");
        // Click on ‘Add to Cart’ Button.
        clickOnElement(By.xpath("//span[normalize-space()='Add to Cart']"));

        //Verify the text ‘You added Overnight Duffle to your shopping cart.'
        String expectedText1 = "You added Overnight Duffle to your shopping cart.";
        String actualText1 = getTextFromElement(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"));
        Assert.assertEquals( expectedText1,actualText1);

        //Click on ‘shopping cart’ Link into message
        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));
        //Verify the product name ‘Overnight Duffle’
        Assert.assertEquals("Name does not match","Overnight Duffle",getTextFromElement(By.xpath("//td[@class='col item']//a[normalize-space()='Overnight Duffle']")));
        //Verify the Qty is ‘3’
        Assert.assertEquals("number does not match","3",getTextFromElement(By.xpath("//span[@class='counter-number']")));
        // Verify the product price ‘$135.00’
        Assert.assertEquals("Price does not match","$135.00",getTextFromElement(By.xpath("//span[@data-bind='text: getValue()'][normalize-space()='$135.00']")));
        // Change Qty to ‘5’
        clearText(By.xpath("td[class='col qty'] input[class*='input-text qty']"));
        sendTextToElement(By.xpath("/td[class='col qty'] input[class*='input-text qty']"),"5");
        // Click on ‘Update Shopping Cart’ button
        clickOnElement(By.xpath("//span[normalize-space()='Update Shopping Cart']"));
                // Verify the product price ‘$225.00
        Assert.assertEquals("$225.00",getTextFromElement(By.xpath("(//span[@class='price'][normalize-space()='$225.00'])[3]")));

    }


    //Method to close the browser
    @After
    public void tearDown() {
        closeBrowser();
    }
}
