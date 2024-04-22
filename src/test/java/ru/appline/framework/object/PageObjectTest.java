package ru.appline.framework.object;


import org.junit.Test;
import org.openqa.selenium.WebElement;
import ru.appline.framework.basetests.BaseTest;
import ru.appline.framework.pages.Auth;
import ru.appline.framework.pages.BusinessTripsPage;
import ru.appline.framework.pages.StartPage;

public class PageObjectTest extends BaseTest {

    StartPage startPage = new StartPage();
    BusinessTripsPage businessTrip = new BusinessTripsPage();
    Auth auth = new Auth();

    @Test
    public void pageObjectTest(){

        //Авторизация
        auth.setAuthInputFields("Prohorova Alla", "testing");

        //startPage.pageCheck();
        startPage.selectMenuButton("Расходы");
        startPage.selectSubMenuButton("Командировки");


        //businessTrip.checkPage();

    }


}
