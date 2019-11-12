package im.atzma.lista.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class CreateAppointmentTest extends TestBase {

    @Test(priority = 1)
    public void testAppointmentCreation() throws InterruptedException {
        app.getSessionHelper().goToCalendarPage();
        app.getCalendarPage().chooseAppointmentHour();
        app.getCalendarPage().fillNewAppointment();

        String  expected ="[13:00 - 13:30, Temp Client katalon, Test טיפול services_katalon, 30 דקות]";
        List<String> actual = app.getCalendarPage().verifyAppointmentCreation();

        try {
            Assert.assertEquals(actual.toString(), expected);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
