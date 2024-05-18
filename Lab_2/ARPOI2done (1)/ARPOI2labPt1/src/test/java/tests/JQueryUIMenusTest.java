package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class JQueryUIMenusTest {
    private static WebDriver driver;

    @BeforeClass
    static void setUp() {
        driver = new ChromeDriver();

    }

    @AfterClass
    static void tearDown() {
        driver.quit();
    }

    @BeforeMethod
    public void setPage() throws InterruptedException{
        driver.get("http://the-internet.herokuapp.com/jqueryui/menu");
        Actions actions = new Actions(driver);
        WebElement enabledMenuItem = driver.findElement(By.xpath("//*[@id=\"ui-id-3\"]/a"));
        actions.moveToElement(enabledMenuItem).perform();
        Thread.sleep(500);
        WebElement downloads = driver.findElement(By.xpath("//*[@id=\"ui-id-4\"]/a"));
        actions.moveToElement(downloads).perform();
        Thread.sleep(500);
    }

    @Test
    public void testDownloadPDF() throws InterruptedException {
        driver.findElement(By.linkText("PDF")).click();
        Thread.sleep(1000);
        File excelFile = new File("C:\\Users\\Viktor\\Downloads");
        assertTrue(excelFile.exists(), "PDF file not downloaded successfully.");
    }

    @Test
    public void testDownloadCSV() throws InterruptedException {
        driver.findElement(By.linkText("CSV")).click();
        Thread.sleep(1000);
        File csvFile = new File("C:\\Users\\Viktor\\Downloads");
        assertTrue(csvFile.exists(), "CSV file not downloaded successfully.");
    }

    @Test
    public void testDownloadExcel() throws InterruptedException {
        driver.findElement(By.linkText("Excel")).click();
        Thread.sleep(1000);
        File excelFile = new File("C:\\Users\\Viktor\\Downloads");
        assertTrue(excelFile.exists(), "Excel file not downloaded successfully.");
    }




}
