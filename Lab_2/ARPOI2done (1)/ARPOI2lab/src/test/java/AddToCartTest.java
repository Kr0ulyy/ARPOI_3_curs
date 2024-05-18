import org.example.SignUpData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

public class AddToCartTest extends PreconditionClass {
    SignUpData data = new SignUpData();

    @BeforeClass
    public void setUp(){
        data.setTesterEmailFromPage(driver);
    }

    @Test(priority = 1)
    public void positiveAddToCartTest() throws InterruptedException{
        driver.findElement(By.name("email")).sendKeys(data.getTESTEMAIL());
        driver.findElement(By.name("password")).sendKeys("1111");
        driver.findElement(By.cssSelector("input[value='Login']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/center/table/tbody/tr[5]/td/table/tbody/tr/td[1]/table/tbody/tr[3]/td/a")).click();
        driver.findElement(By.xpath("/html/body/center/table/tbody/tr[5]/td/table/tbody/tr/td[2]/p[2]/a")).click();
        WebElement message = driver.findElement(By.xpath("/html/body/center/table/tbody/tr[4]/td/span"));
        Assert.assertEquals(message.getText(), "Book was added to the Shopping Cart", "Add to cart error");
        driver.findElement(By.xpath("/html/body/center/table/tbody/tr[1]/td/table/tbody/tr/td[1]/a/img")).click();
        driver.findElement(By.linkText("Logout")).click();
    }

    @Test(priority = 2)
    public void negativeAddToCartTest(){
        driver.findElement(By.xpath("/html/body/center/table/tbody/tr[5]/td/table/tbody/tr/td[1]/table/tbody/tr[3]/td/a")).click();
        driver.findElement(By.xpath("/html/body/center/table/tbody/tr[5]/td/table/tbody/tr/td[2]/p[2]/a")).click();
        WebElement message = driver.findElement(By.xpath("/html/body/center/table/tbody/tr[4]/td"));
        Assert.assertEquals(message.getText(), "Oops, error. You must log in", "Add to cart error");
    }
}
