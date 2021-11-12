package com.Techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day04_GoogleSearchE {

    WebDriver driver;

    @Before
    public void seUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
         // adding implicit wait: implicit wait is dynamic wait
        // adding implicit wait
        //  wait up to 30 second when needed
        // This means, if driver needs 1 seconds wait, then wait will be Only 1 second
        // -page is slow -internet is slow- database is slow- lots of image- local computer is slow
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @Test
    public void teaPotSearch(){
        driver.get("https://www.google.com");
        driver.findElement(By.xpath("//input[@name='q]")).
                sendKeys("porcelain teapot"+ Keys.ENTER);

        // Printing number of results
        String resultText=driver.findElement(By.xpath("//div[@id='result-stats']")).
                getText().substring(6,17);
        System.out.println(resultText);//18.800.000

    }
    @After
    public void tearDown(){
        driver.close();
    }
}
