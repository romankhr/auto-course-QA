package com.course_qa2020.course;

import com.course_qa2020.BaseTest;
import com.course_qa2020.pages.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FinalAssignmentTests extends BaseTest {

    private String acceptCookiesButtonLocator = "//input[@id='sp-cc-accept']";
    private HomePageAmazon homePage;
    private NewReleasesAmazonPage newReleasesAmazonPage;
    private BooksPageAmazon booksPage;
    private SearchPageAmazon searchPage;
    private String SEARCH_TERM="go pro 4k";
    private String MIN_PRICE="100";
    private MonitorsTopRatedResultsAmazon monitorsTopRatedResultsAmazon;
    private TabletsPageAmazon tabletsPageAmazon;

    @BeforeMethod(alwaysRun = true)
    public void setupTest() {
        if (driver.findElement(By.xpath(acceptCookiesButtonLocator)).isDisplayed()) {
            driver.findElement(By.xpath(acceptCookiesButtonLocator)).click();
        }
        homePage = new HomePageAmazon(driver);
    }

    //   -----------------------------Test 1-----------------------------

    @Test(groups = "main1", suiteName = "ui")
    public void verifyNewReleasesPageTest() throws Exception {
        newReleasesAmazonPage = new NewReleasesAmazonPage(driver);

        //Given user navigates to the web page www.amazon.co.uk

        //when from the home page click on button “ALL” on the left panel and from the menu select “New Releases”
        newReleasesAmazonPage = homePage.navigateAllPage().navigateNewReleasesPage(NewReleasesAmazonPage.class);
        //Then On the “New Releases” page verify that ALL titles of the sections presented on the page are existing in the left List of links
        Assert.assertTrue(newReleasesAmazonPage.isNewReleasesItemsIsInListDepartment(), "Some titles of the sections presented on the page are not existing in the left List of links!!!");
    }

    //   -----------------------------Test 2-----------------------------

    @Test(groups = "main1", suiteName = "ui")
    public void verifyRatingPresentedTest() throws Exception {
        booksPage = new BooksPageAmazon(driver);

        //Given user navigates to the web page www.amazon.co.uk

        //when from the home page click on link “New Releases” from the Top menu
        // and from the “Hot New Releases” click on “Most Gifted” link from the top menu
       // and from the “Amazon Gift Ideas” click on “Books” link from the left menu
        booksPage = homePage
                .navigateNewReleasesPageSecondTest(NewReleasesAmazonPage.class)
                .navigateMostGiftedLocator(MostGiftedPageAmazon.class)
                .navigateBooksPage(BooksPageAmazon.class);
        //Then on the “Most Gifted in Books” page check ALL listings and verify that all of them have Ratings presented
        Assert.assertTrue(booksPage.isRatingPresented(), "Some items is not presented in Ratings!!!");
    }

    //   -----------------------------Test 3-----------------------------

    @Test(groups = "main1", suiteName = "ui")
    public void verifySearchResult() throws Exception {
        searchPage = new SearchPageAmazon(driver);

        //Given user navigates to the webpage www.amazon.co.uk

        //when from the home page search for “go pro 4k” via search field
        // and on the “Search results” page select Avg. Customer Review 4+ stars from the left section
        // and on the “Search results” page set min price as 100 and apply changes
        searchPage = homePage
                .insertSearchTerm(SEARCH_TERM)
                .navigateSearchPage(SearchPageAmazon.class)
                .setCustomerReview()
                .setMinPrice(MIN_PRICE)
                .goButton(MIN_PRICE);
        //Thenverify that all updated results (except Limited deals one) have an average rating 4+ and item price is higher than 100
        Assert.assertTrue(searchPage.isResultCorrect(MIN_PRICE), "The result is less than 100!!!");
    }

    //   -----------------------------Test 4-----------------------------

    @Test(groups = "main1", suiteName = "ui")
    public void verifyFilterOnMonitorResult() throws Exception {
        monitorsTopRatedResultsAmazon = new MonitorsTopRatedResultsAmazon(driver);

        //Given user navigates to the webpage www.amazon.co.uk

        //when from the home page click on link “Electronics” from the Top menu
        // and on “Computers & Accessories” page click on “Monitors”
        // and on “Monitors” page click on “See more” link next to the “Top rated section”
        // and on  “Monitors top rated results” page apply filter “Sort by: Avg. Customer Review” from the top of the page
        monitorsTopRatedResultsAmazon = homePage
                .navigateElectronicsPage(ElectronicsPageAmazon.class)
                .navigateComputersAndAccessories(ComputerAndAccessoriesPageAmazon.class)
                .navigateMonitorPage(MonitorPageAmazon.class)
                .navigateMonitorListPage(MonitorsTopRatedResultsAmazon.class)
                .focusingOnRating()
                .averageSorting();
        //Then verify that in refreshed list all listings on the first page are sorted according to the Customer review
        Assert.assertTrue(monitorsTopRatedResultsAmazon.isSortedPageSorted(), "The sorting is not correct!!!");
    }

    //   -----------------------------Test 5-----------------------------

    @Test(groups = "main1", suiteName = "ui")
    public void verifyPrimeOption() throws Exception {
        tabletsPageAmazon = new TabletsPageAmazon(driver);

        //Given user navigates to the webpage www.amazon.co.uk

        //when from the home page click on link “Electronics” from the Top menu
        // and on “Computers & Accessories” page click on “Tablets”
        // on Results page select “Prime” option checkbox from the left menu

        tabletsPageAmazon = homePage
                .navigateElectronicsPage(ElectronicsPageAmazon.class)
                .navigateComputersAndAccessories(ComputerAndAccessoriesPageAmazon.class)
                .navigateTabletsPage(TabletsPageAmazon.class)
                .setCheckBox();
        //Thenin result list verify that all listings on the first page either have “Prime option” or “FREE Delivery” in the listing body
        Assert.assertTrue(tabletsPageAmazon.isResultListCorrect(), " The first page have not “Prime option” or “FREE Delivery” in the listing body!!!");
    }
}
