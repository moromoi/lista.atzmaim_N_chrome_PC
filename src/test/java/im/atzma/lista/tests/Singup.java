package im.atzma.lista.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class Singup extends TestBase {
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Test(priority = 1)
    public void testVerifySignupPageElements() throws Exception {
        app.getSessionHelper().goToHomePage();
        app.getSessionHelper().goToSingupPage();

        List<WebElement>elementList = app.getSingupPage().getSignupPageElements();
        for (int i = 0; i < elementList.size(); i++) {
            Assert.assertTrue(elementList.get(i).isDisplayed());
        }

//        Assert.assertEquals(app.driver.getCurrentUrl(), "https://lista.atzma.im/he/signup");
//        Assert.assertTrue(app.driver.findElement(By.xpath("//li[text()='ru']")).isDisplayed());
//        Assert.assertTrue(app.driver.findElement(By.xpath("//li[text()='en']")).isDisplayed());
//        Assert.assertTrue(app.driver.findElement(By.xpath("//li[text()='he']")).isDisplayed());
//        Assert.assertTrue(app.driver.findElement(By.xpath("//img[@src='/public/signup/media/logo.svg']")).isDisplayed());
//        Assert.assertTrue(app.driver.findElement(By.xpath("//div[text()='מלא פרטים כדי לצור חשבון:']")).isDisplayed());
//        Assert.assertTrue(app.driver.findElement(By.xpath("//input[@placeholder='הזן את האימיייל שלך']")).isDisplayed());
//        Assert.assertTrue(app.driver.findElement(By.xpath("//input[@placeholder='הזן את הססמא שלך']")).isDisplayed());
//        Assert.assertTrue(app.driver.findElement(By.xpath("//button[text()='המשך']")).isDisplayed());
//        Assert.assertTrue(app.driver.findElement(By.xpath("//img[@src='/public/signup/media/mail.svg']")).isDisplayed());
//        Assert.assertTrue(app.driver.findElement(By.xpath("//button[@type='submit']")).isDisplayed());
//        Assert.assertTrue(app.driver.findElement(By.xpath("//img[@src='/public/signup/media/lock.svg']")).isDisplayed());

    }

    @Test(priority = 2)
    public void testRegisterNewUser() throws Exception {
        app.getSessionHelper().goToLoginPage();

        try {
            Assert.assertTrue(app.getSingupPage().passwordVisible());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Assert.assertTrue(app.getSingupPage().eye_icon_off());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Assert.assertTrue(app.getSingupPage().eye_icon());
        } catch (Exception e) {
            e.printStackTrace();
        }

        app.getSessionHelper().submit();

//        Assert.assertTrue(app.driver.findElement(By.xpath("//img[@src='/public/signup/media/eye.svg']")).isDisplayed());
//        app.driver.findElement(By.xpath("//img[@src='/public/signup/media/eye.svg']")).click();
//        Assert.assertTrue(app.driver.findElement(By.xpath("//div[@class='group password ']//input[@type='text']")).isDisplayed());
//        Assert.assertTrue(app.driver.findElement(By.xpath("//img[@src='/public/signup/media/eye-off.svg']")).isDisplayed());
//        app.driver.findElement(By.xpath("//button[@type='submit']")).click();
//        Assert.assertEquals(app.driver.getCurrentUrl(), "https://lista.atzma.im/he/signup/business-type");
//
    }
//
//
//    @Test(priority = 3)
//    public void testVerifyBusinessTypePageElements() throws Exception {
//        Thread.sleep(300);
//        Assert.assertTrue(app.driver.findElement(By.xpath("//img[@src='/public/signup/media/ic_back.svg']")).isDisplayed());
//        Assert.assertTrue(app.driver.findElement(By.xpath("//img[@src='/public/signup/media/business_types_icons/one-on-one_meetings.svg']")).isDisplayed());
//        Assert.assertTrue(app.driver.findElement(By.xpath("//img[@src='/public/signup/media/business_types_icons/hair_styling.svg']")).isDisplayed());
//        Assert.assertTrue(app.driver.findElement(By.xpath("//div[text()='נא לבחור סוג העסק']")).isDisplayed());
//        Assert.assertTrue(app.driver.findElement(By.xpath("//div[text()='אנחנו נתאים את האפליקציה לצרכים שלך']")).isDisplayed());
//        Assert.assertTrue(app.driver.findElement(By.xpath("//div[text()='אתם יכולים לבחור יותר מאחד או']")).isDisplayed());
//        Assert.assertTrue(app.driver.findElement(By.xpath("//button[text()='לדלג הלאה']")).isDisplayed());
//        Assert.assertTrue(app.driver.findElement(By.xpath("//span[text()='בואו נתחיל!']")).isDisplayed());
//
//    }
//
//
//    @Test(priority = 4)
//    public void testCheckInBussnessType() throws Exception {
//        app.driver.findElement(By.xpath("//div[@class='bussiness-type']")).click();
//        Assert.assertTrue(app.driver.findElement(By.xpath("//div[text()='בחרת ב:']")).isDisplayed());
//        Assert.assertTrue(app.driver.findElement(By.xpath("//span[text()='עצמאי']")).isDisplayed());
//        Assert.assertTrue(app.driver.findElement(By.xpath("//img[@src='/public/signup/media/business_types_icons/violet-one-on-one_meetings.svg']")).isDisplayed());
//        Assert.assertTrue(app.driver.findElement(By.xpath("//div[@class='bussiness-type__checkmark']")).isDisplayed());
//        app.driver.findElement(By.xpath("//span[text()='בואו נתחיל!']/..")).click();
//
//    }
//
//    @Test(priority = 5)
//    public void testVerifyAllSetPageElements() throws Exception {
////        "https://lista.atzma.im/he/signup/all-set"
//app.getSessionHelper().waitForLocation();
//        for (int second = 0; ; second++) {
//            if (second >= 60) fail("timeout");
//            try {
//                if ("https://lista.atzma.im/he/signup/all-set".equals(app.driver.getCurrentUrl())) break;
//            } catch (Exception e) {
//            }
//            Thread.sleep(1000);
//        }
//
//        Assert.assertTrue(app.driver.findElement(By.xpath("//img[@src='/public/signup/media/ic_back.svg']")).isDisplayed());
//
//        try {
//            Assert.assertTrue(app.driver.findElement(By.xpath("//img[@src='/public/signup/media/sing-up-img.png']")).isDisplayed());
//        } catch (Error e) {
//            app.verificationErrors.append(e.toString());
//        }
//        Assert.assertTrue(app.driver.findElement(By.xpath("//div[text()='אנחנו סיימנו כאן!']")).isDisplayed());
//        Assert.assertTrue(app.driver.findElement(By.xpath("//span[text()='תודה על שיתוף הפעולה']")).isDisplayed());
//        Assert.assertTrue(app.driver.findElement(By.xpath("//span[text()='עכשיו אתם יכולים להתחיל ליהנות משימוש באפליקציה']")).isDisplayed());
//        Assert.assertTrue(app.driver.findElement(By.xpath("//span[text()='אנחנו הולכים לשלוח מידע חשוב וטיפים על שימוש באפליקציה, אתם מסכימים לזה?']")).isDisplayed());
//        Assert.assertTrue(app.driver.findElement(By.xpath("//span[text()='אני מסכים לתנאי הסכם שימוש של אפליקציה Atzma.im CRM']")).isDisplayed());
//        Assert.assertTrue(app.driver.findElement(By.xpath("//label[@for='twice']")).isDisplayed());
//        Assert.assertTrue(app.driver.findElement(By.xpath("//label[@for='first']")).isDisplayed());
//        Assert.assertTrue(app.driver.findElement(By.xpath("//span[text()='בואו נתחיל!']")).isDisplayed());
//
//        app.driver.findElement(By.xpath("//label[@for='twice']/span")).click();
//        app.driver.findElement(By.xpath("//button")).click();
//        for (int second = 0; ; second++) {
//            if (second >= 60) fail("timeout");
//            try {
//                if (app.driver.findElement(By.xpath("//div[@class='more_wrap']")).isDisplayed()) break;
//            } catch (Exception e) {
//            }
//            Thread.sleep(1000);
//
//        }
//    }
//
//
//    @Test(priority = 6)
//    public void testLogOut() throws Exception {
//        app.driver.findElement(By.xpath("//div[@class='more_wrap']")).click();
//        Assert.assertTrue(app.driver.findElement(By.xpath("//p[contains(text(), 'katalon')]")).isDisplayed());
//        Assert.assertTrue(app.driver.findElement(By.xpath("//a[@href='/he/logout']")).isDisplayed());
//        app.driver.findElement(By.xpath("//a[@href='/he/logout']")).click();
//
//    }
//
//    @Test(priority = 7)
//    public void testVerifyLoginWithNewUser() throws Exception {
//        Assert.assertEquals(app.driver.getCurrentUrl(), "https://lista.atzma.im/he/login");
//
//        app.driver.findElement(By.name("email")).clear();
//        app.driver.findElement(By.name("email")).sendKeys(app.getSessionHelper().mail);
//        app.driver.findElement(By.name("pass")).clear();
//        app.driver.findElement(By.name("pass")).sendKeys(app.getSessionHelper().pass);
//        app.driver.findElement(By.xpath("//button[text()='להיכנס']")).click();
//        for (int second = 0; ; second++) {
//            if (second >= 60) fail("timeout");
//            try {
//                if (app.driver.findElement(By.xpath("//div[@class='more_wrap']")).isDisplayed()) break;
//            } catch (Exception e) {
//            }
//            Thread.sleep(1000);
//        }
//        Assert.assertTrue(app.driver.findElement(By.xpath("//div[@class='more_wrap']")).isDisplayed());
//
//        app.driver.findElement(By.xpath("//div[@class='more_wrap']")).click();
//        Assert.assertTrue(app.driver.findElement(By.xpath("//p[contains(text(), 'katalon')]")).isDisplayed());
//    }
//
//    @Test(priority = 8)
//    public void testVerifyClientLIstElement() throws Exception {
//        app.driver.get("https://lista.atzma.im/he/clients");
//        Assert.assertEquals(app.driver.getCurrentUrl(), "https://lista.atzma.im/he/clients");
//        Assert.assertTrue(app.driver.findElement(By.xpath("//span[text()='מאגר לקוחות']")).isDisplayed());
//        Assert.assertTrue(app.driver.findElement(By.xpath("//span[text()='(0)']")).isDisplayed());
//    }
//
//  //   @Test(priority = 9)
//    public void testVerifyDefaultServices30min() throws Exception {
//        app.driver.get("https://lista.atzma.im/he/catalog/services");
//        Assert.assertEquals(app.driver.getCurrentUrl(), "https://lista.atzma.im/he/catalog/services");
//        Assert.assertTrue(app.driver.findElement(By.xpath("//p[text()='פגישה 30 דקות']")).isDisplayed());
//        Assert.assertTrue(app.driver.findElement(By.xpath("(//span[text()='כללית'])[1]")).isDisplayed());
//        Assert.assertTrue(app.driver.findElement(By.xpath("(//img[@src='/public/services/ic-time-copy.svg'])[1]")).isDisplayed());
//        Assert.assertTrue(app.driver.findElement(By.xpath("(//span[text()='דקות'])[1]")).isDisplayed());
//        Assert.assertTrue(app.driver.findElement(By.xpath("//span[text()='30']")).isDisplayed());
//        Assert.assertTrue(app.driver.findElement(By.xpath("(//span[text()='₪'])[1]")).isDisplayed());
//        Assert.assertTrue(app.driver.findElement(By.xpath("(//span[text()='0'])[1]")).isDisplayed());
//
//        Assert.assertFalse(app.isElementPresent(By.xpath("//img[@class='trash']")));
//        app.driver.findElement(By.xpath("//label[@for='styled-checkbox-2']")).click();
//        Assert.assertTrue(app.driver.findElement(By.xpath("//img[@class='trash']")).isDisplayed());
//        app.driver.findElement(By.xpath("//label[@for='styled-checkbox-2']")).click();
//        Assert.assertFalse(app.isElementPresent(By.xpath("//img[@class='trash']")));
//
//    }
//
//   //   @Test(priority = 10)
//    public void testVerifyDefaultServices45min() throws Exception {
//        app.driver.get("https://lista.atzma.im/he/catalog/services");
//        Assert.assertEquals(app.driver.getCurrentUrl(), "https://lista.atzma.im/he/catalog/services");
//        Assert.assertTrue(app.driver.findElement(By.xpath("//p[text()='פגישה 45 דקות']")).isDisplayed());
//        Assert.assertTrue(app.driver.findElement(By.xpath("(//span[text()='כללית'])[2]")).isDisplayed());
//        Assert.assertTrue(app.driver.findElement(By.xpath("(//img[@src='/public/services/ic-time-copy.svg'])[1]")).isDisplayed());
//        Assert.assertTrue(app.driver.findElement(By.xpath("(//span[text()='דקות'])[2]")).isDisplayed());
//        Assert.assertTrue(app.driver.findElement(By.xpath("//span[text()='45']")).isDisplayed());
//        Assert.assertTrue(app.driver.findElement(By.xpath("(//span[text()='₪'])[2]")).isDisplayed());
//        Assert.assertTrue(app.driver.findElement(By.xpath("(//span[text()='0'])[2]")).isDisplayed());
//
//        Assert.assertFalse(app.isElementPresent(By.xpath("//img[@class='trash']")));
//        app.driver.findElement(By.xpath("//label[@for='styled-checkbox-3']")).click();
//        Assert.assertTrue(app.driver.findElement(By.xpath("//img[@class='trash']")).isDisplayed());
//        app.driver.findElement(By.xpath("//label[@for='styled-checkbox-3']")).click();
//        Assert.assertFalse(app.isElementPresent(By.xpath("//img[@class='trash']")));
//
//    }
//
//   //   @Test(priority = 11)
//    public void testVerifyDefaultServices60min() throws Exception {
//        app.driver.get("https://lista.atzma.im/he/catalog/services");
//        Assert.assertEquals(app.driver.getCurrentUrl(), "https://lista.atzma.im/he/catalog/services");
//        Assert.assertTrue(app.driver.findElement(By.xpath("//p[text()='פגישה 60 דקות']")).isDisplayed());
//        Assert.assertTrue(app.driver.findElement(By.xpath("(//span[text()='כללית'])[3]")).isDisplayed());
//        Assert.assertTrue(app.driver.findElement(By.xpath("(//img[@src='/public/services/ic-time-copy.svg'])[1]")).isDisplayed());
//        Assert.assertTrue(app.driver.findElement(By.xpath("(//span[text()='דקות'])[3]")).isDisplayed());
//        Assert.assertTrue(app.driver.findElement(By.xpath("//span[text()='60']")).isDisplayed());
//        Assert.assertTrue(app.driver.findElement(By.xpath("(//span[text()='₪'])[3]")).isDisplayed());
//        Assert.assertTrue(app.driver.findElement(By.xpath("(//span[text()='0'])[3]")).isDisplayed());
//
//        Assert.assertFalse(app.isElementPresent(By.xpath("//img[@class='trash']")));
//        app.driver.findElement(By.xpath("//label[@for='styled-checkbox-4']")).click();
//        Assert.assertTrue(app.driver.findElement(By.xpath("//img[@class='trash']")).isDisplayed());
//        app.driver.findElement(By.xpath("//label[@for='styled-checkbox-4']")).click();
//        Assert.assertFalse(app.isElementPresent(By.xpath("//img[@class='trash']")));
//
//    }
//
//    @Test(priority = 12)
//    public void testDeleteAccount() throws Exception {
//        app.deleteAccount();
//        Assert.assertTrue(app.driver.getCurrentUrl().matches("https://lista.atzma.im/he/login"));
//    }
}
