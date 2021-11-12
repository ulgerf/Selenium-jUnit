package com.Techproed.tests;

import com.Techproed.Utilies.TestBase;
import org.junit.Test;
import org.openqa.selenium.Cookie;

import java.util.Set;

public class Day09_Cookies extends TestBase {

                    /*Class: Day09_Cookies
                    Method: handleCookies



                    3. Get the cookies by their name
                    4. Add new cookie
                    5. Delete cookie by name
                    6. Delete all of the cookies*/
    @Test
    public void handleCookies(){

        // -Go to amazon
        driver.get("https://www.amazon.com");
        //1. Find the total number of cookies
        Set<Cookie> allCookies=driver.manage().getCookies();
        int numOfCookies=allCookies.size();
        System.out.println("number of cookies" +numOfCookies);

     // 2. Print all the cookies:names  and value
        for(Cookie eachCookie:allCookies){
            System.out.println(" cookie names "+eachCookie.getName());
            System.out.println(" cookie value "+eachCookie.getValue());
        }

//  3. Get the cookies by their name
        System.out.println("Cookie named sp-cdn==>"+driver.manage().getCookieNamed("sp-cdn"));

// 4. Add new cookie
        //creating new object
        Cookie myCookie= new Cookie("My Cookie Monster","Cookie Monster 1");
        driver.manage().addCookie(myCookie);
        allCookies=driver.manage().getCookies();
        System.out.println("number of cookie:"+allCookies.size());

  // 5. Delete cookie by name
        driver.manage().deleteCookieNamed("session-token");
        allCookies=driver.manage().getCookies();
        System.out.println("number of cookie:"+allCookies.size());

        // 6. Delete all of the cookies*

        driver.manage().deleteAllCookies();
        allCookies=driver.manage().getCookies();
        System.out.println("number of cookie:"+allCookies.size());
    }
}
