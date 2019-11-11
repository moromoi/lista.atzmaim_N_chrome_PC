package im.atzma.lista.tests;

import im.atzma.lista.model.ClientData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ClientCreationTest extends TestBase {

    @Test
    public void testCreateNewClient() throws InterruptedException {
        app.getSessionHelper().goToClientPage();
        app.getSessionHelper().initAddNewClient();
        try {
            Assert.assertTrue(app.driver.getCurrentUrl().matches("https://lista.atzma.im/he/adding-client"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        app.getClientHelper().fillClientForm(new ClientData("Temp Client katalon", "0547019283",
                "temp@gmail.com", "רוקח 18, רמת גן, ישראל"));

        String actual = app.getClientHelper().verifyNewClientCreation();
        String expected = "Temp Client katalon";
        try {
            Assert.assertEquals(actual, expected);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
