package im.atzma.lista.appmanager;

import im.atzma.lista.model.ClientData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class ClientHelper extends HelperBase{

    @FindBy(xpath = "//input[@placeholder=\"הזן שם של לקוח\"]")
    WebElement text_clientName;

    @FindBy(xpath = "//input[@class=\"input-active\"]")
    WebElement text_telephon;

    @FindBy(xpath = "//input[@placeholder=\"הזן אימייל של לקוח\"]")
    WebElement text_email;

    @FindBy(xpath = "//input[@placeholder=\"הזן כתובת של לקוח\"]")
    WebElement text_address;

    @FindBy(xpath = "//select[1]")
    WebElement select_year;

    @FindBy(xpath = "//select[2]")
    WebElement select_month;

    @FindBy(xpath = "//select[3]")
    WebElement select_day;

    @FindBy(xpath = "//input[@value='male']")
    WebElement radio_sex_male;

    @FindBy(xpath = "//input[@value='female']")
    WebElement radio_sex_female;

    @FindBy(xpath = "//label[text()='להסיף הערה חדשה']")
    WebElement btn_addNote;

    @FindBy(xpath = "//textarea[@placeholder=\"תיאור\"]")
    WebElement area_note;

    @FindBy(xpath = "//button[@class=\"save\"]")
    WebElement btn_saveNote;

    @FindBy(xpath = "//span[text()=\"להוסיף חוב חדש\"]")
    WebElement btn_addDebt;

    @FindBy(xpath = "//img[@src='/public/adding-client/plus.svg']")
    WebElement btn_plus_debt;

    @FindBy(xpath = "//input[@placeholder=\"תיאור חוב\"]")
    WebElement area_debt;

    @FindBy(xpath = "//div[@id='debts']//p[text()='שמור']")
    WebElement btn_saveDebtNote;

    @FindBy(css=".bot-button")
    WebElement btn_saveClientForm;

    @FindBy(xpath = "//*[@class='client-name']/h1")
    WebElement title_newClientName;

    @FindBy(xpath = "//span[text()='חזור']")
    WebElement btn_back;

    @FindBy(xpath = "//h1[text()='לקוח חדש']")
    WebElement title_newclient;

    @FindBy(xpath = "//span[text()='שמור']")
    WebElement btn_save;

    @FindBy(xpath = "//span[text()='יום הולדת:']")
    WebElement title_birthday;

    @FindBy(xpath = "//span[text()='מין:']")
    WebElement title_sex;

    @FindBy(xpath = "//input[@placeholder=\"הזן שם של לקוח\"]")
    WebElement input_name;

    @FindBy(xpath = "//input[@class=\"input-active\"]")
    WebElement input_telephon;

    @FindBy(xpath = "//input[@placeholder=\"הזן אימייל של לקוח\"]")
    WebElement input_email;

    @FindBy(xpath = "//input[@placeholder=\"הזן כתובת של לקוח\"]")
    WebElement input_address;

    @FindBy(xpath = "//img[@src=\"/public/adding-client/group2.svg\"]")
    WebElement icon_1;
    @FindBy(xpath = "//img[@src=\"/public/adding-client/group3.svg\"]")
    WebElement icon_2;
    @FindBy(xpath = "//img[@src=\"/public/adding-client/group5.svg\"]")
    WebElement icon_3;
    @FindBy(xpath = "//img[@src=\"/public/adding-client/group6.svg\"]")
    WebElement icon_4;

    @FindBy(xpath = "(//img[@src=\"/public/adding-client/c_add_stroke.svg\"])[1]")
    WebElement btn_plus_1;
    @FindBy(xpath = "(//img[@src=\"/public/adding-client/c_add_stroke.svg\"])[2]")
    WebElement btn_plus_2;

    @FindBy(xpath = "//div[@class='bot-button']")
    WebElement btn_save_down;


    public ClientHelper(WebDriver driver) { super(driver); }

    int count = 0;

    public void fillClientForm(ClientData clientData) throws InterruptedException {
        fillText(text_clientName, clientData.getTempClientName());
        fillText(text_telephon, clientData.getTelNumber());
        fillText(text_email, clientData.getEmail());
        fillText(text_address, clientData.getAddress());
        select(select_year, "1950");
        select(select_month, "10");
        select(select_day, "10");
        click(radio_sex_male);
        click(btn_addNote);
        waitForElement(area_note);
        fillText(area_note, "הערות של לקוח זמני");
        click(btn_saveNote);
        click(btn_addDebt);
        click(btn_plus_debt);
        fillText(area_debt, "חוב  של לקוח זמני");
        click(btn_saveDebtNote);
        click(btn_saveClientForm);
        Thread.sleep(2000);
    }

    public String verifyNewClientCreation() {
        highlight(title_newClientName);
        System.out.println("Name of ew client: " + title_newClientName);
        return title_newClientName.getText();
    }

    public Integer verifyNewClientForm() {
        List<WebElement> itemList = new ArrayList<>();
        itemList.add(btn_back);
        itemList.add(btn_save);
        itemList.add(title_newclient);
        itemList.add(title_birthday);
        itemList.add(title_sex);
        itemList.add(input_name);
        itemList.add(input_address);
        itemList.add(input_email);
        itemList.add(input_telephon);
        itemList.add(radio_sex_male);
        itemList.add(radio_sex_female);
        itemList.add(icon_1);
        itemList.add(icon_2);
        itemList.add(icon_3);
        itemList.add(icon_4);
        itemList.add(btn_addNote);
        itemList.add(btn_addDebt);
        itemList.add(btn_plus_1);
        itemList.add(btn_plus_2);
        itemList.add(btn_save_down);

        for (int i = 0; i < itemList.size(); i++) {
            highlight(itemList.get(i));
            if(itemList.get(i).isDisplayed()) {
                count++;
            }
        }
        return count;
    }
}
