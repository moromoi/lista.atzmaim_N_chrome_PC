package im.atzma.lista.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.fail;

public class HelperBase {
    protected WebDriver driver;
//    Actions builder = new Actions(driver);

    public HelperBase(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void highlight(WebElement el) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='2px solid red'", el);
    }


    public void click(WebElement el) {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        highlight(el);
        try {
            el.click();
        } catch (WebDriverException e) {
            e.printStackTrace();
        }
    }

    public void clickJS(WebElement el) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", el);
    }

    public void select(WebElement el, String myvalue) {
        new Select(el).selectByValue(myvalue);
        try {
            highlight(el);
        } catch (WebDriverException e) {
            e.printStackTrace();
        }
    }

    public void fillText(WebElement el, String text) throws InterruptedException {
        highlight(el);
        if (text != null) {
            String existingText = el.getAttribute("value");
            if (!text.equals(existingText)) {
                el.click();
                el.clear();
                el.sendKeys(text);
            }
        }
    }

//    public void fillText(WebElement el, String text) throws InterruptedException {
//        el.sendKeys(text);
//    }

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
            List<WebElement> itemlist = new ArrayList<>();
            itemlist.add(el);
            if(itemlist.size() > 0) {
                return true;
            }
            return false;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}
