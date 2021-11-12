package com.Techproed.Utilies;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public abstract class TestBase {
    //Making TestBase abstract cause we don't want to create an object of TestBase class
    //We want to use the objects or methods in this class by extending it
    protected WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();

    }
    @After
    public void tearDown(){
//        driver.close();
    }
}
