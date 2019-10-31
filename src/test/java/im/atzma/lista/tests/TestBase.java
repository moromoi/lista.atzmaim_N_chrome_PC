package im.atzma.lista.tests;

import im.atzma.lista.appmanager.ApplicationManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {

    protected static final ApplicationManager app = new ApplicationManager();

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        app.init();

    }

   // @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        app.stop();
    }

}
