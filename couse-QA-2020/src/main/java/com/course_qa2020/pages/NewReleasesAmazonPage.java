package com.course_qa2020.pages;

import com.course_qa2020.framework.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class NewReleasesAmazonPage extends Page {
    public String titleLocator = "//div[@id='zg_banner_text_wrapper']";
    public String BANNER_TEXT_WRAPPER = "Amazon Hot New Releases";
    public String anyDepartmentListLocator = "//ul[@id='zg_browseRoot']//ul[1]//li";
    public String newReleasesListLocator = "//div[@class='zg_homeWidget']//h3";
    public String mostGiftedLocator="//div[@id='zg_tabs']//a[text() = 'Most Gifted']";

    public NewReleasesAmazonPage(RemoteWebDriver driver) {
        super(driver);
    }

    public boolean isTitleCorrect() {
        return driver.findElement(By.xpath(titleLocator)).getText().toLowerCase().contains(BANNER_TEXT_WRAPPER.toLowerCase());
    }

    public boolean isNewReleasesItemsIsInListDepartment() {
        List<String> releasesList = new ArrayList<>();
        List<String> departmentList = new ArrayList<>();

        for (WebElement element : getElements(By.xpath(anyDepartmentListLocator))) {
            String departmentItem = element.getText();
            System.out.println(departmentItem);
            departmentList.add(departmentItem);
        }

        for (WebElement element : getElements(By.xpath(newReleasesListLocator))) {
            String releasesItem = element.getText();
            System.out.println("------------------>"+releasesItem);
            releasesList.add(releasesItem);
        }

        departmentList.retainAll(releasesList);
        for (String element : departmentList) {

            System.out.println("---->"+element);

        }
        return departmentList.size() == releasesList.size();
    }

    public <T extends Page> T navigateMostGiftedLocator(Class<T> clazz) throws Exception {
        driver.findElement(By.xpath(mostGiftedLocator)).click();
        return PageFactory.newPage(driver, clazz);
    }
}
