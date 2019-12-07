package im.atzma.lista.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class DeleteAppointmentTest extends TestBase {

    @Test(priority = 1)
    public void testAppointmentDeletion() throws InterruptedException {
        app.getSessionHelper().goToCalendarPage();
        app.getCalendarPage().logout();
        app.getSessionHelper().login();
        app.getAppointmentHelper().deleteAppointment();
        app.getCalendarPage().logout();
        app.getSessionHelper().login();

        String expected = "[]";
        List<String> actual = app.getAppointmentHelper().verifyAppointmentDeletion();
        try {
            Assert.assertEquals(actual.toString(), expected, "verify appointment deletion");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Test(priority = 2)
    public void testServiceDeletion() throws InterruptedException {
        app.getSessionHelper().goToServicesPage();
        app.getServicesHelper().deleteTempService();
        app.getSessionHelper().goToServicesPage();

        String expected = "[פגישה 30 דקות, פגישה 45 דקות, פגישה 60 דקות]";
        List<String> actual = app.getServicesHelper().verifyServiceDeletion();

        try {
            Assert.assertEquals(actual.toString(), expected, "verify service deletion");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
