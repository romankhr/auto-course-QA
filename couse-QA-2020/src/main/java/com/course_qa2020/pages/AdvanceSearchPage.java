package com.course_qa2020.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AdvanceSearchPage extends Page{
    //TODO I'd update those variable names as if we're using titles of the pages tthen thos should be declared on the corresponding page
    //TODO all capitals in variable names are used for constants
    private String propertyTypeLocator="//div[@class='css-ijwzpf-ButtonWrapper e1tnwg465']//p[contains(text(),'Houses')]";
    private String TYPE_PAGE_TITLE="Houses";
    private String priceLocator="//div[@class='css-ijwzpf-ButtonWrapper e1tnwg465']//p[contains(text(),'£40k - £500k')]";
    private String LOCATION_PAGE_TITLE_PRICE="£40k - £500k";
    private String searchTermLocatorLocation="//h1[@class='css-mh5azd-Heading1 e1s8jdjv5']";
    private String LOCATION_PAGE_TITLE_LOCATION="Property for sale in London";
    private String searchRadiusLocator="//select[@id='desktop_radius-filter']//option[contains(text(),'+ ¼ mile')]";
    private String RADIUS_PAGE_TITLE_LOCATION="+ ¼ mile";
    private String sortLocator="//select[@id='sort-order-dropdown']//option[contains(text(),'Lowest price')]";
    private String SORT_PAGE_LOCATOR="Lowest price";

    public AdvanceSearchPage(RemoteWebDriver driver) {
        super(driver);
    }
    //TODO I'd recommend to split this method as ideally we would like to check all 4 elements but here if first would fail we will never reach out other 3
    public boolean isTitleCorrect(){
       return driver.findElement(By.xpath(priceLocator)).getText().equals(LOCATION_PAGE_TITLE_PRICE) &
               driver.findElement(By.xpath(propertyTypeLocator)).getText().equals(TYPE_PAGE_TITLE) &
               driver.findElement(By.xpath(searchRadiusLocator)).getText().equals(RADIUS_PAGE_TITLE_LOCATION) &
               driver.findElement(By.xpath(sortLocator)).getText().equals(SORT_PAGE_LOCATOR);
    }
}
