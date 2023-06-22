package pageobject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class NavigatorManager extends AbstractPageObject {
    private final By buttonButtons = By.cssSelector("#item-4");
    private final By buttonClickMe = By.xpath("//*[text()='Click Me']");
    private final By buttonSubmit = By.cssSelector("#submit");
    private final By buttonAdd = By.cssSelector("#addNewRecordButton");
    private final By editElement = By.cssSelector("#edit-record-4");
   public NavigatorManager(WebDriver driver) {
       super(driver);

   }
   public void navigateToURL(String url){
       driver.get(url);
       driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
   }
    @Test
    public void clickButtons() {
        getElement(buttonButtons).click();

    }
    public void clickButtonClickMe() {
        getElement(buttonClickMe).click();
    }
    public void clickButtonSubmit() {
        getElement(buttonSubmit).click();
    }
    public void clickButtonAdd() {
        getElement(buttonAdd).click();
    }
    public void clickEdit(){
       getElement(editElement).click();
    }

    public void fillInRow(String firstName, String lastName, String email, String age, String salary, String department) {
        updateWebElement("#firstName", firstName);
        updateWebElement("#lastName", lastName);
        updateWebElement("#userEmail", email);
        updateWebElement("#age", age);
        updateWebElement("#salary", salary);
        updateWebElement("#department", department);
    }

    void updateWebElement(String cssSelector, String newValue) {
        WebElement field = driver.findElement(By.cssSelector(cssSelector));
        field.clear();
        field.sendKeys(newValue);
    }
    public void checkCellByTextAll(String firstName, String lastName, String email, String age, String salary, String department){
        checkCellByText(firstName);
        checkCellByText(lastName);
        checkCellByText(email);
        checkCellByText(age);
        checkCellByText(salary);
        checkCellByText(department);
    }

    public void checkCellByText(String value){
        String valXPath = String.format("//*[text()='%s']", value);
        try {
            driver.findElement(By.xpath(valXPath));
        }catch(Exception e){
            Assert.fail("The name " + value + " not found");
        }

    }
    public void scroll(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");

    }

    public void pause() {
        try {
            Thread.sleep(10000);
        } catch (Exception exception) {
            System.out.println("Something went wrong.");
        }
    }
}
