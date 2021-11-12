package com.Techproed.tests;

import com.github.javafaker.Faker;
import org.junit.Test;

public class Day05_JavaFaker {


    @Test
    public void fakerTest(){

        Faker faker=new Faker();


        String fName=faker.name().firstName();
        String lName=faker.name().lastName();
        String fullName=faker.name().fullName();
        System.out.println("First name:"+ fName);
        System.out.println("Last name:"+ lName);
        System.out.println("Full name:"+ fullName);


        // title
        System.out.println(faker.name().title());

        // city
        System.out.println(faker.address().city());
        System.out.println(faker.address().state());
        System.out.println(faker.phoneNumber());
        System.out.println(faker.number().digits(5));
        System.out.println(faker.phoneNumber().cellPhone());
        System.out.println(faker.internet().emailAddress());
    }
}
