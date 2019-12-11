package im.atzma.lista.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteAccountTest extends TestBase {

    @Test(priority = 1)
    public void testDeleteAccount() throws Exception {

        app.getAppointmentHelper().deleteAccount();
        try {
            Assert.assertTrue(app.getSessionHelper().verifyEmailInput());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Assert.assertTrue(app.getSessionHelper().verifyPasswordInput());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    @Test(priority = 2)
    public void testDeleteAccountVerification() throws Exception {

        app.getSessionHelper().login();

        String expected = "אנחנו לא מכירים את האימייל הזה והססמה";
        String actual = app.getAppointmentHelper().verifyAccountDeletion();

        try {
            Assert.assertEquals(actual, expected);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
