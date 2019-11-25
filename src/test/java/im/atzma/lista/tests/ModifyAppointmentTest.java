package im.atzma.lista.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ModifyAppointmentTest extends TestBase {

    @Test(priority = 1)
    public void verifyCreatedAppointment() throws InterruptedException {
        app.getSessionHelper().goToCalendarPage();
        app.getAppointmentHelper().clickOnExistsAppointment();

        String expected = "[Temp Client katalon, 0547019283, 09:00 - 09:30, 30 דקות, Temp services_katalon, 50 ₪, מחק, ערוך, ×]";
        List<String> actual = app.getAppointmentHelper().verifyAppointmentElements();
        try {
            Assert.assertEquals(actual.toString(), expected);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test(priority = 2)
    public void verifyAppointmentForm() throws InterruptedException {
        app.getSessionHelper().goToCalendarPage();
        app.getAppointmentHelper().clickOnExistsAppointment();

        String expected = "[30דק, ₪ 50, Temp services_katalon ⨯ 1, 09:00-09:30, Temp Client katalon, חזור, שמור]";
        List<String> actual = app.getAppointmentHelper().verifyForm();

        try {
            Assert.assertEquals(actual.toString(), expected);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 3)
    public void createTempService() throws InterruptedException {
        app.getSessionHelper().goToServicesPage();
        app.getServicesHelper().initAddNewService();
        app.getServicesHelper().fillServiceFrom("Temp services_katalon_2", "Temp category_katalon_2");
        app.getServicesHelper().saveServiceFrom();

        String actual = app.getServicesHelper().verifyTempService("Temp services_katalon_2");
        String expected = "Temp services_katalon_2";
        try {
            Assert.assertEquals(actual, expected);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test(priority = 4)
    public void modifyAppointment() throws InterruptedException {
        app.getSessionHelper().goToCalendarPage();
        app.getAppointmentHelper().clickOnExistsAppointment();
        app.getAppointmentHelper().initAppModification();

        app.getAppointmentHelper().modifyAppTime();
        app.getAppointmentHelper().modifyServiceDuration();
        app.getAppointmentHelper().modifyServicePrice();
        app.getAppointmentHelper().modifyAppService("Temp services_katalon_2");

        String expected = "[09:00 - 09:30, Temp Client katalon, Temp services_katalon, 30 דקות]";
        List<String> actual = app.getAppointmentHelper().verifyAppointmentCreation();
        try {
            Assert.assertEquals(actual.toString(), expected, "verify appointment creation");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
