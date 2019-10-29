package im.atzma.lista.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CalendarPage extends HelperBase{ public CalendarPage(WebDriver driver) {super(driver); }

    @FindBy(xpath = "//div[@class='more_wrap']")
    WebElement menu_gamburger;

    @FindBy(xpath = "//p[contains(text(), 'katalon')]")
    WebElement username_in_menu;

    @FindBy(xpath = "//a[@href='/he/logout']")
    WebElement btn_logout;


public boolean logout() {
    click(menu_gamburger);
    if(btn_logout.isDisplayed()) {
        click(btn_logout);
        return true;
    }
    else return false;
}

public boolean verifyUserinMenu() {
    click(menu_gamburger);
    if(username_in_menu.isDisplayed()) {
        return true;
    }
    else return false;
}
}
