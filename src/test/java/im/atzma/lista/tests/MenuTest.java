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


        String expected = "[יומן, מאגר לקוחות, תזכורות, קבוצות, טיפולים, הגדרות, תמיכה, Rate us, לצאת]";
        List<String> actual = app.getCalendarPage().verifyMenuLinks();
        //--------------------------------------------------------------------------verify menu elements
        Assert.assertEquals(actual.toString(), expected);
    }
}
