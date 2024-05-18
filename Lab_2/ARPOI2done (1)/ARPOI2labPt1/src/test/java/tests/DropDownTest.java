package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.pages.DropdownPage;

public class DropDownTest {
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
    public void test() {
        DropdownPage dropdownPage = new DropdownPage(driver);
        driver.get("https://the-internet.herokuapp.com/dropdown");
        Select select = dropdownPage.getDropdownSelect();
        select.selectByVisibleText("Option 2");
        select.selectByValue("2");
        select.selectByIndex(1);
    }
}