package im.atzma.lista.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class CalendarPage extends HelperBase {
    public CalendarPage(WebDriver driver) {
        super(driver);
    }

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

    @FindBy(xpath = "//tr[@data-time=\"13:00:00\"]")
    WebElement time_13;

    @FindBy(xpath = "//input[@placeholder=\"חפש שם, טלפון או הזן לקוח חדש\"]")
    WebElement input_findClient;

    @FindBy(xpath = "//a[text()='0547019283']/../../..")
    WebElement tempClient;

    @FindBy(xpath = "//div[@class='procedures-item-quantity']/..")
    WebElement tempService;

    @FindBy(xpath = "//input[@placeholder=\"חפש טיפול או הכנס חדש\"]")
    WebElement input_findService;

    @FindBy(xpath = "//span[text()='הבא']/..")
    WebElement btn_next;

    @FindBy(xpath = "//span[text()='שמור']/..")
    WebElement btn_save;

    @FindBy(xpath = "//p[text()= '13:00 - 13:30']")
    WebElement appointmentTime;

    @FindBy(xpath = "//div[text()= '30 דקות']")
    WebElement appointmentDuration;

    @FindBy(xpath = "//p[text()= 'Temp Client katalon']")
    WebElement appointmentClientName;

    @FindBy(xpath = "//span[text()= 'Test טיפול services_katalon']")
    WebElement appointmentServiceName;



    public boolean logout() {
        click(menu_gamburger);
        if (btn_logout.isDisplayed()) {
            click(btn_logout);
            return true;
        } else return false;
    }

    public boolean verifyUserinMenu() {
        click(menu_gamburger);
        if (username_in_menu.isDisplayed()) {
            return true;
        } else return false;
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
            System.out.println("MenuTest item " + i + "-" + itemList.get(i).getText());
        }
        return itemList;
    }

    public void chooseAppointmentHour() {
        click(time_13);
    }

    public void fillNewAppointment() throws InterruptedException {
        waitForElement(input_findClient);
        fillText(input_findClient, "Temp Client katalon");
        click(tempClient);
        fillText(input_findService, "Test טיפול services_katalon");
        click(tempService);
        click(btn_next);
        click(btn_save);
    }

    public List<String> verifyAppointmentCreation() {
        List<String>  itemList = new ArrayList<>();
        itemList.add(appointmentTime.getText());
        itemList.add(appointmentClientName.getText());
        itemList.add(appointmentServiceName.getText());
        itemList.add(appointmentDuration.getText());

        for (int i = 0; i < itemList.size(); i++) {
            System.out.println(itemList.get(i));
        }

        return itemList;
    }
}
