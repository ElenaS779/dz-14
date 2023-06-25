package tests;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.NavigatorElementsPage;

public class ElementsPageTests extends BaseTest{

    @Test
    @Description("The test checks the opening of a web page")
    public void openPageElements() {
        NavigatorElementsPage elementsPage = new NavigatorElementsPage(driver);
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/elements"
                , "The page opens was not successful");
    }
    @Test
    @Description("The test checks how works 'Buttons' button")
    public void clickButtonButtons() {
        NavigatorElementsPage elementsPage = new NavigatorElementsPage(driver);
        elementsPage.scrollToButtons();
        elementsPage.clickButtons();
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/buttons"
                , "Received a wrong url than expected.");
    }
    @Test
    @Description("The test checks how works 'Click Me' button")
    public void clickButtonsClickMe() {
        NavigatorElementsPage elementsPage = new NavigatorElementsPage(driver);
        elementsPage.scrollToButtons();
        elementsPage.clickButtons();
        elementsPage.clickButtonClickMe();
        WebElement e = driver.findElement(By.cssSelector("#dynamicClickMessage"));
        Assert.assertEquals(e.getText(),"You have done a dynamic click","ClickMe button faild");
    }
    @Test
    @Description("The test checks text that appears after click 'Click Me' button")
    public void getText(){
        NavigatorElementsPage elementsPage = new NavigatorElementsPage(driver);
        elementsPage.scrollToButtons();
        elementsPage.clickButtons();
        elementsPage.clickButtonClickMe();
        WebElement e = driver.findElement(By.cssSelector("#dynamicClickMessage"));
        System.out.println(e.getText());
        Assert.assertEquals(e.getText(),"You have done a dynamic click","Unexpected text after click on ClickMe button");
    }
}
