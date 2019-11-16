package im.atzma.lista.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class ServicesHelper extends HelperBase {
    public ServicesHelper(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//p[text()='פגישה 30 דקות']")
    WebElement default_service_name_30min;

    @FindBy(xpath = "//p[text()='פגישה 45 דקות']")
    WebElement default_service_name_45min;

    @FindBy(xpath = "//p[text()='פגישה 60 דקות']")
    WebElement default_service_name_60min;

    @FindBy(xpath = "(//span[text()='כללית'])[1]")
    WebElement default_service_title;

    @FindBy(xpath = "(//span[text()='כללית'])[2]")
    WebElement default_service_title2;

    @FindBy(xpath = "(//span[text()='כללית'])[3]")
    WebElement default_service_title3;

    @FindBy(xpath = "(//img[@src='/public/services/ic-time-copy.svg'])[1]")
    WebElement default_img_clock;

    @FindBy(xpath = "(//img[@src='/public/services/ic-time-copy.svg'])[2]")
    WebElement default_img_clock2;

    @FindBy(xpath = "(//img[@src='/public/services/ic-time-copy.svg'])[3]")
    WebElement default_img_clock3;

    @FindBy(xpath = "(//span[text()='דקות'])[1]")
    WebElement default_text;

    @FindBy(xpath = "(//span[text()='דקות'])[2]")
    WebElement default_text2;

    @FindBy(xpath = "(//span[text()='דקות'])[3]")
    WebElement default_text3;

    @FindBy(xpath = "//span[text()='30']")
    WebElement default_service_duration_30min;

    @FindBy(xpath = "//span[text()='45']")
    WebElement default_service_duration_45min;

    @FindBy(xpath = "//span[text()='60']")
    WebElement default_service_duration_60min;

    @FindBy(xpath = "(//span[text()='₪'])[1]")
    WebElement default_text_shekel;

    @FindBy(xpath = "(//span[text()='₪'])[2]")
    WebElement default_text_shekel2;

    @FindBy(xpath = "(//span[text()='₪'])[3]")
    WebElement default_text_shekel3;

    @FindBy(xpath = "(//span[text()='0'])[1]")
    WebElement default_service_cost;

    @FindBy(xpath = "(//span[text()='0'])[2]")
    WebElement default_service_cost2;

    @FindBy(xpath = "(//span[text()='0'])[3]")
    WebElement default_service_cost3;

    @FindBy(xpath = "//label[@for='styled-checkbox-2']")
    WebElement checkbox_trash1;

    @FindBy(xpath = "//label[@for='styled-checkbox-3']")
    WebElement checkbox_trash2;

    @FindBy(xpath = "//label[@for='styled-checkbox-4']")
    WebElement checkbox_trash3;

    @FindBy(xpath = "//img[@class='trash']")
    WebElement icon_trash;

    @FindBy(xpath = "//*[@class='add-button add-rtl']")
    WebElement btn_addService;

    @FindBy(xpath = "//input[@placeholder=\"הזינו שם של טיפול...\"]")
    WebElement input_serviceName;

    @FindBy(xpath = "//span[text()='שייך לקטגוריה']")
    WebElement btn_addCategory;

    @FindBy(xpath = "//input[@placeholder=\"נא הזינו שם של קטגוריה חדשה\"]")
    WebElement input_categoryName;

    @FindBy(xpath = "//span[text()='הוסף קטגוריה חדשה']")
    WebElement btn_saveCategory;

    @FindBy(xpath = "//button[@class='bottom enabled']")
    WebElement btn_saveService;

    @FindBy(xpath = "//input[@placeholder=\"הזינו שם של טיפול\"]")
    WebElement input_findService;

    @FindBy(xpath = "//p[text()='Temp services_katalon']")
    WebElement tempService_inSearch;

    public List<WebElement> verifyDefaultService_30min() {
        List<WebElement> itemList = new ArrayList<>();
        itemList.add(default_service_name_30min);
        itemList.add(default_service_title);
        itemList.add(default_img_clock);
        itemList.add(default_text);
        itemList.add(default_service_duration_30min);
        itemList.add(default_text_shekel);
        itemList.add(default_service_cost);
        itemList.add(checkbox_trash1);

        for (int i = 0; i < itemList.size(); i++) {
            highlight(itemList.get(i));
            System.out.println("Default service elements - 30 min: " + itemList.get(i).getText());
        }
        return itemList;
    }

    public List<WebElement> verifyDefaultService_45min() {
        List<WebElement> itemList = new ArrayList<>();
        itemList.add(default_service_name_45min);
        itemList.add(default_service_title2);
        itemList.add(default_img_clock2);
        itemList.add(default_text2);
        itemList.add(default_service_duration_45min);
        itemList.add(default_text_shekel2);
        itemList.add(default_service_cost2);
        itemList.add(checkbox_trash2);

        for (int i = 0; i < itemList.size(); i++) {
            highlight(itemList.get(i));
            System.out.println("Default service element - 45min: " + itemList.get(i).getText());
        }
        return itemList;
    }

    public List<WebElement> verifyDefaultService_60min() {
        List<WebElement> itemList = new ArrayList<>();
        itemList.add(default_service_name_60min);
        itemList.add(default_service_title3);
        itemList.add(default_img_clock3);
        itemList.add(default_text3);
        itemList.add(default_service_duration_60min);
        itemList.add(default_text_shekel3);
        itemList.add(default_service_cost3);
        itemList.add(checkbox_trash3);

        for (int i = 0; i < itemList.size(); i++) {
            highlight(itemList.get(i));
            System.out.println("Default service element - 60min: " + itemList.get(i).getText());
        }
        return itemList;
    }

    public boolean verifyTrashIcon() {
        if (isElementPresent(icon_trash)) {
            return true;
        } else return false;
    }

    public boolean verifyTrashIconPresent_1() {
        click(checkbox_trash1);
        if(isElementPresent(icon_trash)) {
            click(checkbox_trash1);
            return true;
        }
        else return false;
    }

    public boolean verifyTrashIconPresent_2() {
        click(checkbox_trash2);
        if(isElementPresent(icon_trash)) {
            click(checkbox_trash2);
            return true;
        }
        else return false;
    }

    public boolean verifyTrashIconPresent_3() {
        click(checkbox_trash3);
        if(isElementPresent(icon_trash)) {
            click(checkbox_trash3);
            return true;
        }
        else return false;
    }

    public void initAddNewService() {
        click(btn_addService);
    }

    public void fillServiceFrom() throws InterruptedException {
        fillText(input_serviceName, "Temp services_katalon");
        click(btn_addCategory);
        fillText(input_categoryName, "Temp category_katalon");
        click(btn_saveCategory);
        waitForElement(btn_saveService);
        click(btn_saveService);
        waitForLocation("https://lista.atzma.im/he/catalog/services");

    }

    public String verifyTempService() {
        fillText(input_findService, "Temp services_katalon");
        highlight(tempService_inSearch);
        return tempService_inSearch.getText();
    }

}
