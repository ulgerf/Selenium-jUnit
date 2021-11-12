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
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class Assignment02 {

     WebDriver driver;
    @Before
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com/");

    }
    @Test
    public void dropDownTest() {

        WebElement dropDown = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(dropDown);
        String firstOption = select.getFirstSelectedOption().getText();

        //  assertion for first element.
        Assert.assertEquals("All Departments",firstOption);
        System.out.println(firstOption);

        //  assertion for fourth element.
       String fourthOne=select.getOptions().get(4).getText();
       Assert.assertEquals("Beauty & Personal Care",fourthOne);
       List<WebElement> allOption=select.getAllSelectedOptions();

//      Print all dropdown options.
        for(WebElement allOptions:allOption){
            System.out.println(allOptions.getText());
        }

//    Print options size of dropdown.
        int size=allOption.size();
        System.out.println(size);

//     Check the Appliances in Dropdown options.

        if(allOption.contains("Appliances")){
            System.out.println("True");
        }

      //  if the dropdown is alphabetical or not.

        List<String> DDownList = new ArrayList();
        for (WebElement w : allOption) {
            DDownList.add(w.getText());
        }

        List<String> tempList = DDownList;
        Collections.sort(tempList);
        if (DDownList.equals(tempList)) {
            System.out.println("TRUE, dropdown list is sorted");
        } else {
            System.out.println("FALSE, dropdown list is not sorted");
        }
      }
      @After
      public void tearDown(){
        driver.close();
    }
}





