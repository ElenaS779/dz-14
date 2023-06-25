package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class AbstractPageObject {
    private final static int DURATION_TO_WAIT_DEFAULT = 4;
    protected WebDriver driver;

    public AbstractPageObject(WebDriver driver, String url){
        this.driver = driver;
        driver.get(url);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }

    public WebElement getElement(By by, int waitForSeconds){
        return new WebDriverWait(driver, Duration.ofSeconds(waitForSeconds))
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public WebElement getElement(By by){
        return new WebDriverWait(driver, Duration.ofSeconds(DURATION_TO_WAIT_DEFAULT))
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public List<WebElement> getElements(By by, int waitForSeconds){
        return new WebDriverWait(driver, Duration.ofSeconds(waitForSeconds))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    public List<WebElement> getElements(By by){
        return new WebDriverWait(driver, Duration.ofSeconds(DURATION_TO_WAIT_DEFAULT))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    public void waitTillAppears(By by, int waitForSeconds){
        new WebDriverWait(driver, Duration.ofSeconds(waitForSeconds))
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void waitTillAppears(By by){
        new WebDriverWait(driver, Duration.ofSeconds(DURATION_TO_WAIT_DEFAULT))
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void waitTillDisappear(By by, int waitForSeconds){
        new WebDriverWait(driver, Duration.ofSeconds(waitForSeconds))
                .until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public void waitTillDisappear(By by){
        new WebDriverWait(driver, Duration.ofSeconds(DURATION_TO_WAIT_DEFAULT))
                .until(ExpectedConditions.invisibilityOfElementLocated(by));
    }
    protected void scroll(String elementId) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(String.format("function Position(obj){\n" +
                " var currenttop = 0;\n" +
                " if (obj.offsetParent){\n" +
                "  do {\n" +
                "   currenttop += obj.offsetTop;\n" +
                " }while ((obj = obj.offsetParent));\n" +
                "  return [currenttop];\n" +
                " }\n" +
                "}\n" +
                "window.scrollTo(0, Position(document.getElementById(\"%s\")))", elementId), "");

    }

}
