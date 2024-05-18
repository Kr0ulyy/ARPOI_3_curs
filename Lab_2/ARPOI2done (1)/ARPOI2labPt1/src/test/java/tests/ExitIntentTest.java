package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.pages.ExitIntentPage;


public class ExitIntentTest {
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
    public void testExitIntent() throws InterruptedException {
        ExitIntentPage exitIntentPage = new ExitIntentPage(driver);
        driver.get("https://the-internet.herokuapp.com/exit_intent");
        Actions actions = new Actions(driver);
        WebElement triggerArea = driver.findElement(By.className("example"));
        actions.moveToElement(triggerArea).perform();
        Thread.sleep(2000);
        WebElement modalTitle = exitIntentPage.getModalTitle();
        System.out.println("Modal title text: " + modalTitle.getText());
    }
}
