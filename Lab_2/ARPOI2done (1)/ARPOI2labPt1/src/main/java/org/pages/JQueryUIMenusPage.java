package org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class JQueryUIMenusPage {
    WebDriver driver;
    public JQueryUIMenusPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getEnabledMenuItem() {
        return driver.findElement(By.id("ui-id-3"));
    }

    public WebElement getDownloadsMenuItem() {
        return driver.findElement(By.id("ui-id-7"));
    }

    public WebElement getExcelLink() {
        return driver.findElement(By.linkText("Excel"));
    }

    public WebElement getCsvLink() {
        return driver.findElement(By.linkText("CSV"));
    }


}
