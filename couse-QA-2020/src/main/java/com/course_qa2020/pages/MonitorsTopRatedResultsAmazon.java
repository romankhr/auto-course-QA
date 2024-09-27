package com.course_qa2020.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MonitorsTopRatedResultsAmazon extends Page {
    private String averageSortingLocator = "//a[text()='Avg. Customer Review']";
    private String ratingLocator = "//div[@class='s-include-content-margin s-border-bottom s-latency-cf-section']//span[@class='a-size-base']";
    private String focusRatingLocator = "//span[@id='a-autoid-0']";

    public MonitorsTopRatedResultsAmazon(RemoteWebDriver driver) {
        super(driver);
    }

    public MonitorsTopRatedResultsAmazon focusingOnRating() {
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        driver.findElement(By.xpath(focusRatingLocator)).click();
        return this;
    }

    public MonitorsTopRatedResultsAmazon averageSorting() {
        driver.findElement(By.xpath(averageSortingLocator)).click();
        return this;
    }

    public boolean isSortedPageSorted() {
        List<Integer> results = new ArrayList<>();
        List<Integer> expectedResults = new ArrayList<>();

        for (WebElement element : getElements(By.xpath(ratingLocator))) {
            String price = element.getText().replaceAll("[^\\d]", "");
            System.out.println(price);
            if (price.isEmpty())
                continue;
            results.add(Integer.parseInt(price));
            expectedResults.add(Integer.parseInt(price));
            Collections.sort(expectedResults, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return Integer.compare(o1, o2);
                }
            });

            if (!results.get(results.size() - 1).equals(expectedResults.get(expectedResults.size() - 1)))
                return false;
        }
        return true;
    }
}
