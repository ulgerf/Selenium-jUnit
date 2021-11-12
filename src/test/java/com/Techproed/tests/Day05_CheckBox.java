package com.Techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day05_CheckBox {

    WebDriver driver;

    @Before
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
@Test
    public void checkBox(){
        driver.get("https://the-internet.herokuapp.com/checkboxes");
     WebElement checkbox1= driver.findElement(By.xpath("//input[@type='checkbox'])[1]"));
     WebElement checkbox2=driver.findElement(By.xpath("//input[@type='checkbox'])[2]"));

     // then click on checkbox1 if the box is not selected.
     // isSelected() is used to check if checkbox or radio button is checked or unchecked
     // returns true  if checkbox is already selected. Return false if it is not selected

    if(!checkbox1.isSelected()){
       checkbox1.click();
    }

     if(!checkbox2.isSelected()){
        checkbox2.click();
}

    Assert.assertTrue(checkbox1.isSelected());
     Assert.assertTrue(checkbox2.isSelected());


}

}
