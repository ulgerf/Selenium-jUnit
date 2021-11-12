package com.Techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Day07_windowHandle {
    /*
    * Create a new Class Tests package: Day08_WindowHandleExample Method name:windowHandle
      Given user is on the https://the-internet.herokuapp.com/windows Then user verifies the text : “Opening a new window”
      Then user verifies the title of the page is “The Internet” When user clicks on the “Click Here” button
      Then user verifies the new window title is “New Window” Then user verifies the text: “New Window”
       When user goes back to the previous window and then verifies the title : “The Internet”*/



    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void windowsHandle() throws InterruptedException {
        // Given user is on the https://the-internet.herokuapp.com/windows
        // Then user verifies the text : “Opening a new window”

        driver.get("https://the-internet.herokuapp.com/windows");
        String firstWindowTest = driver.findElement(By.xpath("//h3[.='Opening a new window']")).getText();
        String expectedText = "Opening a new window";
        Assert.assertEquals(expectedText,firstWindowTest);

        //   Then user verifies the title of the page is “The Internet”


        String firstWindowTitle = driver.getTitle();
        System.out.println(firstWindowTitle);
        String expectedTitle = "The Internet";
        Assert.assertEquals(expectedTitle,driver.getTitle());


        //   When user clicks on the “Click Here” button

        driver.findElement(By.linkText("Click Here")).click();

        // Then user verifies the new window title is “New Window” Then user verifies the text: “New Window”

        // First Windows' Handle
        String window1Handle = driver.getWindowHandle();
        System.out.println(window1Handle);

        // Get All Windows Handles
        Set<String> allWindowHandles = driver.getWindowHandles();

        // How can we switch between windows
        for (String eachWindowHandle:allWindowHandles){
            if(!eachWindowHandle.equals(window1Handle)){
                driver.switchTo().window(eachWindowHandle);
                break; } }

        // Driver is on windows2

        String window2Handle = driver.getWindowHandle();
        //Then user verifies the new window title is “New Window”
        Assert.assertEquals("New Window",driver.getTitle());

        // Then user verifies the text: “New Window”

        String actuelSecondText = driver.findElement(By.xpath("//h3[.='New Window']")).getText();
        Assert.assertEquals(actuelSecondText,"New Window");

        // Going Back to Window1
        driver.switchTo().window(window1Handle);

        Thread.sleep(5000);
        Assert.assertEquals("The Internet",driver.getTitle());

        // Going to Window2 again
        driver.switchTo().window(window2Handle);

        // Verify you are on windows2
        Assert.assertEquals("New Window",driver.getTitle());

    }

    @After
    public void tearDown(){
        driver.quit();
    }


}