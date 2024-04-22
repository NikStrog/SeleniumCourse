package ru.appline.framework.pages;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BusinessTripCreation extends BaseActions{

    public BusinessTripCreation(){
        PageFactory.initElements(driverManager.getDriver(), this);
    }

    @FindBy(xpath = "//select[contains(@data-name, 'field__business-unit')]")
    private WebElement departmentListButton;
    public void setDepartmentListClick(){
        departmentListButton.click();
    }

    @FindBy(xpath = "//select[contains(@data-name, 'field__business-unit')]/option")
    private List<WebElement> departmentList;

    /**
     * Выбрать отдел из списка
     * @param departmentName - название отдела
     */
    public void departmentChoose(String departmentName){
        for (WebElement element:departmentList) {
            if(element.getText().equals(departmentName)){
                element.click();
                return;
            }
            else Assert.fail("Отдел " + departmentName + " не найден");
        }
    }

    @FindBy(xpath = "//a[text()='Открыть список']")
    private WebElement openListButton;
    public void openListButtonClick(){
        openListButton.click();
    }

    @FindBy(xpath = "//span[text()='Укажите организацию']")
    private WebElement chooseOrganization;
    public void setChooseOrganizationClick(){
        chooseOrganization.click();
    }


    @FindBy(xpath = "//input[@type = 'text' and @spellcheck]")
    private WebElement organizationInputField;

    /**
     * Ввод названия организации
     * @param organizationName - название организации
     */
    public void organizationInput(String organizationName){
        organizationInputField.sendKeys(organizationName);
    }

    @FindBy(xpath = "//*[@id=select2-drop]/ul[2]/li/div")
    private WebElement organizationChoose;
    public void organizationClick(){
        organizationChoose.click();
    }

    @FindBy(xpath = "//div[@class = 'controls']/div[@class = 'horizontal validate-group']//input[@type = 'checkbox']")
    private List<WebElement> tasksList;
    public void taskChoose(String taskName){
        for (WebElement task:tasksList) {
            if(task.getText().equals(taskName)){
                task.click();
            }
            else Assert.fail("Задача " + taskName + " не найдена");
        }
    }

    @FindBy(xpath = "//input[contains(@id, 'City')]")
    private List<WebElement> cityEnterFieldList;

    public void setCity(String departureCity, String arrivalCity){
        for (WebElement i:cityEnterFieldList) {
            if(i.findElement(By.xpath("/../..//label[text() = 'Город выбытия']")).getText().equals("Город выбытия")){
                fillInputField(i, departureCity);
                return;
            }
            else if (i.findElement(By.xpath("/../..//label[text() = 'Город прибытия']")).getText().equals("Город прибытия")){
                fillInputField(i, arrivalCity);
            }
        }
    }

    @FindBy(xpath = "//input[contains(@id, 'Date') and @placeholder = 'Укажите дату']")
    private List<WebElement> dateEnterList;
    public void setDate(String departureDate, String arrivalDate){
        for (WebElement y:dateEnterList) {
            if(y.findElement(By.xpath("/../..//label[text() = 'Планируемая дата выезда']")).getText().equals("Планируемая дата выезда")){
                fillInputField(y, departureDate);
                return;
            }
            else if (y.findElement(By.xpath("/../..//label[text() = 'Планируемая дата возвращения']")).getText().equals("Планируемая дата возвращения")){
                fillInputField(y, arrivalDate);
            }
        }
    }

    @FindBy(xpath = "//button[contains(text(), 'Сохранить') and contains(@class, 'main')]")
    private WebElement savePageButton;
    public void savePage(){
        savePageButton.click();
    }

    @FindBy(xpath = "//button[contains(text(), 'Сохранить и закрыть')]")
    private WebElement saveAndClosePageButton;
    public void saveAndClosePage(){
        saveAndClosePageButton.click();
    }


}