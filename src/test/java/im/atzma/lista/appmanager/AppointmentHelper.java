package im.atzma.lista.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class AppointmentHelper extends HelperBase {
    public AppointmentHelper(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//tr[@data-time=\"09:00:00\"]")
    WebElement time_09;
    @FindBy(xpath = "//tr[@data-time=\"10:00:00\"]")
    WebElement time_10;
    @FindBy(xpath = "//tr[@data-time=\"11:00:00\"]")
    WebElement time_11;
    @FindBy(xpath = "//tr[@data-time=\"12:00:00\"]")
    WebElement time_12;
    @FindBy(xpath = "//tr[@data-time=\"13:00:00\"]")
    WebElement time_13;
    @FindBy(xpath = "//tr[@data-time=\"14:00:00\"]")
    WebElement time_14;
    @FindBy(xpath = "//tr[@data-time=\"15:00:00\"]")
    WebElement time_15;
    @FindBy(xpath = "//tr[@data-time=\"16:00:00\"]")
    WebElement time_16;
    @FindBy(xpath = "//tr[@data-time=\"17:00:00\"]")
    WebElement time_17;
    @FindBy(xpath = "//tr[@data-time=\"18:00:00\"]")
    WebElement time_18;
    @FindBy(xpath = "//tr[@data-time=\"19:00:00\"]")
    WebElement time_19;
    @FindBy(xpath = "//tr[@data-time=\"20:00:00\"]")
    WebElement time_20;

    @FindBy(xpath = "//div[@class=\"click-mask\"]")
    List<WebElement> btn_existing_appointment;

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

    @FindBy(xpath = "//p[text()= '09:00 - 09:30']")
    WebElement appointmentTime;

    @FindBy(xpath = "//div[text()= '30 דקות']")
    WebElement appointmentDuration;

    @FindBy(xpath = "//p[text()= 'Temp Client katalon']")
    WebElement appointmentClientName;

    @FindBy(xpath = "//span[text()= 'Temp services_katalon']")
    WebElement appointmentServiceName;

    @FindBy(xpath = "//button[@class=\"btn-styl delete\"]")
    WebElement btn_deleteAppointment;

    @FindBy(xpath = "//button[@class=\"yes-btn\"]")
    WebElement btn_confirm_AppointmentDeletion;

    @FindBy(xpath = "//p[@class=\"floating-button standartLeft\"]")
    WebElement btn_addNewAppointment;

    @FindBy(css = ".fc-nonbusiness.fc-bgevent")
   WebElement nonbusiness;

    @FindBy(xpath = "//div[@class='prev_button_wrap common']")
    WebElement back_arrow;

    @FindBy(xpath = "//div[@class='next_button_wrap common']")
    WebElement next_arrow;


    public void createAppointment() throws InterruptedException {
        if (isElementPresent(nonbusiness)) {
            click(time_09);
            fillNewAppointment();
        }
        else {
            click(back_arrow);

        }
    }

    public void fillNewAppointment() throws InterruptedException {
        waitForElement(input_findClient);
        click(input_findClient);
        fillText(input_findClient, "Temp Client katalon");
        waitForElement(tempClient);
        click(tempClient);
        waitForElement(input_findService);
        click(input_findService);
        fillText(input_findService, "Temp services_katalon");
        waitForElement(tempService);
        click(tempService);
        click(btn_next);
        click(btn_save);
    }

    public List<String> verifyAppointmentCreation() {
        List<String> itemList = new ArrayList<>();
        itemList.add(appointmentTime.getText());
        itemList.add(appointmentClientName.getText());
        itemList.add(appointmentServiceName.getText());
        itemList.add(appointmentDuration.getText());

        for (int i = 0; i < itemList.size(); i++) {
            System.out.println(itemList.get(i));
        }

        return itemList;
    }

    public void deleteAppointment() throws InterruptedException {

        click(btn_existing_appointment.get(0));
        waitForElement(btn_deleteAppointment);
        click(btn_deleteAppointment);
        waitForElement(btn_confirm_AppointmentDeletion);
        click(btn_confirm_AppointmentDeletion);

    }


    public boolean verifyAppointmentDeletion() throws InterruptedException {
        if (!isElementPresent(nonbusiness)) {
            click(back_arrow);
        }
        if (btn_existing_appointment.size() > 0) {
            return false;
        }
        return true;
    }
}
