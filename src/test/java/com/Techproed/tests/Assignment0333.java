package com.Techproed.tests;

import com.Techproed.Utilies.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class Assignment0333 extends TestBase {
    /*Since i have before after methods in TestBase, don't use thme in here
     * This is a TEST CLASS and will have only @Test method*/


    @Test
    public void synchronization(){

        driver.get("https://www.google.com");

//        If you see cookies then add this line
//        driver.findElement(By.xpath("//*[@id='L2AGLb']")).click();

        driver.findElement(By.name("q")).sendKeys("porcelain teapot"+ Keys.ENTER);
        Assert.assertTrue(driver.getPageSource().contains("porcelain teapot"));
    }


    @Test
    public void test2(){
        driver.get("https://www.amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("porcelain teapot"+ Keys.ENTER);
        Assert.assertTrue(driver.getPageSource().contains("porcelain teapot"));
    }


}