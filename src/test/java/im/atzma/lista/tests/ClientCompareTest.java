package im.atzma.lista.tests;

import im.atzma.lista.model.ClientData;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ClientCompareTest extends TestBase {

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
        int after = app.getClientPage().getClientCount();

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


    @Test(priority = 3)
    public void testCompareClient() throws InterruptedException {
        System.out.println("=== Compare  first client elements with same second ===");

        app.getSessionHelper().goToClientPage();
        app.getClientPage().selectClient(0);
        List<ClientData> before =  app.getClientHelper().getClientList();

        app.getSessionHelper().goToClientPage();
        app.getClientPage().selectClient(1);
        List<ClientData> after =  app.getClientHelper().getClientList();

        Assert.assertEquals(after, before);

    }
}
