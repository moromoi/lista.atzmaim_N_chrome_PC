package im.atzma.lista.tests;

import im.atzma.lista.model.ClientData;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

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
                "temp@gmail.com", "רוקח 18, רמת גן, ישראל", null, null, null, null, null));

        String actual = app.getClientHelper().verifyNewClientCreation();
        String expected = "Temp Client katalon";
        try {
            Assert.assertEquals(actual, expected);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 4)
    public void testCreateClientCount() throws InterruptedException {
        app.getSessionHelper().goToClientPage();
        System.out.println("Number of client before client creation = " + app.getClientPage().getClientCount());
        int before = app.getClientPage().getClientCount();
        app.getSessionHelper().initAddNewClient();
        app.getClientHelper().fillClientForm(new ClientData("Temp Client katalon", "0547019283",
                "temp@gmail.com", "רוקח 18, רמת גן, ישראל", null, null, null, null, null));
        app.getSessionHelper().goToClientPage();
        System.out.println("Number of client after client creation = " + app.getClientPage().getClientCount());
        int after = app.getClientPage().getClientCount();

        Assert.assertEquals(after, before + 1);
    }


}
