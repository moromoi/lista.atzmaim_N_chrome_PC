package im.atzma.lista.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

public class ApplicationManager {
    public WebDriver driver;

    SessionHelper sessionHelper;
    SingupPage singupPage;
    BusinessPage businessPage;
    AllSetPage allSetPage;
    CalendarPage calendarPage;
    ClientListPage clientPage;
    ServicesHelper servicesHelper;
    ClientHelper clientHelper;
    AppointmentHelper appointmentHelper;


    public StringBuffer verificationErrors = new StringBuffer();
    public boolean acceptNextAlert = true;

    public void init() {

        Map<String, String> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceName", "iPhone X");

        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
        chromeOptions.addArguments(("--auto-open-devtools-for-tabs"));
        chromeOptions.addArguments("--ignore-certificate-errors");

        System.setProperty("webdriver.chrome.driver", "C:\\automation\\browser drivers\\chrome\\chromedriver.exe");
        driver = new ChromeDriver(chromeOptions);


        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();


        sessionHelper = new SessionHelper(driver);
        singupPage = new SingupPage(driver);
        businessPage = new BusinessPage(driver);
        allSetPage = new AllSetPage(driver);
        calendarPage = new CalendarPage(driver);
        clientPage = new ClientListPage(driver);
        servicesHelper = new ServicesHelper(driver);
        clientHelper = new ClientHelper(driver);
        appointmentHelper = new AppointmentHelper(driver);
    }


    public void deleteAccount() throws InterruptedException {
        Thread.sleep(1000);
        driver.get("https://lista.atzma.im/he/settings");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//p[text()='הגדרות עסק']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[text()='למחוק את החשבון']")).click();
        driver.findElement(By.xpath("//button[@class='yes-btn']")).click();
        Thread.sleep(1000);
    }

    public void stop() {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }


    public SessionHelper getSessionHelper() {
        return sessionHelper;
    }
    public SingupPage getSingupPage() { return singupPage; }
    public BusinessPage getBusinessPage() { return businessPage; }
    public AllSetPage getAllSetPage() { return allSetPage; }
    public CalendarPage getCalendarPage() { return calendarPage; }
    public ClientListPage getClientPage() { return clientPage; }
    public ServicesHelper getServicesHelper() { return servicesHelper; }
    public ClientHelper getClientHelper() {return  clientHelper; }
    public AppointmentHelper getAppointmentHelper() {return  appointmentHelper;}
}
