package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class FramesTest {
    private static WebDriver driver;
    private static Actions actions;

    @BeforeClass
    static void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    static void tearDown() {
        driver.quit();
    }

    @Test
    public void nestedFrames() throws Exception {
        driver.get("http://the-internet.herokuapp.com/nested_frames");
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");
        WebElement contentElement = driver.findElement(By.id("content"));
        String contentText = contentElement.getText();
        assertEquals(contentText, "MIDDLE");
    }

    @Test
    public void iFrames() throws Exception {
        driver.get("http://the-internet.herokuapp.com/tinymce");
        driver.switchTo().frame("mce_0_ifr");
        WebElement editor = driver.findElement(By.id("tinymce"));
        String beforeText = editor.getText();
        editor.clear();
        editor.sendKeys("Hello World!");
        String afterText = editor.getText();
        assertNotEquals(afterText, beforeText);
        assertEquals(editor.getText(), "Hello World!");
        driver.switchTo().defaultContent();
        WebElement headingElement = driver.findElement(By.cssSelector("h3"));
        String headingText = headingElement.getText();
        assertEquals(headingText, "An iFrame containing the TinyMCE WYSIWYG Editor");
    }
}