package com.course_qa2020.pages;

import com.course_qa2020.framework.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.concurrent.TimeUnit;

public class HomePageAmazon extends Page {
    private String allButtonLocator = "//div[@class='nav-left']/a[1]";
    private String newReleasesLocator = "//ul[@class='hmenu hmenu-visible']//a[text() = 'New Releases']";
    private String newNewReleasesSecondTestLocator = "//div[@id='nav-xshop']//a[text() = 'New Releases']";
    private String searchFieldLocator="//input[@id='twotabsearchtextbox']";
    private String searchButtonLocator="//input[@id='nav-search-submit-button']";
    private String linkElectronicsLocator="//a[text() ='Electronics']";

    public HomePageAmazon(RemoteWebDriver driver) {
        super(driver);
    }

    public HomePageAmazon navigateAllPage() {
        driver.findElement(By.xpath(allButtonLocator)).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return this;
    }

    public <T extends Page> T navigateNewReleasesPage(Class<T> clazz) throws Exception {
        driver.findElement(By.xpath(newReleasesLocator)).click();
        return PageFactory.newPage(driver, clazz);
    }

    public <T extends Page> T navigateNewReleasesPageSecondTest(Class<T> clazz) throws Exception {
        driver.findElement(By.xpath(newNewReleasesSecondTestLocator)).click();
        return PageFactory.newPage(driver, clazz);
    }

    public HomePageAmazon insertSearchTerm(String searchTerm) {
        driver.findElement(By.xpath(searchFieldLocator)).sendKeys(searchTerm);
        return this;
    }

    public <T extends Page> T navigateSearchPage(Class<T> clazz) throws Exception {
        driver.findElement(By.xpath(searchButtonLocator)).click();
        return PageFactory.newPage(driver, clazz);
    }

    public <T extends Page> T navigateElectronicsPage(Class<T> clazz) throws Exception {
        driver.findElement(By.xpath(linkElectronicsLocator)).click();
        return PageFactory.newPage(driver, clazz);
    }
}
