package im.atzma.lista.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class CreateAppointmentTest extends TestBase {

    @Test(priority = 1)
    public void testAppointmentCreation() throws InterruptedException {
        app.getSessionHelper().goToCalendarPage();
        app.getAppointmentHelper().createAppointment("Temp Client katalon");
        app.getAppointmentHelper().addServiceCategory("Temp services_katalon", "Temp category_katalon");
        app.getCalendarPage().logout();
        app.getSessionHelper().login();

        String expected = "[09:00 - 09:30, Temp Client katalon, Temp services_katalon, 30 דקות]";
        List<String> actual = app.getAppointmentHelper().verifyAppointmentCreation();
        try {
            Assert.assertEquals(actual.toString(), expected, "verify appointment creation");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
