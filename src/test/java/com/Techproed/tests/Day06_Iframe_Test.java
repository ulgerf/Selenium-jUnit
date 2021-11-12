package com.Techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day06_Iframe_Test {
  /*
  * Create a class: IFrameTest
 Create a method: iframeTest
 Go to https://the-internet.herokuapp.com/iframe
 Verify the Bolded text contains “Editor”
 Locate the text box
 Delete the text in the text box
 Type “This text box is inside the iframe”
 Verify the text Elemental Selenium text is displayed on the page */


    WebDriver driver;

    @Before
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/iframe");



    }
    @Test
    public void iframeTest(){
        //Verify the Bolded text contains “Editor”
        String actualText = driver.findElement(By.xpath("//h3")).getText();
        String expectedTExt = "Editor";
        Assert.assertTrue(actualText.contains(expectedTExt));
        //Locate the text box
        // The text box in an iframe
        // To be able to reach - click - sendkeys --- i have to switch to the iframe
        // There are 3 ways,   --Index--
        // 1---- Switching iframe by using index
        //driver.switchTo().frame(0);
        // 2-- Class or Id
        //driver.switchTo().frame("mce_0_ifr");
        // 3 -- webelemet
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']")));
        //<iframe id="mce_0_ifr" frameborder="0" allowtransparency="true"
        // title="Rich Text Area. Press ALT-0 for help." class="tox-edit-area__iframe"></iframe>
        WebElement textBox = driver.findElement(By.xpath("//p"));
        textBox.clear();
        textBox.sendKeys("This text box is inside the iframe");
        //driver.switchTo().defaultContent();
        driver.switchTo().parentFrame();
        // WE are still in the iframe so we can't see any element on the webpage
        Assert.assertTrue(driver.findElement(By.linkText("Elemental Selenium")).isDisplayed());
    }

    @After
    public void tearDown(){
        driver.close();
    }
}
