package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.pages.DynamicControlsPage;

public class DynamicControlsTest {
    private static WebDriver driver;

    @BeforeClass
    static void setUp() {
        driver = new ChromeDriver();
    }

    @AfterClass
    static void tearDown() {
        driver.close();
        driver.quit();
    }

    @Test
    public void testCheckbox() throws InterruptedException {
        DynamicControlsPage dynamicControlsPage = new DynamicControlsPage(driver);
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement checkbox = dynamicControlsPage.getCheckbox();
        WebElement removeButton = dynamicControlsPage.getRemoveButton();
        removeButton.click();
        Thread.sleep(5000);
        WebElement addButton = dynamicControlsPage.getAddButton();
        addButton.click();
        Thread.sleep(1000);
    }

    @Test
    public void testInput() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement inputField = driver.findElement(By.xpath("//input[@type='text']"));
        WebElement enableButton = driver.findElement(By.xpath("//button[contains(text(), 'Enable')]"));
        enableButton.click();
        while (!inputField.isEnabled()) {
            Thread.sleep(500);
        }
    }
}
