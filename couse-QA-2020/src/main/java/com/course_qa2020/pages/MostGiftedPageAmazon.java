package com.course_qa2020.pages;

import com.course_qa2020.framework.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MostGiftedPageAmazon extends Page {
    private String booksLocator="//div[@id='zg_left_col2']//a[text() = 'Books']";

    public MostGiftedPageAmazon(RemoteWebDriver driver) {
        super(driver);
    }

    public <T extends Page> T navigateBooksPage(Class<T> clazz) throws Exception {
        driver.findElement(By.xpath(booksLocator)).click();
        return PageFactory.newPage(driver, clazz);
    }
}
