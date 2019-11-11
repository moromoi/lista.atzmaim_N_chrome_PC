package im.atzma.lista.appmanager;

import im.atzma.lista.model.ClientData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
    WebElement radio_sex;

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

    @FindBy(xpath = "//h1[text()='Temp Client katalon']")
    WebElement title_newClientName;


    public ClientHelper(WebDriver driver) { super(driver); }

    public void fillClientForm(ClientData clientData) throws InterruptedException {
        fillText(text_clientName, clientData.getTempClientName());
        fillText(text_telephon, clientData.getTelNumber());
        fillText(text_email, clientData.getEmail());
        fillText(text_address, clientData.getAddress());
        select(select_year, "1950");
        select(select_month, "10");
        select(select_day, "10");
        click(radio_sex);
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
}
