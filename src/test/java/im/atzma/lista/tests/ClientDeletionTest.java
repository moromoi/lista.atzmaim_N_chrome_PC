package im.atzma.lista.tests;

import im.atzma.lista.model.ClientData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ClientDeletionTest extends TestBase {

    @Test(priority = 1)
    public void testDeleteClientCount() throws InterruptedException {
        app.getSessionHelper().goToClientPage();
        int before = app.getClientPage().getClientCount();
        System.out.println("Number of client before client creation = " + before);

        app.getSessionHelper().initAddNewClient();
        app.getClientHelper().fillClientForm(new ClientData("Temp Client katalon", "0547019283",
                "temp@gmail.com", "רוקח 18, רמת גן, ישראל"));

        app.getSessionHelper().goToClientPage();
        System.out.println("Number of client after client creation = " + app.getClientPage().getClientCount());
        app.getClientPage().deleteSelectedClient();
        int after = app.getClientPage().getClientCount();

        Assert.assertEquals(after, before);
    }
}
