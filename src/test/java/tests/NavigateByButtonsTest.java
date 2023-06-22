package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.NavigatorManager;

public class NavigateByButtonsTest extends BaseTest{

    @Test
    public void navigateByButtons() {
        NavigatorManager buttons = new NavigatorManager(driver);
        buttons.navigateToURL("https://demoqa.com/elements");
        buttons.scroll();
        buttons.clickButtons();
        buttons.pause();
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/buttons"
                , "The logIn was not successful");
        buttons.scroll();
        buttons.clickButtonClickMe();
        WebElement e = driver.findElement(By.cssSelector("#dynamicClickMessage"));
        System.out.println(e.getText());
        Assert.assertEquals(e.getText(),"You have done a dynamic click","The text not equals");
    }
}
