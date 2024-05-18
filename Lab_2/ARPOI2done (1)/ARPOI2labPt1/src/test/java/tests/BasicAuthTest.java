package tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.pages.BasicAuthPage;

public class BasicAuthTest {
    private static WebDriver driver;
    private static final String LOGIN = "admin";
    private static final String PASSWORD = "admin";

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
    public void test()  {
        WebDriver driver = new ChromeDriver();
        BasicAuthPage basicAuthPage = new BasicAuthPage(driver);
        driver.get("http://the-internet.herokuapp.com/basic_auth");
        String url = "http://" + LOGIN + ":" + PASSWORD + "@the-internet.herokuapp.com/basic_auth";
        driver.get(url);
        String pageMessage = basicAuthPage.getCongratulations().getText();
        assertEquals(pageMessage, "Congratulations! You must have the proper credentials.");
    }
}
