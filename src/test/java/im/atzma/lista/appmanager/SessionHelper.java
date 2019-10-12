package im.atzma.lista.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Random;

public class SessionHelper extends HelperBase {
   
    Random random = new Random();
    long randomLong = random.nextLong();
    public String mail = "katalon_" + randomLong + "@gmail.com";
    public String pass = "Pa$$w@rd";
    String baseURL = "https://lista.atzma.im/he/home";
    String singupURL = "https://lista.atzma.im/he/signup";

    public SessionHelper(WebDriver driver) {
        super(driver);
    }

    public void goToHomePage () throws InterruptedException {
        driver.get(baseURL);
        waitForLocation(baseURL);

    }

    public void goToSingupPage() throws InterruptedException {
        driver.findElement(By.xpath("//a[@href='/he/signup']")).click();
        driver.get(singupURL);
        waitForLocation(singupURL);
    }

    public void goToLoginPage() {
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys(mail);
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys(pass);
    }

    public void submit() {
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }
}
