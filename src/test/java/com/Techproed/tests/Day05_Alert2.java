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

public class Day05_Alert2 {
    /*
    Go to https://the-internet.herokuapp.com/javascript_alerts
      Create a class: AlertTest
      Create setUp method
      Create 3 test methods:
acceptAlert() => click on the first alert, verify the text “I am a JS Alert” , click OK , and Verify “You successfully clicked an alert”
dismissAlert()=> click on the second alert, verify text "I am a JS Confirm”, click cancel, and Verify “You clicked: Cancel”
sendKeysAlert()=> click on the third alert, verify text “I am a JS prompt”, type “Hello World”, click OK, and Verify “You entered: Hello Word”

     */
    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

    }
    //acceptAlert() => click on the first alert, verify the text “I am a JS Alert” ,
    // click OK , and Verify “You successfully clicked an alert”

    @Test
    public void acceptAlert(){
        // Find the alert button
        WebElement alertButton = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        alertButton.click();

        //driver.findElement(By.xpath("//button[@onclick='jsAlert()']").click();

        //    driver.switchTo().alert().accept();

        // Get Text of The alert

        String actualAlertText = driver.switchTo().alert().getText();
        System.out.println(actualAlertText);
        String expectedAlertText = "I am a JS Alert";
        Assert.assertEquals(expectedAlertText,actualAlertText);
        driver.switchTo().alert().accept();
    }

        //dismissAlert()=> click on the second alert,
        // verify text "I am a JS Confirm”, click cancel, and Verify “You clicked: Cancel”

    @Test
    public void dismissAlert(){
        WebElement alertButton = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        alertButton.click();
        String expectedText = "I am a JS Confirm";
        Assert.assertEquals("Result Doesn't Match",expectedText,driver.switchTo().alert().getText());
        driver.switchTo().alert().dismiss();
        String expectedResult = "You clicked: Cancel";
        String result = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(expectedResult,result);

    }

    //sendKeysAlert()=> click on the third alert, verify text “I am a JS prompt”,
    // type “Hello World”, click OK, and Verify “You entered: Hello World”
    @Test
    public void sendKeys(){
        WebElement alertButton = driver.findElement(By.xpath("//*[@onclick='jsPrompt()']"));
        alertButton.click();
        String expectedText = "I am a JS prompt";
        String actualText = driver.switchTo().alert().getText();
        //   Assert.assertTrue(expectedText.equals(actualText));
        Assert.assertEquals(expectedText,actualText);
        // type Hello World
        // String text = "Hello World"
        driver.switchTo().alert().sendKeys("Hello World");
        driver.switchTo().alert().accept();
        String result = driver.findElement(By.id("result")).getText();

        String expectedResult = "You entered: Hello World";
        Assert.assertEquals(expectedResult,result);

    }

    @After
    public void tearDown(){
        driver.close();
    }
}