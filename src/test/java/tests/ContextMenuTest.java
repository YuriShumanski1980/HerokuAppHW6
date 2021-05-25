package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class ContextMenuTest {

    @Test
    public void rightMouseClick() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/");
        driver.findElement(By.xpath("//*[text() = 'Context Menu']")).click();
        Actions actions = new Actions(driver);
        WebElement elementLocator = driver.findElement(By.xpath("//*[@id = 'hot-spot']"));
        actions.contextClick(elementLocator).perform();
        Alert alertDialog = driver.switchTo().alert();
        alertDialog.accept();
        driver.quit();
    }
}