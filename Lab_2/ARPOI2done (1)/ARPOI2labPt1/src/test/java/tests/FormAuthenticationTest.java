package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.pages.FormAuthenticationPage;

import static org.testng.AssertJUnit.assertEquals;

public class FormAuthenticationTest {
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
    public void testLogin() throws InterruptedException {
        FormAuthenticationPage formAuthenticationPage = new FormAuthenticationPage(driver);
        driver.get("https://the-internet.herokuapp.com/login");
        formAuthenticationPage.getUsername().sendKeys("tomsmith");
        formAuthenticationPage.getPassword().sendKeys("SuperSecretPassword!");
        formAuthenticationPage.getSubmit().click();
        Thread.sleep(2000);
        WebElement successMessage = formAuthenticationPage.getFlash();
        String successText = successMessage.getText();
        assertEquals(successText, "You logged into a secure area!\n" + "×");
        driver.findElement(By.xpath("//a[contains(., 'Logout')]")).click();
        Thread.sleep(5000);
    }
    @Test
    public void testLoginNot() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/login");
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("123");
        driver.findElement(By.cssSelector("button.radius")).click();
        Thread.sleep(2000);
        WebElement errorMessage = driver.findElement(By.xpath("//div[@class='flash error']"));
        assertEquals(errorMessage.getText(), "Your password is invalid!\n" + "×");
    }
}

