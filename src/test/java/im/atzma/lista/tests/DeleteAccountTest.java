package im.atzma.lista.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteAccountTest extends TestBase {

    @Test(priority = 1)
    public void testDeleteAccount() throws Exception {

        app.getAppointmentHelper().deleteAccount();
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
