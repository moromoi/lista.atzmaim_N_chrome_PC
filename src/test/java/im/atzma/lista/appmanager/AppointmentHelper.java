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

    @FindBy(xpath = "//div[@class=\"click-mask\"]")
    List<WebElement> btn_existing_appointment;

    @FindBy(xpath = "//input[@placeholder=\"חפש שם, טלפון או הזן לקוח חדש\"]")
    WebElement input_findClient;

    @FindBy(xpath = "//a[text()='0547019283']/../../..")
    WebElement tempClient;

    @FindBy(xpath = "//*[text()='Temp services_katalon']")
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

    @FindBy(xpath = "//*[@class='strip-name']/p")
    WebElement strip_name;
    @FindBy(xpath = "//*[@class='wrap-tel']//span")
    WebElement wrap_tel;
    @FindBy(xpath = "//*[@class='time-dur']/p")
    WebElement time_dur;
    @FindBy(xpath = "//*[@class='duration']/div")
    WebElement duration;
    @FindBy(xpath = "//*[@class='service-name']//p")
    WebElement service_name;
    @FindBy(xpath = "//*[@class='price']/span")
    WebElement price;


    public void test() {
        click(next_arrow);
    }


    public void createAppointment() throws InterruptedException {
        verifyNonbusinessDay();
        chooseAppointmentHour();
        fillNewAppointment();
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
        verifyNonbusinessDay();
        clickOnExistsAppointment();
        waitForElement(btn_deleteAppointment);
        click(btn_deleteAppointment);
        waitForElement(btn_confirm_AppointmentDeletion);
        click(btn_confirm_AppointmentDeletion);

    }


    public boolean verifyAppointmentDeletion() throws InterruptedException {
        verifyNonbusinessDay();
        if (btn_existing_appointment.size() > 0) {
            return false;
        }
        return true;
    }

    public void chooseAppointmentHour() {
        click(time_09);
    }

    public void clickOnExistsAppointment() {
        for (int i = 0; i < btn_existing_appointment.size(); i++) {
            click(btn_existing_appointment.get(i));
        }
    }

    public void verifyNonbusinessDay() {
        if (!isElementPresent(nonbusiness)) {
            click(back_arrow);
        }
    }

    public List<String> verifyAppointmentElements() {
        List<String> itemList = new ArrayList<>();
        itemList.add(strip_name.getText());
        itemList.add(wrap_tel.getText());
        itemList.add(time_dur.getText());
        itemList.add(duration.getText());
        itemList.add(service_name.getText());
        itemList.add(price.getText());

        List<WebElement> itemList2 = new ArrayList<>();
        itemList2.add(strip_name);
        itemList2.add(wrap_tel);
        itemList2.add(time_dur);
        itemList2.add(duration);
        itemList2.add(service_name);
        itemList2.add(price);
        for (int i = 0; i < itemList2.size(); i++) {
            highlight(itemList2.get(i));
        }

        return itemList;
    }
}
