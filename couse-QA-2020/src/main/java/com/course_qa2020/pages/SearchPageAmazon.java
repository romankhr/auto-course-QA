package com.course_qa2020.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.concurrent.TimeUnit;

public class SearchPageAmazon extends Page {
    public String customerReview4Locator = "//i[@class='a-icon a-icon-star-medium a-star-medium-4']";
    public String lowPriceLocator = "//input[@id='low-price']";
    public String goButtonLocator = "//span[@id='a-autoid-1']//input[1]";
    public String resultsCardsLocator = "//div[@class='s-include-content-margin s-border-bottom s-latency-cf-section']";
    public String limitedTimeDealLocator = "//div[@class='s-include-content-margin s-border-bottom s-latency-cf-section']//span[text() = 'Limited time deal']";
    public String customerRatingLocator = "//div[@class='s-include-content-margin s-border-bottom s-latency-cf-section']//span[@class='a-icon-alt']";
    public String priceLocator = "//div[@class='s-include-content-margin s-border-bottom s-latency-cf-section']//span[@class='a-price-whole']";

    public SearchPageAmazon(RemoteWebDriver driver) {
        super(driver);
    }

    public SearchPageAmazon setCustomerReview() {
        driver.findElement(By.xpath(customerReview4Locator)).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return this;
    }

    public SearchPageAmazon setMinPrice(String minPrice) {
        driver.findElement(By.xpath(lowPriceLocator)).sendKeys(minPrice);
        return this;
    }

    public SearchPageAmazon goButton(String minPrice) {
        driver.findElement(By.xpath(goButtonLocator)).click();
        return this;
    }

    public boolean isResultCorrect(String minPrice) {
        boolean result = true;
        boolean limitedDeal=false;
        int minimumPrice = Integer.parseInt(minPrice);
        int realPrice;
        for (WebElement element : getElements(By.xpath(resultsCardsLocator))) {
            try
            {
                element.findElement(By.xpath(".//span[@class='a-badge']")).isDisplayed();
                driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
                limitedDeal=true;
            }
            catch (Exception ex)
            {
                limitedDeal=false;
            }
            if (!limitedDeal) {
                realPrice = Integer.parseInt(element.findElement(By.xpath(".//span[@class='a-price-whole']")).getText().replaceAll("[^\\d]", ""));
                System.out.println(realPrice);
                if (realPrice < minimumPrice) {
                    result = false;
                    break;
                }
                limitedDeal=false;
            }
        }
        return result;
    }
}
