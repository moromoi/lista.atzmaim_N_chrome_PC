package im.atzma.lista.tests;

import im.atzma.lista.model.ClientData;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ClientDeletionTest extends TestBase {

    @Test(priority = 1)
    public void testCreateClientCount() throws InterruptedException {
        System.out.println("=== Create client and verify creation in client list ===");

        app.getSessionHelper().goToClientPage();
        int before = app.getClientPage().getClientCount();
        System.out.println("Size of client list before client creation = " + before);
        app.getSessionHelper().initAddNewClient();
        app.getClientHelper().fillClientForm(new ClientData("Temp Client katalon", "0547111111",
                "temp@gmail.com", "רוקח 18, רמת גן, ישראל"));
        app.getSessionHelper().goToClientPage();
        int after = app.getClientPage().getClientCount();
        System.out.println("Size of client list after client creation = " + after);

        System.out.println("Size of client list after creation = " + after + " / " + "Size of client list before one client deletion: " + before + " : is that + 1 ? ");
        Assert.assertEquals(after, before + 1);
    }

    @Test(priority = 2)
    public void testDeleteClientCount() throws InterruptedException {
        System.out.println("=== Verify client deletion ===");

        app.getSessionHelper().goToClientPage();
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
