package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class Frames {

//TODO-Just for training
//    @Test
//    public void enterFramesPage() {
//        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//        driver.get("http://the-internet.herokuapp.com/");
//        driver.findElement(By.xpath("//*[text() = 'Frames']")).click();
//        driver.findElement(By.xpath("//*[text() ='iFrame']")).click();
//        driver.quit();
//    }

    @Test
    public void switchIframePage() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/iframe");
        driver.switchTo().frame(driver.findElement(By.id("mce_0_ifr")));
        driver.findElement(By.xpath("//*[@id= 'tinymce']")).getText();
        Assert.assertEquals("Your content goes here.", "Your content goes here.");
        driver.switchTo().defaultContent();
        driver.quit();
    }
}