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
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class Day07_Actions01 {

    /*
    Create a class: Actions1
 Create a test method : contextClickMethod() and test the following scenario:
Given user is on the https://the-internet.herokuapp.com/context_menu When use Right clicks on the box
 Then verify the alert message is “You selected a context menu”
 Then accept the alert
    * */
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
    }

    @Test
    public void contextClickMethod() {
        // Right Click to a spesific element
        // 1-- Create an object from Actions Class
        Actions actions = new Actions(driver);
        // Fİnd the element to be rightclicked
        WebElement rightClick = driver.findElement(By.id("hot-spot"));
        // Do rightclick
        actions.contextClick(rightClick).perform();
        //Then verify the alert message is “You selected a context menu”
        String alertText = driver.switchTo().alert().getText();
        Assert.assertEquals("You selected a context menu", alertText);
        // Then accept the alert
        driver.switchTo().alert().accept();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}