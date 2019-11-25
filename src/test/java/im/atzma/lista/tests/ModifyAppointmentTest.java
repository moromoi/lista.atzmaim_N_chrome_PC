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
    public void modifyAppointment() throws InterruptedException {
        app.getSessionHelper().goToCalendarPage();
        app.getAppointmentHelper().clickOnExistsAppointment();
        app.getAppointmentHelper().initAppModification();

        app.getAppointmentHelper().modifyAppTime();
    }
}
