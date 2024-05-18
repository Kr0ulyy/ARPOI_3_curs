import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

public class SearchTest extends PreconditionClass {

    @Test(priority = 1)
    public void positiveSearchTest(){
        driver.findElement(By.name("keyword")).sendKeys("The Moon and Sixpence");
        driver.findElement(By.cssSelector("input[value='Search']")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("a[href='./add_to_cart.py?book_id=8']")).isDisplayed(),
                "Link is not displayed");
    }

    @Test(priority = 2)
    public void negativeSearchTest(){
        driver.findElement(By.name("keyword")).sendKeys("Some book name");
        driver.findElement(By.cssSelector("input[value='Search']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//span[.='Nothing is found :(']")).isDisplayed(),
                "Error message id not displayed");
    }
}
