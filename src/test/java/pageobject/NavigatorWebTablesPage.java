package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class NavigatorWebTablesPage extends AbstractPageObject {
    private final By buttonSubmit = By.cssSelector("#submit");
    private final By buttonAdd = By.cssSelector("#addNewRecordButton");
//    private final By editElement = By.cssSelector("#edit-record-4");
    private final String editElement = "edit-record-4";

    public NavigatorWebTablesPage(WebDriver driver) {
        super(driver, "https://demoqa.com/webtables");
    }

    public void clickButtonSubmit() {
        getElement(buttonSubmit).click();
    }

    public void clickButtonAdd() {
        getElement(buttonAdd).click();
    }

    public void clickEdit() {
        getElement(By.cssSelector("#" + editElement)).click();
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

    public boolean checkCellByTextAll(String firstName, String lastName, String email, String age, String salary, String department,StringBuilder error) {
        boolean result = checkCellByText(firstName, error);
        result = checkCellByText(lastName, error) && result;
        result = checkCellByText(email, error) && result;
        result = checkCellByText(age, error) && result;
        result = checkCellByText(salary, error) && result;
        result = checkCellByText(department, error) && result;
        return result;
    }

    public boolean checkCellByText(String text, StringBuilder error){

        String valXPath = String.format("//*[text()='%s']", text);
        try {
            driver.findElement(By.xpath(valXPath));
            return true;
        }catch(Exception e){
            error.append("The name " + text + " not found \n");
            return false;
        }

    }
    public void scrollToEditElement() {
        scroll(editElement);
    }

}

