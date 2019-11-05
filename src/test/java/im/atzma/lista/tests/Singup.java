package im.atzma.lista.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Singup extends im.atzma.lista.tests.TestBase {
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Test(priority = 1)
    public void testVerifySignupPageElements() throws Exception {
        app.getSessionHelper().goToHomePage();
        app.getSessionHelper().goToSingupPage();

        try {
            List<WebElement> elementList = app.getSingupPage().getSignupPageElements();
            for (int i = 0; i < elementList.size(); i++) {
                Assert.assertTrue(elementList.get(i).isDisplayed());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 2)
    public void testPasswordVisibleIcons() throws Exception {
        app.getSessionHelper().typeNewPassAndUser();

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
        try {
            Assert.assertTrue(app.getSessionHelper().submit());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Test(priority = 3)
    public void testVerifyBusinessTypePageElements() throws Exception {
        try {
            List<WebElement> elementList = app.getBusinessPage().getBusnessPageElemenents();
            for (int i = 0; i < elementList.size(); i++) {
                Assert.assertTrue(elementList.get(i).isDisplayed());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 4)
    public void testMarkBussnessType_atzmaimButtonChecked() throws Exception {
        List<String> elementList_expected = new ArrayList<>();
        elementList_expected.add("rgba(255, 255, 255, 1)");
        elementList_expected.add("rgb(222, 206, 255) 0px 2px 8px 0px");
        elementList_expected.add("rgba(79, 45, 167, 1)");

        String submitButton_expected = "rgba(0, 0, 0, 0) linear-gradient(0deg, rgb(247, 112, 98), rgb(254, 81, 150))" +
                " repeat scroll 0% 0% / auto padding-box border-box";

        List<String> elementList_actual = app.getBusinessPage().markBussnessType_button();

        try {
            Assert.assertEquals(elementList_actual, elementList_expected);
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<WebElement> elementList = app.getBusinessPage().markBussnessType_titles();
        for (int i = 0; i < elementList.size(); i++) {
            Assert.assertTrue(elementList.get(i).isDisplayed());
        }

        try {
            String submitButton_actual = app.getBusinessPage().submitButtonColor();
            Assert.assertEquals(submitButton_actual, submitButton_expected);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            //--------------------------------------------------------------------------Verify all-set page URL
            app.getSessionHelper().submit2();
            Assert.assertTrue(app.driver.getCurrentUrl().matches("https://lista.atzma.im/he/signup/all-set"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Test(priority = 5)
    public void testVerifyAllSetPageElements() throws Exception {
        List<WebElement> elementList = app.getAllSetPage().getAllSetPageElements();
        for (int i = 0; i < elementList.size(); i++) {
            //--------------------------------------------------------------------------verify all-set page elements
            Assert.assertTrue(elementList.get(i).isDisplayed());
        }
    }

    @Test(priority = 6)
    public void testVerifyAllTestPageCheckboxes() {
        //-------------------------------------------------------------------------- css of default submit button
        List<String> submitButtonDefault_expected = Arrays.asList("18px, rgba(255, 255, 255, 1), " +
                "rgb(191, 175, 224) none repeat scroll 0% 0% / auto padding-box border-box");
        //-------------------------------------------------------------------------- css of active submit button
        List<String> submitButtonActive_expected = Arrays.asList("18px, rgba(255, 255, 255, 1)," +
                " rgba(0, 0, 0, 0) linear-gradient(0deg, rgb(247, 112, 98), rgb(254, 81, 150))" +
                " repeat scroll 0% 0% / auto padding-box border-box");

        try {
            //--------------------------------------------------------------------------verify css default submit button
            List<String> submitButtonDefault_actual = app.getAllSetPage().verifySubmitButton_default();
            Assert.assertEquals(submitButtonDefault_actual.toString(), submitButtonDefault_expected.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            //--------------------------------------------------------------------------verify css default submit button after mark first checkbox
            List<String> submitButtonDefault_actual = app.getAllSetPage().clickFirstCheckbox();
            Assert.assertEquals(submitButtonDefault_actual.toString(), submitButtonDefault_expected.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            //--------------------------------------------------------------------------verify css active submit button after mark second checkbox
            app.getAllSetPage().clickSecondCheckbox();
            List<String> submitButtonDefault_actual = app.getAllSetPage().verifySubmitButton_default();
            Assert.assertEquals(submitButtonDefault_actual.toString(), submitButtonActive_expected.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test(priority = 7)
    public void testCreateNewAccount_submit() throws InterruptedException {
        try {
            //--------------------------------------------------------------------------verify account creation by element in calendar
            Assert.assertTrue(app.getSessionHelper().submit3());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            //--------------------------------------------------------------------------verify account creation by part of URL
            Assert.assertTrue(app.driver.getCurrentUrl().contains("https://lista.atzma.im/he/calendar"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            //--------------------------------------------------------------------------verify username in Menu
            Assert.assertTrue(app.getCalendarPage().verifyUserinMenu());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Test(priority = 8)
    public void testLogOut() throws Exception {
        try {
            //--------------------------------------------------------------------------verify logout button in menu
            Assert.assertTrue(app.getCalendarPage().logout());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            //--------------------------------------------------------------------------verify URL after logout
            Assert.assertTrue(app.driver.getCurrentUrl().matches("https://lista.atzma.im/he/login"));
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    @Test(priority = 9)
    public void testVerifyLoginWithNewUser() throws Exception {
        app.getSessionHelper().loginWithUser();
        try {
            //--------------------------------------------------------------------------verify Login with new user (name in menu)
            Assert.assertTrue(app.getCalendarPage().verifyUserinMenu());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 10)
    public void testVerifyDefaultClientPage() throws Exception {
        app.getSessionHelper().goToClientPage();
        try {
            //--------------------------------------------------------------------------verify client page URL
            Assert.assertTrue(app.driver.getCurrentUrl().matches("https://lista.atzma.im/he/clients"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            //--------------------------------------------------------------------------verify title text ('מאגר לקוחות')
            Assert.assertTrue(app.getClientPage().verifyTitleText());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String numberOfClient =app.getClientPage().verifyNumberOfClient();

        //--------------------------------------------------------------------------verify number of client (0)
        try {
            Assert.assertEquals(numberOfClient, "(10)");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test(priority = 11)
    public void testVerifyDefaultServices30min() throws Exception {
        app.getSessionHelper().goToServicesPage();
        try {
            //--------------------------------------------------------------------------verify services page URL
            Assert.assertTrue(app.driver.getCurrentUrl().matches("https://lista.atzma.im/he/catalog/services"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            List<WebElement> elementList = app.getServicesPage().verifyDefaultService_30min();
            for (int i = 0; i < elementList.size(); i++) {
                //--------------------------------------------------------------------------verify default service elements (30 min)
                Assert.assertTrue(elementList.get(i).isDisplayed());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            //--------------------------------------------------------------------------verify trash icon present
            Assert.assertTrue(app.getServicesPage().verifyTrashIconPresent_1());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 12)
    public void testVerifyDefaultServices45min() throws Exception {
        try {
            List<WebElement> elementList = app.getServicesPage().verifyDefaultService_45min();
            for (int i = 0; i < elementList.size(); i++) {
                //--------------------------------------------------------------------------verify default service elements (45 min)
                Assert.assertTrue(elementList.get(i).isDisplayed());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            //--------------------------------------------------------------------------verify trash icon present
            Assert.assertTrue(app.getServicesPage().verifyTrashIconPresent_2());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test(priority = 13)
    public void testVerifyDefaultServices60min() throws Exception {
        try {
            List<WebElement> elementList = app.getServicesPage().verifyDefaultService_60min();
            for (int i = 0; i < elementList.size(); i++) {
                //--------------------------------------------------------------------------verify default service elements (60 min)
                Assert.assertTrue(elementList.get(i).isDisplayed());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            //--------------------------------------------------------------------------verify trash icon present
            Assert.assertTrue(app.getServicesPage().verifyTrashIconPresent_3());
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            //--------------------------------------------------------------------------verify trash icon not present
            Assert.assertFalse(app.getServicesPage().verifyTrashIcon());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test(priority = 20)
    public void testDeleteAccount() throws Exception {
        app.deleteAccount();
        Assert.assertTrue(app.driver.getCurrentUrl().matches("https://lista.atzma.im/he/login"));
    }
}
