package com.course_qa2020.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.concurrent.TimeUnit;

public class TabletsPageAmazon extends Page {
    public String primeCheckBoxLocator = "//i[@class='a-icon a-icon-prime a-icon-medium apb-browse-refinements-icon']";
    public String cardItemLocator = "//div[@class='s-include-content-margin s-border-bottom s-latency-cf-section']";
    public String primeLocator = ".//i[@class='a-icon a-icon-prime a-icon-medium']";
    public String freeDeliveryLocator = ".//span[text()='FREE Delivery by Amazon']";

    public TabletsPageAmazon(RemoteWebDriver driver) {
        super(driver);
    }

    public TabletsPageAmazon setCheckBox() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.xpath(primeCheckBoxLocator)).click();
        return this;
    }

    public boolean isResultListCorrect() {
        boolean prime = false;
        boolean freeDelivery = false;
        for (WebElement element : getElements(By.xpath(cardItemLocator))) {
            try {
                element.findElement(By.xpath(primeLocator)).isDisplayed();
                driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
                prime = true;
            } catch (Exception ex) {
                prime = false;
            }
            try {
                element.findElement(By.xpath(freeDeliveryLocator)).isDisplayed();
                driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
                freeDelivery = true;
            } catch (Exception ex) {
                freeDelivery = false;
            }
            System.out.println("prime " + prime+"------- freedelivery "+freeDelivery);
            if (!(prime || freeDelivery)) {
                return false;
            }
            prime = false;
            freeDelivery = false;
        }
        return true;
    }
}
