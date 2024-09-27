package com.course_qa2020.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class PropertyTypePage extends Page{
    //TODO please update namings
    private String propertyTypeLocator="//div[@class='css-ijwzpf-ButtonWrapper e1tnwg465']//p[contains(text(),'Houses')]";
    private String LOCATION_PAGE_TITLE="Houses";

    public PropertyTypePage(RemoteWebDriver driver) {
        super(driver);
    }
    public boolean isTitleCorrect(){
        return driver.findElement(By.xpath(propertyTypeLocator)).getText().equals(LOCATION_PAGE_TITLE);
    }
}
