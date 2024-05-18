import org.example.SignUpData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

public class LogOutTest extends PreconditionClass {
    SignUpData data = new SignUpData();

    @BeforeClass
    public void setUp(){
        data.setTesterEmailFromPage(driver);
    }

    @Test
    public void logoutTest() throws InterruptedException{
        driver.findElement(By.name("email")).sendKeys(data.getTESTEMAIL());
        driver.findElement(By.name("password")).sendKeys("1111");
        driver.findElement(By.cssSelector("input[value='Login']")).click();
        Thread.sleep(1000);
        driver.findElement(By.linkText("Logout")).click();
        WebElement message = driver.findElement(By.xpath("/html/body/center/table/tbody/tr[4]/td"));
        Assert.assertEquals(message.getText(), "You've been logged out");
    }
}
