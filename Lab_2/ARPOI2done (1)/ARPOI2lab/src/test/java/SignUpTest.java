import org.example.Register;
import org.example.SignUpData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

public class SignUpTest extends PreconditionClass {
    SignUpData data = new SignUpData();

    @Test(priority = 1)
    public void positiveSignUp(){
        driver.findElement(By.linkText("Sign up")).click();
        driver.findElement(By.name("zip_code")).sendKeys(data.getZIP());
        driver.findElement(By.cssSelector("input[value='Continue']")).click();
        Register.register(driver, data.getFIRSTNAME(), data.getLASTNAME(), data.getEMAIL(), data.getPASSWORD(), data.getPASSWORD());
        driver.findElement(By.cssSelector("input[value='Register']")).click();
        WebElement message = driver.findElement(By.xpath("/html/body/center/table/tbody/tr[4]/td"));
        Assert.assertEquals(message.getText(), "Account is created!", "Sign up error");
    }

    @DataProvider
    Object[][] invalidSignUpData(){
        return new Object[][]{
                //Если в поле "Confirm" введен неверный пороль, но он содержит 4 символа и более, то регистрация проходит успешно)))
                {data.getFIRSTNAME(), data.getLASTNAME(), data.getEMAIL(), data.getPASSWORD(), "321"},
                {"", data.getLASTNAME(), data.getEMAIL(), data.getPASSWORD(), data.getPASSWORD()},
                {"123", data.getLASTNAME(), data.getEMAIL(), data.getPASSWORD(), data.getPASSWORD()},
                {data.getFIRSTNAME(), data.getLASTNAME(), "!.gmail.com", data.getPASSWORD(), data.getPASSWORD()}
        };
    }

    @Test(priority = 2, dataProvider = "invalidSignUpData")
    public void negativeSignUpTest(String firstName, String lastName, String email, String pass, String conf){
        driver.findElement(By.linkText("Sign up")).click();
        driver.findElement(By.name("zip_code")).sendKeys(data.getZIP());
        driver.findElement(By.cssSelector("input[value='Continue']")).click();
        Register.register(driver, firstName, lastName, email, pass, conf);
        driver.findElement(By.cssSelector("input[value='Register']")).click();
        WebElement message = driver.findElement(By.xpath("/html/body/center/table/tbody/tr[4]/td"));
        Assert.assertEquals(message.getText(), "Oops, error on page. Some of your fields have invalid data or email was previously used",
                "Sign Up Error");
    }

}
