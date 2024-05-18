package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.pages.JSAlertsPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class JavaScriptAlertsTest {
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
    public void testJSAlert() {
        JSAlertsPage jsAlertsPage = new JSAlertsPage(driver);
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        jsAlertsPage.getAlert().click();
        Alert alert = driver.switchTo().alert();
        assertEquals(alert.getText(), "I am a JS Alert");
        alert.accept();
        WebElement result = jsAlertsPage.getResult();
        assertTrue(result.getText().contains("You successfully clicked an alert"));
    }

    @Test
    public void testJSConfirm() {
        JSAlertsPage jsAlertsPage = new JSAlertsPage(driver);
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
        WebElement jsConfirmButton = jsAlertsPage.getConfirm();
        jsConfirmButton.click();
        Alert alert = driver.switchTo().alert();
        assertEquals(alert.getText(), "I am a JS Confirm");
        alert.dismiss();
        WebElement result = jsAlertsPage.getResult();
        assertTrue(result.getText().contains("You clicked: Cancel"));
    }

    @Test
    public void testJSPrompt() {
        JSAlertsPage jsAlertsPage = new JSAlertsPage(driver);
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
        WebElement jsPromptButton = jsAlertsPage.getPrompt();
        jsPromptButton.click();
        Alert alert = driver.switchTo().alert();
        assertEquals(alert.getText(), "I am a JS prompt");
        alert.sendKeys("Test input");
        alert.accept();
        WebElement result = jsAlertsPage.getResult();
        assertTrue(result.getText().contains("You entered: Test input"));
    }
}
