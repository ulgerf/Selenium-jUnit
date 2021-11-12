package com.Techproed.tests;

import com.Techproed.Utilies.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment03 extends TestBase {


    @Test
    public void isEnabled(){
    //Go to https://the-internet.herokuapp.com/dynamic_controls
          driver.get("https://the-internet.herokuapp.com/dynamic_controls");

    //  Click enable Button.
       driver.findElement(By.xpath("//button[.='Enable']")).click();

    // verify the message is equal to “It's enabled!”

       WebElement enable=driver.findElement(By.xpath("//p[@id='message']"));
       Assert.assertTrue(enable.getText().equals("It's enabled!"));

    //verify the textbox is enabled (I can type in the box)
        WebDriverWait waitE=new WebDriverWait(driver,10);
        WebElement  inputText =waitE.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='text']")));
        Assert.assertTrue("inputText.getText()",equals("It's enabled!"));
        Assert.assertTrue(inputText.isEnabled());

    //  click on Disable button.
    driver.findElement(By.xpath("//button[.='Disable']")).click();

    // verify the message is equal to “It's disabled!”
        WebElement disabledElement=driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(disabledElement.getText().equals("It's disabled!"));

    // verify the textbox is disabled (I cannot type in the box)
         WebDriverWait waitDisabled=new WebDriverWait(driver,10);

         WebElement textboxDisabled=waitDisabled.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
         Assert.assertTrue(textboxDisabled.getText().equals("It's disabled!"));
         Assert.assertTrue(textboxDisabled.isEnabled());



    }
}
