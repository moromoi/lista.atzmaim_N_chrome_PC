package im.atzma.lista.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.fail;

public class HelperBase {
    protected WebDriver driver;

    public HelperBase(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void highlight(WebElement el) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='2px solid red'", el);
    }

    public void click(WebElement el) {
        try {
            highlight(el);
            el.click();
        } catch (WebDriverException e) {
            e.printStackTrace();
        }
    }

    public void waitForLocation(String myURL) throws InterruptedException {
            for (int second = 0; ; second++) {
                if (second >= 60) fail("timeout");
                try {
                    if (myURL.equals(driver.getCurrentUrl())) break;
                } catch (Exception e) {
                }
                Thread.sleep(1000);
            }
    }

    public void waitForElement(WebElement myElement) throws InterruptedException {
        for (int second = 0; ; second++) {
            if (second >= 60) fail("timeout");
            try {
                if (myElement.isDisplayed()) break;
            } catch (Exception e) {
            }
            Thread.sleep(1000);
        }

    }

    public boolean isElementPresent(WebElement el) {
        try {
            el.isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}
