package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Register {
    public static void register(WebDriver driver, String firstName, String lastName, String email, String pass1, String pass2){
        driver.findElement(By.name("first_name")).sendKeys(firstName);
        driver.findElement(By.name("last_name")).sendKeys(lastName);
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password1")).sendKeys(pass1);
        driver.findElement(By.name("password2")).sendKeys(pass2);
    }
}
