package im.atzma.lista.tests;

import im.atzma.lista.model.ClientData;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ClientDeletionTest extends TestBase {

    @Test(priority = 1)
    public void testCreateClientCount_1() throws InterruptedException {
        System.out.println("=== Create client and verify creation in client list ===");

        app.getSessionHelper().goToClientPage();
        int before = app.getClientPage().getClientCount();
        System.out.println("Size of client list before client creation = " + before);
        app.getSessionHelper().initAddNewClient();
        app.getClientHelper().fillClientForm(new ClientData("Temp Client katalon", "0547222223",
                "temp@gmail.com", "רוקח 18, רמת גן, ישראל"));
        app.getSessionHelper().goToClientPage();
        int after = app.getClientPage().getClientCount();
        System.out.println("Size of client list after client creation = " + after);

        System.out.println("Size of client list after creation = " + after + " / " + "Size of client list before one client deletion: " + before + " : is that + 1 ? ");
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
        int after = app.getClientPage().getClientCount();

        Assert.assertEquals(after, before + 1);
    }

    @Test(priority = 2)
    public void testDeleteClientId() throws InterruptedException {
        System.out.println("=== Verify client deletion ===");

        app.getSessionHelper().goToClientPage();
        ClientData clientData = new ClientData("testDeleteClientId_1", "0547333333", "katalon@gmail.com",
                "רוקח 18, רמת גן, ישראל");
        app.getSessionHelper().initAddNewClient();
        app.getClientHelper().fillClientForm(clientData);
        app.getSessionHelper().goToClientPage();
        List<ClientData> before = app.getClientPage().getClientId();

        app.getSessionHelper().initAddNewClient();
        app.getClientHelper().fillClientForm(clientData);
        app.getSessionHelper().goToClientPage();
        List<ClientData> after = app.getClientPage().getClientId();



        int max=0;
        for(ClientData data: after) {
            if(data.getId() > max) {
                max = data.getId();
            }

        }
        clientData.setId(max);

        System.out.println("Max id= " + clientData.getId());
        Assert.assertEquals(after, before);

//        List<ClientData> after = app.getClientPage().getClientId();
//        app.getClientPage().selectClient(0);
//        app.getClientPage().deleteSelectedClient();
//        app.getSessionHelper().goToClientPage();

    }

//    @Test(priority = 2)
    public void testDeleteClientCount() throws InterruptedException {
        System.out.println("=== Verify client deletion ===");

        app.getSessionHelper().goToClientPage();
        app.getClientPage().getClientId();
        System.out.println("Size of client list BEFORE client deletion = " + app.getClientPage().getClientCount());
        int before = app.getClientPage().getClientCount();
        app.getClientPage().selectClient(0);

        app.getClientPage().deleteSelectedClient();
        app.getSessionHelper().goToClientPage();
        System.out.println("Size of client list AFTER client DELETION = " + app.getClientPage().getClientCount());
        int after = app.getClientPage().getClientCount();

        System.out.println("Size of client list one less?");
        Assert.assertEquals(after, before - 1);
    }
}
