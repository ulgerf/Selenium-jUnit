package com.Techproed.tests;

import com.github.javafaker.Faker;
import com.github.javafaker.PhoneNumber;
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

import java.util.concurrent.TimeUnit;

public class Assignment01 {

    WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");
    }
      @Test
      public void assignment(){
      // 3.Click on sign in link.
          driver.findElement(By.linkText("Sign in")).click();
      // 4.Send your email and click on create an account button.
          Faker faker=new Faker();
          String email=faker.internet().emailAddress();
          driver.findElement(By.id("email_create")).sendKeys(email);
          driver.findElement(By.id("SubmitCreate")).click();
      // 5.Verify the Text : CREATE AN ACCOUNT
          WebElement TextVerify= driver.findElement(By.xpath("//body[@id='authentication']"));
          Assert.assertTrue(TextVerify.isDisplayed());
      // 6. Verify the Text : YOUR PERSONAL INFORMATION.
          WebElement TextVPersonal= driver.findElement(By.xpath("//h3[.='Your personal information']"));
          Assert.assertTrue(TextVPersonal.isDisplayed());
       // 7. Verify the Text : Title
          WebElement VerifyTextTitle= driver.findElement(By.xpath("//label[.='Title']"));
          Assert.assertTrue(VerifyTextTitle.isDisplayed());
       // 8. Select your title (Radio button)== Select your title
          WebElement MrsOption= driver.findElement(By.id("id_gender2"));
          if (!MrsOption.isSelected()){
              MrsOption.click();
          }
       //9. Enter your first name
          String FName=faker.name().firstName();
          driver.findElement(By.id("customer_firstname")).sendKeys(FName);
      //10. Enter your last name
          String lName=faker.name().lastName();
          driver.findElement(By.id("customer_lastname")).sendKeys(lName);
      //11. Enter your email
          driver.findElement(By.id("email"));
      //12. Enter your password
          String passWord=faker.internet().password();
          driver.findElement(By.id("passwd")).sendKeys(passWord);
        //13. ENTER DATE OF BIRTH (dropDown button)
          WebElement day=driver.findElement(By.id("days"));
          Select selectDay=new Select(day);
          selectDay.selectByIndex(1);

          WebElement month=driver.findElement(By.id("months"));
          Select selectMonth=new Select(month);
          selectMonth.selectByIndex(1);

          WebElement year=driver.findElement(By.id("years"));
          Select selectYear=new Select(year);
          selectYear.selectByValue("2000");

         // 14. Click on Sign up for our newsletter!
        driver.findElement(By.id("uniform-newsletter")).click();
        //15. Enter your first name.
        driver.findElement(By.id("firstname")).sendKeys(FName);
        // 16. Enter your last lastname
        driver.findElement(By.id("lastname")).sendKeys(lName);
         //17. Enter your company
          String company=faker.company().name();
          driver.findElement(By.id("company")).sendKeys(company);
        //18. Enter your Address
          String adr=faker.address().fullAddress();
          driver.findElement(By.id("address1")).sendKeys(adr);
          String adr2=faker.address().fullAddress();
          driver.findElement(By.id("address2")).sendKeys(adr2);
        //19. Enter your City
          String cityA=faker.address().city();
          driver.findElement(By.id("city")).sendKeys(cityA);
        //20. SELECT STATE
          String state=faker.address().state();
          driver.findElement(By.id("id_state")).sendKeys(state);
          // 21. Enter Postal Code
          String PostalC=faker.address().state();
          driver.findElement(By.id("postcode")).sendKeys(PostalC);
          //22.SELECT COUNTRY
          String countryN=faker.address().country();
          driver.findElement(By.id("id_country")).sendKeys(countryN);
          //23. additional information
          String additional =faker.lorem().sentence();
          driver.findElement(By.id("other")).sendKeys(additional);
          //24. Enter home phone
          String PhoneN=faker.phoneNumber().subscriberNumber();
          driver.findElement(By.id("other")).sendKeys(PhoneN);
          //25. Enter mobile phone
          String CellPhoneN=faker.phoneNumber().cellPhone();
          driver.findElement(By.id("phone_mobile")).sendKeys(CellPhoneN);
         //26. Enter reference name
          String referenceN=faker.number().digits(7);
          driver.findElement(By.id("alias")).sendKeys(referenceN);
          //27. Click Register
          driver.findElement(By.id("submitAccount")).click();
          //28. Then verify MY ACCOUNT is displayed on the home page-SEE BELOW IMAGE
          WebElement myAccountDisplay = driver.findElement(By.xpath("//h1[@class='page-heading']"));
          Assert.assertTrue(myAccountDisplay.isDisplayed());
           }
          @After
        public void tearDown(){
        driver.close();

      }

    }

