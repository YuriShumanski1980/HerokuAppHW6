package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FileUpload {
    @Test
    public void fileUpload() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/");
        driver.findElement(By.xpath("//*[text() = 'File Upload']")).click();
        By fileInput = By.xpath("//*[@id='file-upload']");
        String filePath = "D:\\Юрий - После прочтения сжечь!\\Схема от Валика.png";
        driver.findElement(fileInput).sendKeys(filePath);
        driver.findElement(By.xpath("//*[@id='file-submit']")).click();
        driver.findElement(By.xpath("//*[@id='uploaded-files']")).getText();
        Assert.assertEquals("Схема от Валика.png", "Схема от Валика.png");
        driver.quit();
    }
}