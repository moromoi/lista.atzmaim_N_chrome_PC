package im.atzma.lista.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class CreateAppointmentTest extends TestBase {

    @Test(priority = 1)
    public void testAppointmentCreation() throws InterruptedException, IOException {
        app.goTo().calendarPage();
        app.appointment().create("Temp Client katalon");
        app.appointment().addServiceCategory("Temp services_katalon", "Temp category_katalon");
        app.appointment().saveForm();

        String expected = "[15:00 - 15:30, Temp Client katalon, Temp services_katalon, 30 דקות]";
        List<String> actual = app.appointment().verifyAppointmentCreation();
        try {
            Assert.assertEquals(actual.toString(), expected, "verify appointment creation");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
