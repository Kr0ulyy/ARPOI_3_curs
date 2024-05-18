import org.example.SignUpData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

public class ZipCodeTest extends PreconditionClass {
    SignUpData data = new SignUpData();

    @Test(priority = 1)
    public void positiveZipTest(){
        driver.findElement(By.linkText("Sign up")).click();
        driver.findElement(By.name("zip_code")).sendKeys(data.getZIP());
        driver.findElement(By.cssSelector("input[value='Continue']")).click();
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://www.sharelane.com/cgi-bin/register.py?page=1&zip_code=94213", "Zip code error");
    }

    @DataProvider
    static Object[][] zips(){
        return new Object[][]{
                {"letters"},
                {"!@#$%^"},
                {"1"}
        };
    }

    @Test(priority = 2, dataProvider = "zips")
    public void negativeZip(String zip){
        driver.findElement(By.linkText("Sign up")).click();
        driver.findElement(By.name("zip_code")).sendKeys(zip);
        driver.findElement(By.cssSelector("input[value='Continue']")).click();
        WebElement message = driver.findElement(By.xpath("/html/body/center/table/tbody/tr[4]/td"));
        Assert.assertEquals(message.getText(), "Oops, error on page. ZIP code should have 5 digits", "Zip code test error: no message");
    }
}
