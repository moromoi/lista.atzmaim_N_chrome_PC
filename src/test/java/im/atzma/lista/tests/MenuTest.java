package im.atzma.lista.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class MenuTest extends TestBase {

    @Test(priority = 1)
    public void verifyLinkText() throws InterruptedException, IOException {
//        app.goTo().login();
        app.goTo().calendarPage();


        String expected = "[יומן, מאגר לקוחות, תזכורות, קבוצות, טיפולים, הגדרות, תמיכה, Rate us, לצאת]";
        List<String> actual = app.calendar().verifyMenuLinks();
        //--------------------------------------------------------------------------verify menu elements
        Assert.assertEquals(actual.toString(), expected);
    }
}
