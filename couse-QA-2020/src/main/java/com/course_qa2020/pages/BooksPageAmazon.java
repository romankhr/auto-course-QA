package com.course_qa2020.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BooksPageAmazon extends Page {
    public String mostGiftedInBooksLocator = "//span[@class='a-size-small aok-float-left zg-badge-body zg-badge-color']";
    public String ratingLocator = "//li[@class='zg-item-immersion']//span[@class='a-icon-alt']";

    public BooksPageAmazon(RemoteWebDriver driver) {
        super(driver);
    }

    public boolean isRatingPresented() {
        boolean result = false;
        for (WebElement element : getElements(By.xpath(mostGiftedInBooksLocator))) {
            result = element.findElement(By.xpath(".//span")).isDisplayed();
            if (!result) {
                break;
            }
        }
        return result;
    }
}
