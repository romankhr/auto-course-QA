package com.course_qa2020.pages;

import com.course_qa2020.framework.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.List;

public class MonitorPageAmazon extends Page {
    private String topRatedSeeMoreLocator="//div[@class='a-section octopus-pc-card-title']//span[contains(text(),'Top rated')]//following::a[1]";
    private String sectionsTitleLocator="//div[@class='a-section octopus-pc-card-title']";
    public MonitorPageAmazon(RemoteWebDriver driver) {
        super(driver);
    }

    public <T extends Page> T navigateMonitorListPage(Class<T> clazz) throws Exception {

        for (WebElement element : getElements(By.xpath(sectionsTitleLocator))) {
            element.findElement(By.xpath(".//a[1]")).click();
            break;
        }
        return PageFactory.newPage(driver, clazz);
    }
}
