package flipkart;

import java.util.*;
import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class flipkartTask {
	
public static void main(String[] args) throws InterruptedException {
	WebDriverManager.chromedriver().setup();
    WebDriver driver =new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    driver.get("https://www.flipkart.com/");
    Thread.sleep(2000);

    WebElement popup = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
    popup.click();

    WebElement serachBox=driver.findElement(By.xpath("//input[@placeholder='Search for products, brands and more']"));
    serachBox.sendKeys("ipad");

    Thread.sleep(2000);
    List <WebElement>  list = driver.findElements(By.xpath("//ul[@class='col-12-12 _1MRYA1 _38UFBk']//li[@class='Y5N33s']//div[1]//a[1]//div[2]//span[contains(text(),'ipad')]"));

    System.out.println("size of ipad suggestions : " + list.size());

    for (WebElement option : list )
    {
        if(option.getText().contains("ipad"))
        {
            option.click();
            break;
        }
    }


    WebElement ipad9thGen= driver.findElement(By.xpath("//img[@alt='APPLE iPad (9th Gen) 64 GB ROM 10.2 inch with Wi-Fi Only (Space Grey)']"));

    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("arguments[0].click();",ipad9thGen);

   Set<String> set= driver.getWindowHandles();
   List<String> handles= new ArrayList<String>(set);
    driver.switchTo().window(handles.get(1));

    WebElement buyNowBtn=driver.findElement(By.xpath("//button[normalize-space()='Buy Now']"));
    buyNowBtn.click();

    String mobile= RandomStringUtils.randomNumeric(10);

    WebElement EnterMobNo =driver.findElement(By.xpath("//input[@class='_2IX_2- _17N0em']"));
    EnterMobNo.sendKeys(mobile);

    WebElement continueBtn = driver.findElement(By.xpath("//span[normalize-space()='CONTINUE']"));

    continueBtn.click();
}
}
