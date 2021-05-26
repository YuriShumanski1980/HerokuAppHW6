package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicControlsPage {

    @Test
    public void dynamicControlsRemoveAdd() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/");
        driver.findElement(By.xpath("//*[text() = 'Dynamic Controls']")).click();
        driver.findElement(By.xpath("//*[@label = 'blah']")).click();
        driver.findElement(By.xpath("//*[@onclick = 'swapCheckbox()']")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='message']")));
        driver.findElement(By.xpath("//*[@id='message']")).getText();
        Assert.assertEquals("It's gone!", "It's gone!");
        driver.quit();
    }

    @Test
    public void dynamicControlsEnableDisable() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/");
        driver.findElement(By.xpath("//*[text() = 'Dynamic Controls']")).click();
        driver.findElement(By.xpath("//*[@type= 'text']")).getAttribute("disabled");
        driver.findElement(By.xpath("//*[@onclick ='swapInput()']")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='message']")));
        driver.findElement(By.xpath("//*[@type= 'text']")).sendKeys("inPut enAbled");
        driver.findElement(By.xpath("//*[@type= 'text']")).getText();
        Assert.assertEquals("inPut enAbled", "inPut enAbled");
        driver.quit();
    }
}