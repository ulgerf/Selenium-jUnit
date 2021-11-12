package com.Techproed.tests;

import com.Techproed.Utilies.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class Day08_TestBaseDemo extends TestBase {

    /* Since i have before after methods in test base, dont use them in here */


    @Test
    public void test1() {
        driver.get("https://www.google.com");
        driver.findElement(By.xpath("//*[@id='L2AGLb']")).click();
        driver.findElement(By.name("q")).sendKeys("porcelain teapot " + Keys.ENTER);
        Assert.assertTrue(driver.getPageSource().contains("porcelain teapot"));

    }

    @Test
    public void test2() {
        driver.get("https://www.amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("porcelain teapot " + Keys.ENTER);
        Assert.assertTrue(driver.getPageSource().contains("porcelain teapot"));
    }
}