package im.atzma.lista.tests;

import im.atzma.lista.model.ClientData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ClientCreationTest extends TestBase {

    @Test(priority = 1)
    public void initNewClientCreation() throws InterruptedException {
        app.getSessionHelper().goToClientPage();
        app.getSessionHelper().initAddNewClient();
        try {
            Assert.assertTrue(app.driver.getCurrentUrl().matches("https://lista.atzma.im/he/adding-client"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 2)
    public void verifyClientForm() {
        int expected = 20;
        int actual = app.getClientHelper().verifyNewClientForm();

        try {
            Assert.assertEquals(actual, expected, "number of elements on client form");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 3)
    public void fillClientForm() throws InterruptedException {
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

    @Test(priority = 4)
    public void createClientCount() throws InterruptedException {
        app.getSessionHelper().goToClientPage();
        int before = app.getClientPage().getClientCount();
        app.getSessionHelper().initAddNewClient();
        app.getClientHelper().fillClientForm(new ClientData("Temp Client katalon", "0547019283",
                "temp@gmail.com", "רוקח 18, רמת גן, ישראל"));
        app.getSessionHelper().goToClientPage();
        int after = app.getClientPage().getClientCount();

        Assert.assertEquals(after, before + 1);
    }

    @Test(priority = 5)
    public void deleteClientCount() throws InterruptedException {
        app.getSessionHelper().goToClientPage();
        int before = app.getClientPage().getClientCount();
        app.getClientPage().deleteSelectedClient();
        app.getSessionHelper().goToClientPage();
        int after = app.getClientPage().getClientCount();

        Assert.assertEquals(after, before - 1);
    }
}
