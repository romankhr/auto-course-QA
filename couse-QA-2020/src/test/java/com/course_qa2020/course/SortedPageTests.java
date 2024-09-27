package com.course_qa2020.course;

import com.course_qa2020.BaseTest;
import com.course_qa2020.pages.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SortedPageTests extends BaseTest {
    //TODO as this is used across different test shall we extract it to the Properties or BaseTest?
    private String acceptCookiesButtonLocator = "//button[@class=\"ui-button-primary ui-cookie-accept-all-medium-large\"]";
    private String searchTerm = "London";
    private HomePage homePage;
    private LocationLondonPage locationLondonPage;
    private PriceMinPage priceMinPage;
    private PriceMaxPage priceMaxPage;
    private PropertyTypePage propertyTypePage;
    private AdvanceSearchPage advanceSearchPage;
    private SortedPage sortedPage;

    @BeforeMethod(alwaysRun = true)
    public void setupTest() {
        System.out.println(getClass().getSimpleName() + ".setupTest");

        if (driver.findElement(By.xpath(acceptCookiesButtonLocator)).isDisplayed()) {
            driver.findElement(By.xpath(acceptCookiesButtonLocator)).click();
        }
        homePage = new HomePage(driver);
    }


//   -----------------------------Test 1-----------------------------

    @Test(groups = "main", suiteName = "ui")
    public void sortedTest() throws Exception {
        sortedPage= new SortedPage(driver);
        //Given user navigates to the webpage www.zoopla.co.uk

        //When User inserts location "London" in the location field and chooses the type of property in "Property type"
        //and Chooses Maximum price in the field "Max price"  and Chooses Minimum price in the field "Min price"
        // and Chooses Distance Radius and number of Bedrooms and pushes the button "Search"

        sortedPage=homePage
                .setSearchAdvance()
                .setPropertyType()
                .setMinPrice()
                .setSearchLocationTerm(searchTerm)
                .setMaxPrice()
                .setSearchByBedrooms()
                .setSortOptions()
                .setSearchRadius()
                .clickOnSearchButton(SortedPage.class);

        //Then user is redirected to the searched page. The information about the chosen properties should appeared in chosen order
        Assert.assertTrue(sortedPage.isSortedPageSorted(), "Title is not correct!!!");
    }
}
