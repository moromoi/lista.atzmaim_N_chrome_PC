package im.atzma.lista.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class MenuTest extends TestBase {

    @Test(priority = 1)
    public void verifyLinkText() throws InterruptedException {
        app.getSessionHelper().login();
        app.getSessionHelper().goToCalendarPage();


        List<WebElement> elementList =   app.getCalendarPage().verifyMenuLinks();
        for (int i = 0; i < elementList.size(); i++) {
            //--------------------------------------------------------------------------verify menu elements
            Assert.assertTrue(elementList.get(i).isDisplayed());
        }
    }
}
