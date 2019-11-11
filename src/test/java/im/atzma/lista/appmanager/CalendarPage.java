package im.atzma.lista.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class CalendarPage extends HelperBase{ public CalendarPage(WebDriver driver) {super(driver); }

    @FindBy(xpath = "//div[@class='more_wrap']")
    WebElement menu_gamburger;

    @FindBy(xpath = "//p[contains(text(), 'katalon')]")
    WebElement username_in_menu;

    @FindBy(xpath = "//a[@href='/he/logout']")
    WebElement btn_logout;

    @FindBy(xpath = "//p[@class='business_name']")
    WebElement text_businessName;

    @FindBy(xpath = "//p[@class='business_address']")
    WebElement text_businessAddress;

    @FindBy(xpath = "//a[@href=\"/he/calendar\"]")
    WebElement text_calendar;

    @FindBy(xpath = "//a[@href=\"/he/clients\"]")
    WebElement text_clientDB;


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

    public List<WebElement> verifyMenuLinks() {
    click(menu_gamburger);
        List<WebElement> itemList = new ArrayList<>();
        itemList.add(text_businessName);
        itemList.add(text_businessAddress);
        itemList.add(text_calendar);
        itemList.add(text_clientDB);

        for (int i = 0; i < itemList.size(); i++) {
            highlight(itemList.get(i));
            System.out.println("MenuTest item " + i + "-"  + itemList.get(i).getText());
        }
        return itemList;
    }

    public void fillClientForm() {

    }
}
