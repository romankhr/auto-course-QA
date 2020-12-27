package com.course_qa2020.course;

import com.course_qa2020.BaseTest;
import com.course_qa2020.pages.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstWebTests extends BaseTest {
    private String acceptCookiesButtonLocator = "//button[@class=\"ui-button-primary ui-cookie-accept-all-medium-large\"]";
    private String searchTerm="London";
    private HomePage homePage;
    private LocationLondonPage locationLondonPage;
    private PriceMinPage priceMinPage;
    private PriceMaxPage priceMaxPage;
    private PropertyTypePage propertyTypePage;
    private  AdvanceSearchPage advanceSearchPage;

    @BeforeMethod
    public void setupTest() {
        System.out.println(getClass().getSimpleName()+".setupTest");

        driver.get("https://www.zoopla.co.uk");

        if (driver.findElement(By.xpath(acceptCookiesButtonLocator)).isDisplayed()) {
            driver.findElement(By.xpath(acceptCookiesButtonLocator)).click();
        }
        homePage = new HomePage(driver);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

//   -----------------------------Test 1-----------------------------

    @Test(groups = "main", suiteName = "ui")
    public void locationTest() throws Exception {
        locationLondonPage=new LocationLondonPage(driver);
        //Given user navigates to the webpage www.zoopla.co.uk

        //hen User inserts location "London" in the location field and pushes the button "Search"
    locationLondonPage= homePage.setSearchLocationTerm(searchTerm).clickOnSearchButton(LocationLondonPage.class);

        //Then user is redirected to the searched page. The information about the properties of chosen location should appeared
        //and title  should be "Property for sale in London"
          Assert.assertTrue(locationLondonPage.isTitleCorrect(), "Title is not correct!!!");
    }

    //   -----------------------------Test 2-----------------------------

    @Test(groups = "main", suiteName = "ui")
    public void minPriceTest() throws Exception {
    priceMinPage=new PriceMinPage(driver);
        //Given user navigates to the webpage www.zoopla.co.uk

        //When User inserts location "London" in the location field and Chooses Minimum price in the field "Min price" and pushes the button "Search"
         priceMinPage=homePage.setSearchLocationTerm(searchTerm).setMinPrice().clickOnSearchButton(PriceMinPage.class);

        //Then user is redirected to the searched page. The information about the properties of chosen location with minimum price should appeared
           Assert.assertTrue(priceMinPage.isTitleCorrect(), "Title is not correct!!!");
    }

    //   -----------------------------Test 3-----------------------------

    @Test(groups = "main", suiteName = "ui")
    public void maxPriceTest() throws Exception {

        //Given user navigates to the webpage www.zoopla.co.uk
        priceMaxPage=new PriceMaxPage(driver);
        //When User inserts location "London" in the location field and Chooses Maximum price in the field "Max price" and pushes the button "Search"
        priceMaxPage=homePage.setSearchLocationTerm(searchTerm).setMaxPrice().clickOnSearchButton(PriceMaxPage.class);

        //Then user is redirected to the searched page. The information about the properties of chosen location with maximum price should appeared
        Assert.assertTrue(priceMaxPage.isTitleCorrect(), "Title is not correct!!!");
    }

    //   -----------------------------Test 4 -----------------------------

    @Test(groups = "main", suiteName = "ui")
    public void propertyTest() throws Exception {
        propertyTypePage=new PropertyTypePage(driver);

        //Given user navigates to the webpage www.zoopla.co.uk

        //When User inserts location "London" in the location field and chooses the type of property in "Property type" and pushes the button "Search"
        propertyTypePage=homePage.setSearchLocationTerm(searchTerm)
                .setPropertyType()
                .clickOnSearchButton(PropertyTypePage.class);

        //Then user is redirected to the searched page. The information about the properties of chosen location and type should appeared
        Assert.assertTrue(propertyTypePage.isTitleCorrect(), "Title is not correct!!!");
    }

    //   -----------------------------Test 5 -----------------------------

    @Test(groups = "main", suiteName = "ui")
    public void numbersOfBedroomsTest() throws Exception {
        advanceSearchPage = new AdvanceSearchPage(driver);
        //Given user navigates to the webpage www.zoopla.co.uk

        //When User inserts location "London" in the location field and chooses the type of property in "Property type"
        //and Chooses Maximum price in the field "Max price"  and Chooses Minimum price in the field "Min price"
        // and Chooses Distance Radius and number of Bedrooms and pushes the button "Search"

        advanceSearchPage=homePage
                .setSearchAdvance()
                .setPropertyType()
                .setMinPrice()
                .setSearchLocationTerm(searchTerm)
                .setMaxPrice().setSearchByBedrooms()
                .setSortOptions()
                .setSearchRadius()
                .clickOnSearchButton(AdvanceSearchPage.class);

        //Then user is redirected to the searched page. The information about the chosen properties should appeared
        Assert.assertTrue(advanceSearchPage.isTitleCorrect(), "Title is not correct!!!");
    }
}
