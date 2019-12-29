package im.atzma.lista.tests;

import im.atzma.lista.model.ClientData;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ClientDeletionTest extends TestBase {

    @Test(priority = 1)
    public void testDeleteClientId() throws InterruptedException {
        System.out.println("=== Create two same client / delete client with max ID / verify first client not deleted ===");

        app.getSessionHelper().goToClientPage();
        ClientData clientData = new ClientData("testDeleteClientId_1", "0547333334", "katalon@gmail.com",
                "רוקח 18, רמת גן, ישראל");

        app.getSessionHelper().initAddNewClient();
        app.getClientHelper().fillClientForm(clientData);
        app.getSessionHelper().goToClientPage();
        Set<ClientData> before = app.getClientPage().getClientId();

        app.getSessionHelper().initAddNewClient();
        app.getClientHelper().fillClientForm(clientData);
        app.getSessionHelper().goToClientPage();

        Set<ClientData> after_add_client = app.getClientPage().getClientId();

//        int max = after_add_client.stream().max(Comparator.comparingInt(ClientData::getId)).get().getId();
        int max = after_add_client.stream().mapToInt((g) -> g.getId()).max().getAsInt();

        app.getClientPage().deleteClientWithMaxId(max);
        Set<ClientData> after = app.getClientPage().getClientId();

        assertThat(after, equalTo(before));

    }

}
