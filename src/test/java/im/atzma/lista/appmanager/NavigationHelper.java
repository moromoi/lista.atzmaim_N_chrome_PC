package im.atzma.lista.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Random;

public class NavigationHelper extends HelperBase {
    @FindBy(xpath = "//input[@type='email']")
    WebElement input_email;

    @FindBy(xpath = "//input[@type='password']")
    WebElement input_password;

    @FindBy(xpath = "//button[text()='להיכנס']")
    WebElement btn_submit;

    @FindBy(xpath = "//div[@class='more_wrap']")
    WebElement menu_gamburger;

    @FindBy(xpath = "//button[text()='להיכנס']")
    WebElement btn_login_to_account;

    @FindBy(xpath = "//a[@href='/he/login']")
    WebElement btn_login;



    Random random = new Random();
    long randomLong = random.nextLong();
    public final String mail_2 = "katalon13@gmail.com";
    public final String mail = "katalon_" + randomLong + "@gmail.com";
    public final String pass = "Pa$$w@rd";
    String baseURL = "https://lista.atzma.im/he/home?utm_source=autotest-selenium";
    String singupURL = "https://lista.atzma.im/he/signup?utm_source=autotest-selenium";
    String businessURL = "https://lista.atzma.im/he/signup/business-type";
    String allsetURL = "https://lista.atzma.im/he/signup/all-set";
    String loginURL = "https://lista.atzma.im/he/login";
    String clientURL = "https://lista.atzma.im/he/clients";
    String servicesURL = "https://lista.atzma.im/he/catalog/services";
    String calendarURL = "https://lista.atzma.im/he/calendar/";
    String newClientFormURL = "https://lista.atzma.im/he/adding-client";

    public NavigationHelper(WebDriver driver) {
        super(driver);
    }

    public void homePage() throws InterruptedException {
        driver.get(baseURL);
        waitForLocation(baseURL);
    }

    public void goToLoginPage() throws InterruptedException {
        driver.get(loginURL);
    }

    public void singupPage() throws InterruptedException {
        driver.findElement(By.xpath("//a[@href='/he/signup?utm_source=autotest-selenium']")).click();
        waitForLocation(singupURL);
    }

    public void clientPage() throws InterruptedException {
        driver.get(clientURL);
        waitForLocation(clientURL);
    }

    public void servicesPage() throws InterruptedException {
        driver.get(servicesURL);
        waitForLocation(servicesURL);
    }

    public void calendarPage() throws InterruptedException {
        driver.get(calendarURL);
//        waitForLocation(calendarURL);
    }

    public void typeNewPassAndUser() throws InterruptedException {
        fillText(input_email, mail_2);
        fillText(input_password, pass);

        System.out.println("email: " + mail);
        System.out.println("password: " + pass);
    }

    public boolean submit() throws InterruptedException {
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        waitForLocation(businessURL);
        if (businessURL.equals(driver.getCurrentUrl())) {
            return true;
        } else return false;
    }

    public void submit2() throws InterruptedException {
        driver.findElement(By.xpath("//span[text()='בואו נתחיל!']/..")).click();
        waitForLocation(allsetURL);
    }

    public boolean submit3() throws InterruptedException {
        driver.findElement(By.xpath("//button")).click(); //-------------click on last submit button and creat account
        waitForElement(menu_gamburger); //------------- wait for menu of calendar and confirm account creation
        highlight(menu_gamburger);
        if (menu_gamburger.isDisplayed()) {
            return true;
        } else return false;
    }

    public void login() throws InterruptedException {
        homePage();
        highlight(btn_login);
        click(btn_login);
        waitForLocation(loginURL);
        typeNewPassAndUser();
        click(btn_submit);
    }



    public boolean verifyEmailInput() {
        if (input_email.isDisplayed()) {
            highlight(input_email);
            return true;
        } else {
            return false;
        }
    }


    public boolean verifyPasswordInput() {
        if (input_password.isDisplayed()) {
            highlight(input_password);
            return true;
        } else {
            return false;
        }
    }
}