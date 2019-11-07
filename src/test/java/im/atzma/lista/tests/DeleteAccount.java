package im.atzma.lista.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteAccount extends TestBase {

    @Test(priority = 1)
    public void testDeleteAccount() throws Exception {
        app.getSessionHelper().loginWithUser();
        app.deleteAccount();
        Assert.assertTrue(app.driver.getCurrentUrl().matches("https://lista.atzma.im/he/login"));
    }
}
