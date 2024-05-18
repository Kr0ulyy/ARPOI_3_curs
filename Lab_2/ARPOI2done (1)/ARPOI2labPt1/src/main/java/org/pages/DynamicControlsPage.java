package org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class DynamicControlsPage {
    public WebDriver driver;
    public DynamicControlsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    By messageBy = By.cssSelector("#message");

    @FindBy(css = "#message")
    WebElement message;

    @FindBy(css = "#btn")
    WebElement button;

    @FindBy(css= "#checkbox")
    WebElement checkbox;

    public WebElement getMessage() {
        return message;
    }

    public WebElement getRemoveButton() {
        return driver.findElement(By.xpath("//button[contains(text(), 'Remove')]"));
    }
    public WebElement getAddButton() {
        return driver.findElement(By.xpath("//button[contains(text(), 'Add')]"));
    }

    public WebElement getCheckbox() {
        return checkbox;
    }

    public By getMessageBy() {
        return messageBy;
    }

}
