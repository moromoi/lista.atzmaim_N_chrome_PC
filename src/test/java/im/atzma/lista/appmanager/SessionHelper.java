package im.atzma.lista.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Random;

public class SessionHelper extends HelperBase {

    @FindBy(xpath = "//button[text()='להיכנס']")
    WebElement btn_submit;

    @FindBy(xpath = "//div[@class='more_wrap']")
    WebElement menu_gamburger;

    @FindBy(xpath = "//button[text()='להיכנס']")
    WebElement btn_login_to_account;

    @FindBy(xpath = "//a[@href='/he/login']")
    WebElement btn_login;

    @FindBy(xpath = "//div[@class='floating-button standartLeft']")
    WebElement btn_addClient;




    Random random = new Random();
    long randomLong = random.nextLong();
    public final String mail = "katalon_" + randomLong + "@gmail.com";
    public final String pass = "Pa$$w@rd";
    String baseURL = "https://lista.atzma.im/he/home";
    String singupURL = "https://lista.atzma.im/he/signup";
    String businessURL = "https://lista.atzma.im/he/signup/business-type";
    String allsetURL= "https://lista.atzma.im/he/signup/all-set";
    String loginURL= "https://lista.atzma.im/he/login";
    String clientURL = "https://lista.atzma.im/he/clients";
    String servicesURL = "https://lista.atzma.im/he/catalog/services";
    String calendarURL = "https://lista.atzma.im/he/calendar/";
    String newClientFormURL = "https://lista.atzma.im/he/adding-client";

    public SessionHelper(WebDriver driver) {
        super(driver);
    }

    public void goToHomePage () throws InterruptedException {
        driver.get(baseURL);
        waitForLocation(baseURL);

    }
    public void goToSingupPage() throws InterruptedException {
        driver.findElement(By.xpath("//a[@href='/he/signup']")).click();
        waitForLocation(singupURL);
    }

    public void goToClientPage() throws InterruptedException {
        driver.get(clientURL);
        waitForLocation(clientURL);
    }

    public void goToServicesPage() throws InterruptedException {
        driver.get(servicesURL);
        waitForLocation(servicesURL);
    }

    public void goToCalendarPage() throws InterruptedException {
        driver.get(calendarURL);
//        waitForLocation(calendarURL);
    }

    public void typeNewPassAndUser() {
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys(mail);
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys(pass);

        System.out.println("email: " + mail);
        System.out.println("passwordd: " + pass);
    }
    public boolean submit() throws InterruptedException {
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        waitForLocation(businessURL);
        if (businessURL.equals(driver.getCurrentUrl())) {
            return true;
        }
        else return false;
    }

    public void submit2() throws InterruptedException {
        driver.findElement(By.xpath("//span[text()='בואו נתחיל!']/..")).click();
        waitForLocation(allsetURL);
    }

    public boolean submit3() throws InterruptedException {
        driver.findElement(By.xpath("//button")).click(); //-------------click on last submit button and creat account
        waitForElement(menu_gamburger); //------------- wait for menu of calendar and confirm account creation
        highlight(menu_gamburger);
        if(menu_gamburger.isDisplayed()) {
            return true;
        }
        else return false;
    }

    public void login() throws InterruptedException {
        goToHomePage();
        click(btn_login);
        waitForLocation(loginURL);
        typeNewPassAndUser();
        click(btn_submit);
    }


    public void initAddNewClient() throws InterruptedException {
        click(btn_addClient);
        waitForLocation(newClientFormURL);
    }


}
