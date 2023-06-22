package tests;

import org.testng.annotations.Test;
import pageobject.NavigatorManager;

public class TestTableManipulation extends BaseTest{
    private final static String FIRST_NAME = "Miriam";
    private final static String LAST_NAME = "Bubble";
    private final static String EMAIL = String.format("%s%s@gmail.com",FIRST_NAME,LAST_NAME);
    private final static String AGE = "36";
    private final static String SALARY = "3600";
    private final static String DEPARTMENT = "Finances";


    @Test
    public void addInformation() {
        NavigatorManager buttons = new NavigatorManager(driver);
        buttons.navigateToURL("https://demoqa.com/webtables");
        buttons.clickButtonAdd();
        buttons.fillInRow(FIRST_NAME, LAST_NAME, EMAIL, AGE, SALARY, DEPARTMENT);
        buttons.clickButtonSubmit();
    }
    @Test
    public void checkInformation() {
        NavigatorManager buttons = new NavigatorManager(driver);
        buttons.navigateToURL("https://demoqa.com/webtables");
        buttons.clickButtonAdd();
        buttons.fillInRow(FIRST_NAME, LAST_NAME, EMAIL, AGE, SALARY, DEPARTMENT);
        buttons.clickButtonSubmit();
        buttons.scroll();
        buttons.checkCellByTextAll(FIRST_NAME, LAST_NAME, EMAIL, AGE, SALARY, DEPARTMENT);
        buttons.scroll();
        buttons.pause();
    }
    @Test
    public void editInformation() {
        NavigatorManager buttons = new NavigatorManager(driver);
        buttons.navigateToURL("https://demoqa.com/webtables");
        buttons.clickButtonAdd();
        buttons.fillInRow(FIRST_NAME, LAST_NAME, EMAIL, AGE, SALARY, DEPARTMENT);
        buttons.clickButtonSubmit();
        buttons.scroll();
        buttons.checkCellByTextAll(FIRST_NAME, LAST_NAME, EMAIL, AGE, SALARY, DEPARTMENT);
        buttons.scroll();
        buttons.clickEdit();
        buttons.fillInRow(FIRST_NAME, LAST_NAME, EMAIL, "37", "4000", "Commercial");
        buttons.clickButtonSubmit();
        buttons.pause();
    }

}
