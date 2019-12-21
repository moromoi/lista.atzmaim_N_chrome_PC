package im.atzma.lista.tests;

import im.atzma.lista.model.ModifyClientData;
import im.atzma.lista.model.ClientData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ClientModificationTest extends TestBase {

    @Test(priority = 1)
    public void testCreateClientCount_1() throws InterruptedException {
        System.out.println("=== Create first client and verify creation in client list ===");

        app.getSessionHelper().goToClientPage();
        System.out.println("Number of client before client creation = " + app.getClientPage().getClientCount());
        int before = app.getClientPage().getClientCount();
        app.getSessionHelper().initAddNewClient();
        app.getClientHelper().fillClientForm(new ClientData("Temp Client katalon", "0547111111",
                "temp@gmail.com", "רוקח 18, רמת גן, ישראל"));
        app.getSessionHelper().goToClientPage();
        System.out.println("Number of client after client creation = " + app.getClientPage().getClientCount());
        int  after = app.getClientPage().getClientCount();

        Assert.assertEquals(after, before + 1);
    }

    @Test(priority = 2)
    public void testCreateClientCount_2() throws InterruptedException {
        System.out.println("=== Create second client and verify creation in client list ===");

        app.getSessionHelper().goToClientPage();
        System.out.println("Number of client before client creation = " + app.getClientPage().getClientCount());
        int before = app.getClientPage().getClientCount();
        app.getSessionHelper().initAddNewClient();
        app.getClientHelper().fillClientForm(new ClientData("Temp Client katalon", "0547222222",
                "temp@gmail.com", "רוקח 18, רמת גן, ישראל"));
        app.getSessionHelper().goToClientPage();
        System.out.println("Number of client after client creation = " + app.getClientPage().getClientCount());
        int  after = app.getClientPage().getClientCount();

        Assert.assertEquals(after, before + 1);
    }

    @Test(priority = 3)
    public void testModificateClient_1() throws InterruptedException {
        System.out.println("=== Verify that first client changed after modification ===");

        app.getSessionHelper().goToClientPage();
        app.getClientPage().selectClient(0);
        List<ClientData> before =  app.getClientHelper().getClientList();

        app.getClientHelper().initClientModification();
        app.getClientHelper().modifyClient(new ModifyClientData("New temp client catalon", "054837465",
                "new_katalon@gmail.com", "Balfour St 33, Petah Tikva, Israel", "1960",
                "11", "11", 2, "new note"));

        app.getSessionHelper().goToClientPage();
        app.getClientPage().selectClient(0);
        List<ClientData> after =  app.getClientHelper().getClientList();

        Assert.assertNotEquals(after, before);
    }

    @Test(priority = 3)
    public void testModificateClient_2() throws InterruptedException {
        System.out.println("=== Verify that second client changed after modification ===");

        app.getSessionHelper().goToClientPage();
        app.getClientPage().selectClient(1);
        List<ClientData> before =  app.getClientHelper().getClientList();

        app.getClientHelper().initClientModification();
        app.getClientHelper().modifyClient(new ModifyClientData("New temp client catalon", "054837465",
                "new_katalon@gmail.com", "Balfour St 33, Petah Tikva, Israel", "1960",
                "11", "11", 2, "new note"));

        app.getSessionHelper().goToClientPage();
        app.getClientPage().selectClient(1);
        List<ClientData> after =  app.getClientHelper().getClientList();

        Assert.assertNotEquals(after, before);
    }

    @Test(priority = 4)
    public void testCompareClient() throws InterruptedException {
        System.out.println("=== Compare first client elements with same second after modification ===");

        app.getSessionHelper().goToClientPage();
        app.getClientPage().selectClient(0);
        List<ClientData> before =  app.getClientHelper().getClientList();

        app.getSessionHelper().goToClientPage();
        app.getClientPage().selectClient(1);
        List<ClientData> after =  app.getClientHelper().getClientList();

        Assert.assertEquals(after, before);

    }
}
