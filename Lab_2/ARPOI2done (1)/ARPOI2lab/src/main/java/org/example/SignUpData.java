package org.example;

import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Data
public class SignUpData {
    private final String ZIP = "94213";
    private final String FIRSTNAME = "Viktor";
    private final String LASTNAME = "Zhaburonok";
    private final String EMAIL = "viktor.zhaburonok2@gmail.com";
    private final String PASSWORD = "TestPass123";
    private final String AUTO_LOGIN_PASSWORD = "1111";
    private final String EMAILXPATH = "/html/body/center/table/tbody/tr/td/center/table/tbody/tr[2]/td[3]/span/b";
    private static String TESTEMAIL;
    public void setTesterEmailFromPage(WebDriver driver) {
        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElement(By.linkText("Test Portal")).click();
        driver.findElement(By.linkText("Account Creator")).click();
        driver.findElement(By.cssSelector("input[value='Create new user account']")).click();
        TESTEMAIL = driver.findElement(By.xpath(EMAILXPATH)).getText();
    }
    public String getTESTEMAIL(){
        return TESTEMAIL;
    }

}
