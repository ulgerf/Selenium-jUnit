package com.Techproed.tests;


import com.Techproed.Utilies.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Day08_Actions3 extends TestBase {

    /*
Create a class: Actions3
Create test method : keysUpDown()
Go to google/amazon
Send iPhone X prices => convert small letter capital vice versa.
Highlight the search box by double clicking
* */
//    WebDriver driver;
//    @Before
//    public void setUp(){
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//        driver.manage().window().maximize();
//    }

    @Test
    public void keysUpDown(){


        driver.get("https://www.google.com");
        driver.findElement(By.xpath("(//div[@class='jyfHyd'])[2]")).click();
        WebElement seachBox=driver.findElement(By.xpath("//input[@name='q']"));
        Actions actions=new Actions(driver);
        actions
                .keyDown(seachBox, Keys.SHIFT)
                .sendKeys("iPhone X prices")
                .keyUp(seachBox, Keys.SHIFT).sendKeys("too expensive"+ Keys.ENTER)
                .perform();
    }
//    @After
//    public void tearDown(){
//        driver.close();
//    }
}


