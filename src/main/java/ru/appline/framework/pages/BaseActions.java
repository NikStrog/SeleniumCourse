package ru.appline.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.appline.framework.managers.DriverManager;

import java.time.Duration;

public class BaseActions {

    protected DriverManager driverManager = DriverManager.getDriverManager();
    protected WebDriverWait wait = new WebDriverWait(driverManager.getDriver(), Duration.ofSeconds(10), Duration.ofSeconds(2));


    @FindBy(xpath = "/html/body/div[4]")
    private WebElement load;
    public void loadCheckout(){
        wait.until(ExpectedConditions.invisibilityOf(load));
    }

    protected void fillInputField(WebElement field, String value){
        field.clear();
        field.sendKeys(value);
    }
}
