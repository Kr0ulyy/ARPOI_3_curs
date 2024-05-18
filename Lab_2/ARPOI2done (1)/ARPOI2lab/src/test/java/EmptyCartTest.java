import org.example.SignUpData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

public class EmptyCartTest extends PreconditionClass {

    SignUpData data = new SignUpData();

    @Test(priority = 1)
    public void positiveEmptyCartTest() throws InterruptedException{
        data.setTesterEmailFromPage(driver);
        driver.findElement(By.linkText("Test Portal")).click();
        driver.findElement(By.linkText("Account Creator")).click();
        driver.findElement(By.cssSelector("input[value='Create new user account']")).click();
        driver.findElement(By.cssSelector("input[value='Auto Login']")).click();
        Thread.sleep(1000);
        driver.findElement(By.linkText("Shopping Cart")).click();
        WebElement message = driver.findElement(By.xpath("/html/body/center/table/tbody/tr[4]/td"));
        Assert.assertEquals(message.getText(), "Cart is empty", "Empty cart error");
        driver.findElement(By.xpath("/html/body/center/table/tbody/tr[1]/td/table/tbody/tr/td[1]/a/img")).click();
        driver.findElement(By.linkText("Logout")).click();
    }

    @Test(priority = 2)
    public void negativeEmptyCartTest(){
        driver.findElement(By.linkText("Shopping Cart")).click();
        WebElement message = driver.findElement(By.xpath("/html/body/center/table/tbody/tr[4]/td/span"));
        Assert.assertEquals(message.getText(), "Oops, error. You must log in");
    }

}
