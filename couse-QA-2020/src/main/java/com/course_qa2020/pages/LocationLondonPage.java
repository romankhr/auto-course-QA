package com.course_qa2020.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class LocationLondonPage extends Page{

    private String searchTermLocatorLocation="//h1[@class='css-mh5azd-Heading1 e1s8jdjv5']";

    public LocationLondonPage(RemoteWebDriver driver) {
        super(driver);
    }

    public boolean isTitleCorrect(String searchTerm){
        return driver.findElement(By.xpath(searchTermLocatorLocation)).getText().toLowerCase().contains(searchTerm.toLowerCase());
    }
}
