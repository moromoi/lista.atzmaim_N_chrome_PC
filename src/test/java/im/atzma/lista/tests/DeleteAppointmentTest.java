package im.atzma.lista.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteAppointmentTest extends TestBase {

    @Test(priority = 1)
    public void testAppointmentDeletion() throws InterruptedException {
        app.getSessionHelper().goToCalendarPage();
        app.getAppointmentHelper().deleteAppointment();
        app.getCalendarPage().logout();
        app.getSessionHelper().login();
        app.getSessionHelper().goToCalendarPage();

        try {
            Assert.assertTrue(app.getAppointmentHelper().verifyAppointmentDeletion(), "verify appointment deletion");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
