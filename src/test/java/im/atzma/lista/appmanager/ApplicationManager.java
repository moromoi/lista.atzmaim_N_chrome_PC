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

    public StringBuffer verificationErrors = new StringBuffer();
    public boolean acceptNextAlert = true;

    public void init() {
        Map<String, String> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceName", "iPhone X");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);

        System.setProperty("webdriver.chrome.driver", "C:\\automation\\browser drivers\\chrome\\chromedriver.exe");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        sessionHelper = new SessionHelper(driver);
        singupPage = new SingupPage(driver);

    }


    public void deleteAccount() throws InterruptedException {
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

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }


    public SessionHelper getSessionHelper() {
        return sessionHelper;
    }
    public SingupPage getSingupPage() {return singupPage; }
}
