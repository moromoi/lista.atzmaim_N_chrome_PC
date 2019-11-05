package im.atzma.lista.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ClientPage extends HelperBase{
    public ClientPage(WebDriver driver) {super(driver); }

    @FindBy(xpath = "//span[text()='מאגר לקוחות']")
    WebElement title_on_clienPage;

    @FindBy(xpath = "//span[@class='app-clients-list__header-title count']")
    WebElement number_of_client;

    public boolean verifyTitleText() throws InterruptedException {
        waitForElement(title_on_clienPage);
        highlight(title_on_clienPage);
        if(title_on_clienPage.isDisplayed()) {
            return true;
        }
        else return false;
    }

    public String verifyNumberOfClient() throws InterruptedException {
        highlight(number_of_client);
        System.out.println("number of client: " + number_of_client.getText());
//        if(number_of_client.getText().contentEquals("(1)")) {
//            return true;
//        }
//        else return false;
         String n = number_of_client.getText();
         return n;
    }

}
