package com.course_qa2020.course;

import com.course_qa2020.pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest {
    private String acceptCookiesButtonLocator = "//button[@class=\"ui-button-primary ui-cookie-accept-all-medium-large\"]";
    private RemoteWebDriver driver;
    private HomePage homePage;

    @BeforeMethod
    public void setup() {
        //TODO why we can't use this in the BaseTest?
        driver.get("https://www.zoopla.co.uk");

        if (driver.findElement(By.xpath(acceptCookiesButtonLocator)).isDisplayed()) {
            driver.findElement(By.xpath(acceptCookiesButtonLocator)).click();
        }
        homePage = new HomePage(driver);
    }

    //TODO please remove if doesn't required
//    @Test(priority = 0, suiteName = "main")
//    public void mainUrlTest() {
//
//        //Given user opens a browser and provides a valid url
//
//        //When user clicks enter
//
//        //And
//
//        //Then user is redirected to the main page
////        Assert.assertTrue(driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).isDisplayed());
//    }
}
