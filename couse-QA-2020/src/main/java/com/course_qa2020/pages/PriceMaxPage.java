package com.course_qa2020.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class PriceMaxPage extends Page{
    //TODO same as previously about naming and using capitals
    private String priceMaxLocator="//div[@class='css-ijwzpf-ButtonWrapper e1tnwg465']//p[contains(text(),'£500k max')]";
    private String LOCATION_PAGE_TITLE_MAX="£500k max";

    public PriceMaxPage(RemoteWebDriver driver) {
        super(driver);
    }
    public boolean isTitleCorrect(){
        return driver.findElement(By.xpath(priceMaxLocator)).getText().equals(LOCATION_PAGE_TITLE_MAX);
    }

}
