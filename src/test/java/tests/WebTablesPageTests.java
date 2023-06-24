package tests;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.NavigatorWebTablesPage;
import org.openqa.selenium.NoSuchElementException;


import java.util.List;


public class WebTablesPageTests extends BaseTest{
    private final static String FIRST_NAME = "Miriam";
    private final static String LAST_NAME = "Bubble";
    private final static String EMAIL = String.format("%s%s@gmail.com",FIRST_NAME,LAST_NAME);
    private final static String AGE = "36";
    private final static String SALARY = "3600";
    private final static String DEPARTMENT = "Finances";


    @Test
    @Description("The test checks whether information has been added to the table")
    public void addInformation() {
        NavigatorWebTablesPage webTablesPage = new NavigatorWebTablesPage(driver);
        webTablesPage.clickButtonAdd();
        webTablesPage.fillInRow(FIRST_NAME, LAST_NAME, EMAIL, AGE, SALARY, DEPARTMENT);
        webTablesPage.clickButtonSubmit();
        StringBuilder error = new StringBuilder();
        Assert.assertTrue(webTablesPage.checkCellByTextAll(FIRST_NAME, LAST_NAME, EMAIL, AGE, SALARY, DEPARTMENT, error), error.toString());

    }
    @Test
    @Description("The test checks whether the information in the table has been edited")
    public void editInformation() {
        NavigatorWebTablesPage webTablesPage = new NavigatorWebTablesPage(driver);
        webTablesPage.clickButtonAdd();
        webTablesPage.fillInRow(FIRST_NAME, LAST_NAME, EMAIL, AGE, SALARY, DEPARTMENT);
        webTablesPage.clickButtonSubmit();
        StringBuilder error = new StringBuilder();
        Assert.assertTrue(webTablesPage.checkCellByTextAll(FIRST_NAME, LAST_NAME, EMAIL, AGE, SALARY, DEPARTMENT, error), error.toString());
        webTablesPage.scrollToEditElement();
        webTablesPage.clickEdit();
        webTablesPage.fillInRow(FIRST_NAME, LAST_NAME, EMAIL, "37", "4000", "Commercial");
        webTablesPage.clickButtonSubmit();
        error.setLength(0);
        Assert.assertTrue(webTablesPage.checkCellByTextAll(FIRST_NAME, LAST_NAME, EMAIL, "37", "4000", "Commercial", error),error.toString());
    }

}
