package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigatorElementsPage extends AbstractPageObject {
    private final String buttonButtonsId = "item-4";
    private final By buttonClickMe = By.xpath("//*[text()='Click Me']");

    public NavigatorElementsPage(WebDriver driver) {
        super(driver, "https://demoqa.com/elements");
    }

    public void clickButtonClickMe() {
        getElement(buttonClickMe).click();
    }
    public void clickButtons() {
        getElement(By.cssSelector("#" + buttonButtonsId)).click();
    }

    public void scrollToButtons() {
        scroll(buttonButtonsId);
    }



}
