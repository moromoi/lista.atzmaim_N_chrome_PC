package im.atzma.lista.tests;

import im.atzma.lista.model.ClientData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ModifyAppointmentTest extends TestBase {

    //    @Test(priority = 3)
//    public void createTempService() throws InterruptedException {
//        app.getSessionHelper().goToServicesPage();
//        app.getServicesHelper().initAddNewService();
//        app.getServicesHelper().fillServiceFrom("Temp services_katalon_2", "Temp category_katalon_2");
//        app.getServicesHelper().saveServiceFrom();
//
//        String actual = app.getServicesHelper().verifyTempService("Temp services_katalon_2");
//        String expected = "Temp services_katalon_2";
//        try {
//            Assert.assertEquals(actual, expected);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
    @Test(priority = 3)
    public void createSecondTempClient() throws InterruptedException {
        app.getSessionHelper().goToClientPage();
        app.getSessionHelper().initAddNewClient();
        app.getClientHelper().fillClientForm(new ClientData("Temp Client katalon_2", "0547613154",
                "temp2@gmail.com", "רוקח 19, תל אביב, ישראל", null, null, null, null, null));

        String actual = app.getClientHelper().verifyNewClientCreation();
        String expected = "Temp Client katalon_2";
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

        app.getAppointmentHelper().modifyService();
        app.getAppointmentHelper().addServiceCategory("Temp services_katalon_2", "Temp category_katalon_2");
        app.getAppointmentHelper().modifyAppTime();
        app.getAppointmentHelper().modifyServiceDuration();
        app.getAppointmentHelper().modifyServicePrice();

        app.getAppointmentHelper().modifyClient();
        app.getAppointmentHelper().fillNewAppointment("Temp Client katalon_2");

        app.getAppointmentHelper().saveForm();

        String expected = "[10:00 - 11:45, Temp Client katalon_2, Temp services_katalon_2, 1ש45דק]";
        List<String> actual = app.getAppointmentHelper().verifyAppointmentCreation2();
        try {
            Assert.assertEquals(actual.toString(), expected, "verify appointment modification");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 5)
    public void verifyModifiedAppointment() throws InterruptedException {
        app.getAppointmentHelper().clickOnExistsAppointment2();

        String expected = "[Temp Client katalon_2, 0547613154, 10:00 - 11:45, 1ש45דק, Temp services_katalon_2, 100 ₪, מחק, ערוך, ×]";
        List<String> actual = app.getAppointmentHelper().verifyAppointmentElements();
        try {
            Assert.assertEquals(actual.toString(), expected);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test(priority = 6)
    public void verifyModifiedAppointmentForm() throws InterruptedException {
        app.getAppointmentHelper().initAppModification();
        String expected = "[1ש 45דק, ₪ 100, Temp services_katalon_2 ⨯ 1, 10:00-11:45, Temp Client katalon_2, חזור, שמור]";
        List<String> actual = app.getAppointmentHelper().verifyForm();

        try {
            Assert.assertEquals(actual.toString(), expected);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
