package course;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstWebTests{

    private RemoteWebDriver driver;
    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "driver//chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
    @Test(priority = 0, suiteName = "main")
    public void locationTest() {

        //Given user opens a browser and provides a valid url
        driver.get("https://www.zoopla.co.uk");
        //When user clicks enter

        //And

        //Then user is redirected to the main page
          Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'e.g. Oxford, NW3 or Waterloo Station')]")).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.xpath("//button[@id='search-submit']")).isDisplayed());
    }


    @Test(priority = 1, suiteName = "main")
    public void minPriceTest() {

        //Given user opens a browser and provides a valid url
        driver.get("https://www.zoopla.co.uk");
        //When user clicks enter

        //And

        //Then user is redirected to the main page
        Assert.assertTrue(driver.findElement(By.xpath("//select[@id='forsale_price_min']")).isDisplayed());
    }

    @Test(priority = 2, suiteName = "main")
    public void maxPriceTest() {

        //Given user opens a browser and provides a valid url
        driver.get("https://www.zoopla.co.uk");
        //When user clicks enter

        //And

        //Then user is redirected to the main page
        Assert.assertTrue(driver.findElement(By.xpath("//select[@id='forsale_price_max']")).isDisplayed());
    }

    @Test(priority = 2, suiteName = "main")
    public void propertyTest() {

        //Given user opens a browser and provides a valid url
        driver.get("https://www.zoopla.co.uk");
        //When user clicks enter

        //And

        //Then user is redirected to the main page
        Assert.assertTrue(driver.findElement(By.xpath("//select[@id='property_type']")).isDisplayed());
    }

    @Test(priority = 2, suiteName = "main")
    public void numbersOfBedroomsTest() {

        //Given user opens a browser and provides a valid url
        driver.get("https://www.zoopla.co.uk");
        //When user clicks enter

        //And

        //Then user is redirected to the main page
        Assert.assertTrue(driver.findElement(By.xpath("//select[@id='beds_min']")).isDisplayed());
    }
}
