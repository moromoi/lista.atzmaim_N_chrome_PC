package im.atzma.lista.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ModifyAppointmentTest extends TestBase {

    @Test(priority = 1)
    public void verifyCreatedAppointment() throws InterruptedException {
        app.getSessionHelper().goToCalendarPage();
        app.getAppointmentHelper().clickOnExistsAppointment();

        String expected = "[Temp Client katalon, 0547019283, 09:00 - 09:30, 30 דקות, Temp services_katalon, 50 ₪]";
        List<String> actual = app.getAppointmentHelper().verifyAppointmentElements();
        try {
            Assert.assertEquals(actual.toString(), expected);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
