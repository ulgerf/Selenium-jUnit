package com.Techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Day08_iframeTest {

    // How do you find the iframe number
    WebDriver driver;

    @Before
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");



}
@Test
    public void number() {

    List<WebElement> frameList = driver.findElements(By.tagName("iframe"));
    int numberFrames = frameList.size();
    System.out.println("the number of iframe: " + numberFrames);

}

    @Test
    public void numberOfFrames(){
        driver.get("https://amazon.com");
        //  List<WebElement> frameList = driver.findElements(By.tagName("iframe"));
        List<WebElement> frameList = driver.findElements(By.xpath("//iframe"));
        int numberOfFrames = frameList.size();
        System.out.println("The number of iframes is "+numberOfFrames);
    }
    @Test
    public void numberOfFramesConstant(){
        driver.get("https://the-internet.herokuapp.com/iframe");
        List<WebElement> frameList = driver.findElements(By.xpath("//iframe"));
        int numberOfFrames = frameList.size();
        System.out.println("The number of iframes is "+numberOfFrames);
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}