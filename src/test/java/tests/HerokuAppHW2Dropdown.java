package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HerokuAppHW2Dropdown {
    @Test
    public void herokuAppHW1() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement checkBox1;

        driver.get("http://the-internet.herokuapp.com/");
        driver.findElement(By.xpath("//*[@href = '/dropdown']")).click();
        Select select = new Select(driver.findElement(By.id("dropdown")));

        select.selectByVisibleText("Option 1");

        String text = select.getFirstSelectedOption().getText();
        Assert.assertEquals(text, "Option 1");

        select.selectByVisibleText("Option 2");

        String text1 = select.getFirstSelectedOption().getText();
        Assert.assertEquals(text1, "Option 2");

        driver.quit();

    }
}
