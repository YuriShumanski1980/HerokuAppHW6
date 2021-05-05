//Add/Remove Elements
package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class HerokuAppHW1AddRemoveElements {

    @Test
    public void addRemoveElementsHW1Test(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/");
        driver.findElement(By.xpath("//*[@href ='/add_remove_elements/']")).click();
        driver.findElement(By.xpath("//*[@onclick ='addElement()']")).click();
        driver.findElement(By.xpath("//*[@onclick ='addElement()']")).click();
        driver.findElement(By.xpath("//*[@onclick ='deleteElement()']")).click();
        boolean isDeleteButtonOnScreen = driver.findElement(By.xpath("//*[@onclick ='deleteElement()']")).isDisplayed();
        Assert.assertTrue(isDeleteButtonOnScreen);
        int count = driver.findElements(By.xpath("//*[@onclick]")).size();
        System.out.println(count);
        boolean isButtonOnScreen = driver.findElement(By.xpath("//*[@onclick ]")).isDisplayed();
        Assert.assertTrue(isButtonOnScreen);
        driver.quit();
    }
}
