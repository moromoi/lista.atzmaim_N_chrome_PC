package im.atzma.lista.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ServiceCreationTest extends TestBase{

    @Test(priority = 1)
    public void testVerifyDefaultElements() throws InterruptedException {
        app.getSessionHelper().goToServicesPage();
        Assert.assertTrue(app.driver.getCurrentUrl().matches("https://lista.atzma.im/he/catalog/services"));

        List<WebElement> elementList = app.getServicesHelper().verifyServicePageElements();
        try {
            for (int i = 0; i < elementList.size(); i++) {
                Assert.assertTrue(elementList.get(i).isDisplayed());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test(priority = 2)
    public void testVerifyDefaultServices30min() throws Exception {

        try {
            List<WebElement> elementList = app.getServicesHelper().verifyDefaultService_30min();
            for (int i = 0; i < elementList.size(); i++) {
                //--------------------------------------------------------------------------verify default service elements (30 min)
                Assert.assertTrue(elementList.get(i).isDisplayed());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            //--------------------------------------------------------------------------verify trash icon present
            Assert.assertTrue(app.getServicesHelper().verifyTrashIconPresent_1());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 3)
    public void testVerifyDefaultServices45min() throws Exception {
        try {
            List<WebElement> elementList = app.getServicesHelper().verifyDefaultService_45min();
            for (int i = 0; i < elementList.size(); i++) {
                //--------------------------------------------------------------------------verify default service elements (45 min)
                Assert.assertTrue(elementList.get(i).isDisplayed());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            //--------------------------------------------------------------------------verify trash icon present
            Assert.assertTrue(app.getServicesHelper().verifyTrashIconPresent_2());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test(priority = 4)
    public void testVerifyDefaultServices60min() throws Exception {
        try {
            List<WebElement> elementList = app.getServicesHelper().verifyDefaultService_60min();
            for (int i = 0; i < elementList.size(); i++) {
                //--------------------------------------------------------------------------verify default service elements (60 min)
                Assert.assertTrue(elementList.get(i).isDisplayed());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            //--------------------------------------------------------------------------verify trash icon present
            Assert.assertTrue(app.getServicesHelper().verifyTrashIconPresent_3());
        } catch (Exception e) {
            e.printStackTrace();
        }

//        try {
//            //--------------------------------------------------------------------------verify trash icon not present
//            Assert.assertFalse(app.getServicesPage().verifyTrashIcon());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        app.getServicesHelper().initAddNewService();
    }

    @Test(priority = 5)
    public void testVerifyDefaultServiceFormElements() {
        Assert.assertTrue(app.driver.getCurrentUrl().matches("https://lista.atzma.im/he/catalog/services/adding"));

        List<WebElement> elementList = app.getServicesHelper().verifyDefaultServiceFormElements();
        for (int i = 0; i < elementList.size(); i++) {
            //--------------------------------------------------------------------------verify Default Service Form Elements
            Assert.assertTrue(elementList.get(i).isDisplayed());
        }

        String disabledButton_expected = "rgba(155, 155, 155, 1)";
        String disabledButton_actual = app.getServicesHelper().verifyDisabledButtonColor();

        try {
            //--------------------------------------------------------------------------verify save new service disabled button css
            Assert.assertEquals(disabledButton_actual, disabledButton_expected);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test(priority = 6)
    public void testFillServiceForm() throws InterruptedException {


        app.getServicesHelper().fillServiceFrom();

        String enabledButton_expected = "rgba(255, 53, 140, 1)";
        String enabledButton_actual = app.getServicesHelper().verifyEnableddButtonColor();

        try {
            //--------------------------------------------------------------------------verify save new service enabled button css
            Assert.assertEquals(enabledButton_actual, enabledButton_expected);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    @Test(priority = 7)
    public void testSaveServiceForm() throws InterruptedException {

        app.getServicesHelper().saveServiceFrom();
        String actual = app.getServicesHelper().verifyTempService();
        String expected = "Temp services_katalon";
        try {
            Assert.assertEquals(actual, expected);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
