package im.atzma.lista.tests;

import org.testng.annotations.Test;

public class Login extends TestBase{

    @Test
    public void login() throws InterruptedException {
//        app.getSessionHelper().goToCalendarPage();
        app.getSessionHelper().login();
    }
}
