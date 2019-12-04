package im.atzma.lista.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

    @FindBy(xpath = "//a[@data-appointment_id]")
    List<WebElement> btn_existing_appointment;

    @FindBy(xpath = "//input[@placeholder=\"חפש שם, טלפון או הזן לקוח חדש\"]")
    WebElement input_findClient;

    @FindBy(xpath = "//span[@class='all-clients__item-name']")
    WebElement tempClient;

    @FindBy(xpath = "//p[@class='name-services']")
    WebElement tempService;

    @FindBy(xpath = "//span[@class='procedures-item__add']")
    WebElement btn_procedures_item__add;

    @FindBy(xpath = "//div[text()='Temp services_katalon']")
    WebElement temp_service;

    @FindBy(xpath = "//input[@placeholder=\"חפש טיפול או הכנס חדש\"]")
    WebElement input_findService;

    @FindBy(xpath = "//span[text()='הבא']/..")
    WebElement btn_next;

    @FindBy(xpath = "//span[text()='שמור']/..")
    WebElement btn_save;

    @FindBy(xpath = "//p[@class='event-start']")
    WebElement appointmentTime;

    @FindBy(xpath = "//div[text()= '30 דקות']")
    WebElement appointmentDuration;

    @FindBy(xpath = "//*[@class='client-name']")
    WebElement appointmentClientName;

    @FindBy(xpath = "//*[@class='service-item']")
    WebElement appointmentServiceName;

    @FindBy(xpath = "//button[@class=\"btn-styl delete\"]")
    WebElement btn_deleteAppointment;
    @FindBy(xpath = "//button[@class='btn-styl edite']")
    WebElement btn_modifyAppointment;

    @FindBy(xpath = "//button[@class=\"yes-btn\"]")
    WebElement btn_confirm_AppointmentDeletion;

    @FindBy(xpath = "//p[@class=\"floating-button standartLeft\"]")
    WebElement btn_addNewAppointment;

    @FindBy(css = ".fc-business-container")
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

    @FindBy(xpath = "//*[@class='duration__pretty-value']")
    WebElement duration_form;
    @FindBy(xpath = "//*[@class='price__pretty-value']")
    WebElement price_form;
    @FindBy(xpath = "//*[@class='price-step__procedure']")
    WebElement service_name_form;
    @FindBy(xpath = "//*[@class='date-step__time']")
    WebElement time_dur_form;
    @FindBy(xpath = "//*[@class='header__user-name']")
    WebElement appointmentClientName_form;
    @FindBy(xpath = "(//*[@class='text'])[1]")
    WebElement btn_back_form;
    @FindBy(xpath = "(//*[@class='text'])[2]")
    WebElement btn_save_form;
    @FindBy(xpath = "//span[@class='bottomnav__bottom bottomnav__bottom--next']")
    WebElement btn_save_form_2;
    @FindBy(xpath = "//input[@placeholder='הזן שם של קטגוריה חדשה']")
    WebElement inputBox_placeholder;
    @FindBy(xpath = "//button")
    WebElement btn_add_category;
    @FindBy(xpath = "//*[@class='category__list-add-procedure category__list-add-procedure--active']")
    WebElement btn_add_newCategory;
    @FindBy(xpath = "//span[text()='הוסף טיפול']/..")
    WebElement btn_add_Service;

    @FindBy(xpath = "//span[@class='popup-cross']")
    WebElement btn_x;

    @FindBy(css = "#dateInput")
    WebElement dateArea;
    @FindBy(css = "#timeInput")
    WebElement timeArea;
    @FindBy(xpath = "(//div[@class='regulation-menu-plus'])[1]")
    WebElement btn_remove_service;

    @FindBy(xpath = "//span[@class='login-err__text']")
    WebElement msg_error;

    public void test() {
        click(next_arrow);
    }


    public void createAppointment(String clientName) throws InterruptedException {
//        verifyNonbusinessDay();
        chooseAppointmentHour();
        fillNewAppointment(clientName);
    }

    public void fillNewAppointment(String name) throws InterruptedException {
        waitForElement(input_findClient);
        click(input_findClient);
        fillText(input_findClient, name);
        click(tempClient);


    }

    public void addServiceCategory(String service, String notExistCategory) throws InterruptedException {
        fillText(input_findService, service);

        waitForElement(btn_add_Service);
        System.out.println("Button text 1 : " + btn_add_Service.getText());
        click(btn_add_Service);

        fillText(inputBox_placeholder, notExistCategory);

        Thread.sleep(3000);
        waitForElement(btn_add_newCategory);
        click(btn_add_newCategory);
        System.out.println("Button text 2 : " + btn_add_newCategory.getText());

        waitForElement(btn_add_Service);
        System.out.println("Button text 3 : " + btn_add_Service.getText());
        click(btn_add_Service);


        waitForElement(btn_next);
        System.out.println("Button text 4 : " + btn_next.getText());
        click(btn_next);

        driver.navigate().refresh();
        waitForElement(btn_save);
        System.out.println("Button text 5 : " + btn_save.getText());
        click(btn_save);

        Thread.sleep(500);

    }


    public List<String> verifyAppointmentCreation() {
//        verifyNonbusinessDay();
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
//        verifyNonbusinessDay();
        clickOnExistsAppointment();
        waitForElement(btn_deleteAppointment);
        click(btn_deleteAppointment);
        waitForElement(btn_confirm_AppointmentDeletion);
        click(btn_confirm_AppointmentDeletion);

    }


    public List<String> verifyAppointmentDeletion() throws InterruptedException {
//        verifyNonbusinessDay();
        List<String> itemList = new ArrayList<>();
        if (btn_existing_appointment.size() > 0) {
            itemList.add(appointmentTime.getText());
        }
        return itemList;
    }

    public void chooseAppointmentHour() {
        driver.navigate().refresh();
        click(time_09);
    }

    public void clickOnExistsAppointment() {
        driver.navigate().refresh();
        for (int i = 0; i < btn_existing_appointment.size(); i++) {
            click(btn_existing_appointment.get(i));
        }
    }

    public void verifyNonbusinessDay() {
        if (isElementPresent(nonbusiness)) {
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
        itemList.add(btn_deleteAppointment.getText());
        itemList.add(btn_modifyAppointment.getText());
        itemList.add(btn_x.getText());

        List<WebElement> itemList2 = new ArrayList<>();
        itemList2.add(strip_name);
        itemList2.add(wrap_tel);
        itemList2.add(time_dur);
        itemList2.add(duration);
        itemList2.add(service_name);
        itemList2.add(price);
        itemList2.add(btn_deleteAppointment);
        itemList2.add(btn_modifyAppointment);
        itemList2.add(btn_x);

        for (int i = 0; i < itemList2.size(); i++) {
            highlight(itemList2.get(i));
        }

        return itemList;
    }

    public List<String> verifyForm() {
        initAppModification();

        List<String> itemList = new ArrayList<>();
        itemList.add(duration_form.getText());
        itemList.add(price_form.getText());
        itemList.add(service_name_form.getText());
        itemList.add(time_dur_form.getText());
        itemList.add(appointmentClientName_form.getText());
        itemList.add(btn_back_form.getText());
        itemList.add(btn_save_form.getText());

        List<WebElement> itemList2 = new ArrayList<>();
        itemList2.add(duration_form);
        itemList2.add(price_form);
        itemList2.add(service_name_form);
        itemList2.add(time_dur_form);
        itemList2.add(appointmentClientName_form);
        itemList2.add(btn_back_form);
        itemList2.add(btn_save_form);

        for (int i = 0; i < itemList2.size(); i++) {
            highlight(itemList2.get(i));
        }

        return itemList;
    }

    public void initAppModification() {
//        verifyNonbusinessDay();
        clickOnExistsAppointment();
        click(btn_modifyAppointment);
        click(service_name_form);
    }

    public void modifyAppTime() {
        click(time_dur_form);
        dateArea.sendKeys(Keys.ARROW_RIGHT, Keys.ARROW_UP);
        timeArea.sendKeys(Keys.ARROW_UP);
        click(btn_save_form_2);
    }

    public void modifyAppService(String tempServiceName) throws InterruptedException {


        fillText(input_findService, tempServiceName);
        Thread.sleep(1000);
        click(temp_service);
        click(btn_save_form_2);
        click(btn_save_form_2);
    }

    public void modifyServiceDuration() {
        for (int i = 0; i < 10; i++) {
            duration_form.sendKeys(Keys.ARROW_UP);
        }
    }

    public void modifyServicePrice() {
        for (int i = 0; i < 5; i++) {
            price_form.sendKeys(Keys.ARROW_UP);
            click(btn_save_form_2);

        }
    }

    public void deleteAccount() throws InterruptedException {
        driver.get("https://lista.atzma.im/he/settings");
        driver.findElement(By.xpath("//p[text()='הגדרות עסק']")).click();
        driver.findElement(By.xpath("//button[text()='למחוק את החשבון']")).click();
        driver.findElement(By.xpath("//button[@class='yes-btn']")).click();

    }

    public String verifyAccountDeletion() throws InterruptedException {
        String error = msg_error.getText();
        System.out.println(msg_error.getText());
        highlight(msg_error);

        return error;
    }
}
