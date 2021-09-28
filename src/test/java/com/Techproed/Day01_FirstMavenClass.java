package com.Techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day01_FirstMavenClass {
    public static void main(String[] args) {


        // Set up the chrome driver
        WebDriverManager.chromedriver().setup();
        // Create driver
        WebDriver driver=new ChromeDriver();

        // write automation script
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com");
        driver.close();






    }
}
