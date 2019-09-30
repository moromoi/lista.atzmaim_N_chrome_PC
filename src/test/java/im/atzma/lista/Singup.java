package im.atzma.lista;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;

import static org.testng.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Singup {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    Random random = new Random();
    long randomLong = random.nextLong();
    String baseURL = "https://lista.atzma.im/he/home";

    String mail = "katalon_" + randomLong + "@gmail.com";
    String pass = "Pa$$w@rd";


    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        Map<String, String> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceName", "iPhone X");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);

        System.setProperty("webdriver.chrome.driver", "C:\\automation\\browser drivers\\chrome\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }


    @Test(priority = 1)
    public void testGoToSignUpPage() throws Exception {
        driver.get(baseURL);
        driver.findElement(By.xpath("//a[@href='/he/signup']")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://lista.atzma.im/he/signup");
    }

    @Test(priority = 2)
    public void testVerifySignupPageElements() throws Exception {
        Assert.assertTrue(driver.findElement(By.xpath("//li[text()='ru']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[text()='en']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[text()='he']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//img[@src=\"/public/signup/media/logo.svg\"]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//div[text()='מלא פרטים כדי לצור חשבון:']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//input[@placeholder=\"הזן את האימיייל שלך\"]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//input[@placeholder=\"הזן את הססמא שלך\"]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//button[text()='המשך']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//img[@src=\"/public/signup/media/mail.svg\"]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//button[@type='submit']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//img[@src=\"/public/signup/media/lock.svg\"]")).isDisplayed());

    }

    @Test(priority = 3)
    public void testRegisterNewUser() throws Exception {
        driver.findElement(By.xpath("//input[@type='email']")).clear();
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys(mail);

        driver.findElement(By.xpath("//input[@type='password']")).sendKeys(pass);

        Assert.assertTrue(driver.findElement(By.xpath("//img[@src=\"/public/signup/media/eye.svg\"]")).isDisplayed());
        driver.findElement(By.xpath("//img[@src=\"/public/signup/media/eye.svg\"]")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='group password ']//input[@type='text']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//img[@src=\"/public/signup/media/eye-off.svg\"]")).isDisplayed());

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://lista.atzma.im/he/signup/business-type");

    }


    @Test(priority = 4)
    public void testVerifyBusinessTypePageElements() throws Exception {
        Thread.sleep(300);
        Assert.assertTrue(driver.findElement(By.xpath("//img[@src=\"/public/signup/media/ic_back.svg\"]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//img[@src=\"/public/signup/media/business_types_icons/one-on-one_meetings.svg\"]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//img[@src=\"/public/signup/media/business_types_icons/hair_styling.svg\"]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//div[text()='נא לבחור סוג העסק']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//div[text()='אנחנו נתאים את האפליקציה לצרכים שלך']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//div[text()='אתם יכולים לבחור יותר מאחד או']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//button[text()='לדלג הלאה']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//span[text()='בואו נתחיל!']")).isDisplayed());

    }


    @Test(priority = 5)
    public void testCheckInBussnessType() throws Exception {
        driver.findElement(By.xpath("//div[@class='bussiness-type']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[text()='בחרת ב:']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//span[text()='עצמאי']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//img[@src=\"/public/signup/media/business_types_icons/violet-one-on-one_meetings.svg\"]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='bussiness-type__checkmark']")).isDisplayed());
        driver.findElement(By.xpath("//span[text()='בואו נתחיל!']/..")).click();

    }

    @Test(priority = 6)
    public void testVerifyAllSetPageElements() throws Exception {
        for (int second = 0; ; second++) {
            if (second >= 60) fail("timeout");
            try {
                if ("https://lista.atzma.im/he/signup/all-set".equals(driver.getCurrentUrl())) break;
            } catch (Exception e) {
            }
            Thread.sleep(1000);
        }

        Assert.assertTrue(driver.findElement(By.xpath("//img[@src=\"/public/signup/media/ic_back.svg\"]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//img[@src=\"/public/signup/media/sing-up-img.png\"]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//div[text()='אנחנו סיימנו כאן!']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//span[text()='תודה על שיתוף הפעולה']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//span[text()='עכשיו אתם יכולים להתחיל ליהנות משימוש באפליקציה']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//span[text()='אנחנו הולכים לשלוח מידע חשוב וטיפים על שימוש באפליקציה, אתם מסכימים לזה?']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//span[text()='אני מסכים לתנאי הסכם שימוש של אפליקציה Atzma.im CRM']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//label[@for=\"twice\"]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//label[@for=\"first\"]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//span[text()='בואו נתחיל!']")).isDisplayed());

        driver.findElement(By.xpath("//label[@for=\"twice\"]/span")).click();
        driver.findElement(By.xpath("//button")).click();
        for (int second = 0; ; second++) {
            if (second >= 60) fail("timeout");
            try {
                if (driver.findElement(By.xpath("//div[@class='more_wrap']")).isDisplayed()) break;
            } catch (Exception e) {
            }
            Thread.sleep(1000);

        }
    }


    @Test(priority = 7)
    public void testLogOut() throws Exception {
        driver.findElement(By.xpath("//div[@class='more_wrap']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(), 'katalon')]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//a[@href=\"/he/logout\"]")).isDisplayed());
        driver.findElement(By.xpath("//a[@href=\"/he/logout\"]")).click();

    }

    @Test(priority = 8)
    public void testVerifyLoginWithNewUser() throws Exception {
        Assert.assertEquals(driver.getCurrentUrl(), "https://lista.atzma.im/he/login");

        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys(mail);
        driver.findElement(By.name("pass")).clear();
        driver.findElement(By.name("pass")).sendKeys(pass);
        driver.findElement(By.xpath("//button[text()='להיכנס']")).click();
        for (int second = 0; ; second++) {
            if (second >= 60) fail("timeout");
            try {
                if (driver.findElement(By.xpath("//div[@class='more_wrap']")).isDisplayed()) break;
            } catch (Exception e) {
            }
            Thread.sleep(1000);
        }
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='more_wrap']")).isDisplayed());

        driver.findElement(By.xpath("//div[@class='more_wrap']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(), 'katalon')]")).isDisplayed());
    }

    @Test(priority = 9)
    public void testVerifyClientLIstElement() throws Exception {
        driver.get("https://lista.atzma.im/he/clients");
        Assert.assertEquals(driver.getCurrentUrl(), "https://lista.atzma.im/he/clients");
        Assert.assertTrue(driver.findElement(By.xpath("//span[text()='מאגר לקוחות']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//span[text()='(0)']")).isDisplayed());
    }

    @Test(priority = 10)
    public void testVerifyDefaultServices30min() throws Exception {
        driver.get("https://lista.atzma.im/he/catalog/services");
        Assert.assertEquals(driver.getCurrentUrl(), "https://lista.atzma.im/he/catalog/services");
        Assert.assertTrue(driver.findElement(By.xpath("//p[text()='פגישה 30 דקות']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("(//span[text()='כללית'])[1]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("(//img[@src=\"/public/services/ic-time-copy.svg\"])[1]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("(//span[text()='דקות'])[1]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//span[text()='30']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("(//span[text()='₪'])[1]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("(//span[text()='0'])[1]")).isDisplayed());

        Assert.assertFalse(isElementPresent(By.xpath("//img[@class='trash']")));
        driver.findElement(By.xpath("//label[@for='styled-checkbox-2']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//img[@class='trash']")).isDisplayed());
        driver.findElement(By.xpath("//label[@for='styled-checkbox-2']")).click();
        Assert.assertFalse(isElementPresent(By.xpath("//img[@class='trash']")));

    }

    @Test(priority = 11)
    public void testVerifyDefaultServices45min() throws Exception {
        driver.get("https://lista.atzma.im/he/catalog/services");
        Assert.assertEquals(driver.getCurrentUrl(), "https://lista.atzma.im/he/catalog/services");
        Assert.assertTrue(driver.findElement(By.xpath("//p[text()='פגישה 45 דקות']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("(//span[text()='כללית'])[2]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("(//img[@src=\"/public/services/ic-time-copy.svg\"])[1]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("(//span[text()='דקות'])[2]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//span[text()='45']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("(//span[text()='₪'])[2]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("(//span[text()='0'])[2]")).isDisplayed());

        Assert.assertFalse(isElementPresent(By.xpath("//img[@class='trash']")));
        driver.findElement(By.xpath("//label[@for='styled-checkbox-3']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//img[@class='trash']")).isDisplayed());
        driver.findElement(By.xpath("//label[@for='styled-checkbox-3']")).click();
        Assert.assertFalse(isElementPresent(By.xpath("//img[@class='trash']")));

    }

    @Test(priority = 12)
    public void testVerifyDefaultServices60min() throws Exception {
        driver.get("https://lista.atzma.im/he/catalog/services");
        Assert.assertEquals(driver.getCurrentUrl(), "https://lista.atzma.im/he/catalog/services");
        Assert.assertTrue(driver.findElement(By.xpath("//p[text()='פגישה 60 דקות']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("(//span[text()='כללית'])[3]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("(//img[@src=\"/public/services/ic-time-copy.svg\"])[1]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("(//span[text()='דקות'])[3]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//span[text()='60']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("(//span[text()='₪'])[3]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("(//span[text()='0'])[3]")).isDisplayed());

        Assert.assertFalse(isElementPresent(By.xpath("//img[@class='trash']")));
        driver.findElement(By.xpath("//label[@for='styled-checkbox-4']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//img[@class='trash']")).isDisplayed());
        driver.findElement(By.xpath("//label[@for='styled-checkbox-4']")).click();
        Assert.assertFalse(isElementPresent(By.xpath("//img[@class='trash']")));

    }
    //    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
//        String verificationErrorString = verificationErrors.toString();
//        if (!"".equals(verificationErrorString)) {
//            fail(verificationErrorString);
//        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
