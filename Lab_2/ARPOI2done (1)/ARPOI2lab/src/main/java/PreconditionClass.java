import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class PreconditionClass {
    public static WebDriver driver;

    @BeforeSuite
    public void openWindow(){
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterSuite
    public void closeWindow(){
        driver.quit();
    }

    @BeforeMethod
    public void getPage(){
        driver.get("https://www.sharelane.com/cgi-bin/main.py");
    }


}
