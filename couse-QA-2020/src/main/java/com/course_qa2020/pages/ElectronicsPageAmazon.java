package com.course_qa2020.pages;

import com.course_qa2020.framework.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ElectronicsPageAmazon extends Page {
    private String computersAndAccessoriesLocator="//div[@id='nav-subnav']//a[8]";

    public ElectronicsPageAmazon(RemoteWebDriver driver) {
        super(driver);
    }
    public <T extends Page> T navigateComputersAndAccessories(Class<T> clazz) throws Exception {
        driver.findElement(By.xpath(computersAndAccessoriesLocator)).click();
        return PageFactory.newPage(driver, clazz);
    }

}
