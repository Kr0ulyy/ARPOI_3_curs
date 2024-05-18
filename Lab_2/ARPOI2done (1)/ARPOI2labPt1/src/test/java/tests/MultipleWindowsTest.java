package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.pages.MultipleWindowsPage;

import java.util.Set;

import static org.testng.Assert.assertTrue;

public class MultipleWindowsTest {
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
    public void testNewWindow() {
        MultipleWindowsPage multipleWindowsPage = new MultipleWindowsPage(driver);
        driver.get("http://the-internet.herokuapp.com/windows");
        multipleWindowsPage.getNewWindowLink().click();
        switchToNewWindow();
        assertTrue(driver.getCurrentUrl().contains("/windows/new"));
    }

    private void switchToNewWindow() {
        Set<String> windowHandles = driver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);
        }
    }
}
