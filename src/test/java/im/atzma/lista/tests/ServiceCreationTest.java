package im.atzma.lista.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ServiceCreationTest extends TestBase{

    @Test(priority = 1)
    public void testCreateTempService() throws InterruptedException {
        app.getSessionHelper().goToServicesPage();
        Assert.assertTrue(app.driver.getCurrentUrl().matches("https://lista.atzma.im/he/catalog/services"));

        app.getServicesHelper().initAddNewService();
        Assert.assertTrue(app.driver.getCurrentUrl().matches("https://lista.atzma.im/he/catalog/services/adding"));

        app.getServicesHelper().fillServiceFrom();
        String actual = app.getServicesHelper().verifyTempService();
        String expected = "Test טיפול services_katalon";
        try {
            Assert.assertEquals(actual, expected);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
