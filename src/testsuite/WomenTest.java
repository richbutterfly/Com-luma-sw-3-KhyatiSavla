package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.ArrayList;
import java.util.List;

/**
 * 4. Write down the following test into WomenTestclass
 * 1. verifyTheSortByProductNameFilter
 * Mouse Hover on Women Menu
 * Mouse Hover on Tops
 * Click on Jackets
 * Select Sort By filter “Product Name”
 * Verify the products name display in
 * alphabetical order
 * 2. verifyTheSortByPriceFilter
 * Mouse Hover on Women Menu
 * Mouse Hover on Tops
 * Click on Jackets
 * Select Sort By filter “Price”
 * Verify the products price display in
 * Low to High
 */
public class WomenTest extends Utility {

    String baseURL = "https://magento.softwaretestingboard.com/";

    //Method to open the browser
    @Before
    public void setUp() {
        openBrowser(baseURL);
    }

    @Test
    public void verifyTheSortByProductNameFilter() throws InterruptedException {
        // 1.Mouse Hover on Women Menu
        mouseHoverToElement(By.xpath("//span[contains(text(),'Women')]"));
        // Mouse Hover on Tops
        mouseHoverToElement(By.xpath("//a[@id='ui-id-9']//span[text()='Tops']"));
        // Click on Jackets
        clickOnElement(By.cssSelector("a[id='ui-id-11'] span"));
        // Select Sort By filter “Product Name”
        clickOnElement(By.xpath("(//select[@id='sorter'])[1]"));
        Thread.sleep(2000);
        selectByVisibleTextFromDropdown(By.xpath("//div[2]//div[3]//select[1]"), "Product Name");
        Thread.sleep(2000);
        // Verify the products name display in alphabetical order
        List<WebElement> productsLists = driver.findElements(By.xpath("(//strong[@class='product name product-item-name'])[1]"));
        List<String> expectedProductLists = new ArrayList<>();
        for (WebElement productName : productsLists) {
            expectedProductLists.add(productName.getText());
        }
        System.out.println("Expected product name in Alphabetical order: " + expectedProductLists);
        Thread.sleep(2000);
        //OriginalList of Products name
        List<WebElement> originalProductsList = driver.findElements(By.xpath("(//strong[@class='product name product-item-name'])[1]"));
        List<String> originalProductLists = new ArrayList<>();
        for (WebElement productName : originalProductsList) {
            originalProductLists.add(productName.getText());
        }
        System.out.println("Original Product name in alphabetical order: " + originalProductLists);
        Assert.assertEquals(expectedProductLists, originalProductLists);
    }

    @Test
    public void verifyTheSortByPriceFilter() throws InterruptedException {
        // 2.Mouse Hover on Women Menu
        mouseHoverToElement(By.xpath("//span[contains(text(),'Women')]"));
        // Mouse Hover on Tops
        mouseHoverToElement(By.xpath("//a[@id='ui-id-9']//span[text()='Tops']"));
        // Click on Jackets
        clickOnElement(By.cssSelector("a[id='ui-id-11'] span"));
        Thread.sleep(2000);
        // Select Sort By filter “Price”
        clickOnElement(By.xpath("(//select[@id='sorter'])[1]"));
        Thread.sleep(2000);
        selectByVisibleTextFromDropdown(By.xpath("//div[2]//div[3]//select[1]"), "Price");
        //Verify the products price display in Low to High


    }

    //Method to close the browser
    @After
    public void tearDown() {
        closeBrowser();
    }
}
