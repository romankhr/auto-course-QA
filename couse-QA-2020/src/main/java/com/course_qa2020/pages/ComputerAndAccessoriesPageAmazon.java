package com.course_qa2020.pages;

import com.course_qa2020.framework.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ComputerAndAccessoriesPageAmazon extends Page {
    private String monitorLocator="//div[@id='nav-subnav']/a[9]";
    private String tabletsLocator="//div[@id='nav-subnav']/a[7]";
    public ComputerAndAccessoriesPageAmazon(RemoteWebDriver driver) {
        super(driver);
    }

    public <T extends Page> T navigateMonitorPage(Class<T> clazz) throws Exception {
        driver.findElement(By.xpath(monitorLocator)).click();
        return PageFactory.newPage(driver, clazz);
    }

    public <T extends Page> T navigateTabletsPage(Class<T> clazz) throws Exception {
        driver.findElement(By.xpath(tabletsLocator)).click();
        return PageFactory.newPage(driver, clazz);
    }
}
