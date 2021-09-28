package com.Techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day02_LocatorsIntro {
    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();



    }
    @After
    public void tearDown(){

    // driver.close();
    }
    @Test
    public void locators(){

        driver.get("http://a.testaddressbook.com/sign_in");
//        driver
//                .findElement(By.id("session_email"))//Locating the element by id
//                .sendKeys("testtechproed@gmail.com");//typing in the element
        //OR RETURN TYPE OF findElement is WebElement
        WebElement emailBox=driver.findElement(By.id("session_email"));
        emailBox.sendKeys("testtechproed@gmail.com");


        //Password Element:
        driver.findElement(By.name("session[password]")).sendKeys("Test1234!");

        //Locating sign in button and click on it
        driver.findElement(By.name("commit")).click();

//        Then verify that the expected user id
//        testtechproed@gmail.com (USE getText() method to get the text from the page)

        WebElement userId =  driver.findElement(By.className("navbar-text"));
        System.out.println(userId);//[[ChromeDriver: chrome on MAC (6a9bf850925e56865c7ce9fb0a0faa68)] -> class name: navbar-text]

//        getText(); return the test of the webelements. Return type is a String.
        String userIdText = userId.getText();
        System.out.println(userIdText);//testtechproed@gmail.com

        //OR
//        String userIdText = driver.findElement(By.className("navbar-text")).getText();
        String expectedUserId="testtechproed@gmail.com";
        Assert.assertEquals(expectedUserId,userIdText);

//        Verify the Addresses and Sign Out texts are displayed
//        Find the number of total link on the page
//        Sign out from the page



    }
}





