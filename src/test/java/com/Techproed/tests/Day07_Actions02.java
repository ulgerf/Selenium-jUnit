package com.Techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day07_Actions02 {
    /*
     Create a class: Actions2
     Create test method : hoverOver() and test the following scenario:
     Given user is on the https://www.amazon.com/ When use click on “Account” link
     Then verify the page title contains “Your Account”
    * */




    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void hoverOver(){
        driver.get("https://www.amazon.com/ ");




    }
}
