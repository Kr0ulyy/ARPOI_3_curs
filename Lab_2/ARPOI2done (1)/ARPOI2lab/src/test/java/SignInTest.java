import org.example.SignUpData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

public class SignInTest extends PreconditionClass {
    SignUpData data = new SignUpData();

    @BeforeClass
    public void setUp(){
        data.setTesterEmailFromPage(driver);
    }

    @AfterMethod
    public static void autoLogout(WebElement driver)
    {
        try {
            driver.findElement(By.xpath("/html/body/center/table/tbody/tr[1]/td/table/tbody/tr/td[1]/a")).click();
            driver.findElement(By.linkText("Logout")).click();
        }catch (Exception e){}
    }


    @Test(priority = 1)
    public void positiveSignIn() throws InterruptedException{
        driver.findElement(By.name("email")).sendKeys(data.getTESTEMAIL());
        driver.findElement(By.name("password")).sendKeys("1111");
        driver.findElement(By.cssSelector("input[value='Login']")).click();
        Thread.sleep(1000);
        WebElement helloMessage = driver.findElement(By.cssSelector("span.user"));
        String textInMessage = helloMessage.getText();
        Assert.assertTrue(textInMessage.contains("Hello"), "Ошибка сообщения 'Hello'");
    }

    @DataProvider
    Object[][] invalidSignInData(){
        return new Object[][]{
                {"somemail@gmail.com", "1111"},
                {data.getTESTEMAIL(), "1133"},
        };
    }

    @Test(priority = 2, dataProvider = "invalidSignInData")
    public void negativeLoginOrPasswordSignIn(String email, String password) throws InterruptedException{
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.cssSelector("input[value='Login']")).click();
        Thread.sleep(1000);
        String textInMessage = driver.findElement(By.xpath("/html/body/center/table/tbody/tr[4]/td/span")).getText();
        Assert.assertTrue(textInMessage.contains("Oops, error. Email and/or password don't match our records"), "Message error");
    }
}
