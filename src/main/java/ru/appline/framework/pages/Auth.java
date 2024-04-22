package ru.appline.framework.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.appline.framework.managers.DriverManager;

import java.time.Duration;
import java.util.List;

public class Auth extends BaseActions{

    @FindBy(xpath = "//fieldset//input[contains(@id, 'prepended')]")
    private List<WebElement> authInputFields;

    public Auth(){
        PageFactory.initElements(driverManager.getDriver(), this);
    }
    public void setAuthInputFields(String login, String password){
        for (WebElement q:authInputFields) {
            if(q.getAttribute("placeholder").equals(login)){
                fillInputField(q, "Prohorova Alla");
                return;
            }
            else if(q.getAttribute("placeholder").equals(password)){
                fillInputField(q, "testing");
            }
        }
    }

}

