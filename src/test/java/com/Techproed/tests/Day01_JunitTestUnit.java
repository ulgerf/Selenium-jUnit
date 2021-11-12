package com.Techproed.tests;

import org.junit.*;

public class Day01_JunitTestUnit {

    //@Before : runs before each @Test annotation
    //@After :runs after each @Test annotation
    //AfterClass, @BeforeClass @ignore
    //@Ignore : This is used to skip test cases

    @Before
    public void setUp() {
        System.out.println("this is set up method");

    }

    @Test
    public void test1() {
        System.out.println("Test case 1");

    }

    @Ignore
    @Test
    public void test2() {
        System.out.println("Test case 2");

    }

    @Test
    public void test3() {
        System.out.println("Test case 3");


    }

    @After
    public void teardown() {
        System.out.println("This is tear down method");
    }

    // JUNIT unit
    // we use assertions if expected = actual
    @Test
    public void assertion() {

        //1. Assert.assertTrue(statement)
        Assert.assertTrue(3 == 3);
        //2. Assert.assertFalse(statement)
        Assert.assertFalse(3==3);
        Assert.assertFalse("Selenium".contains("a"));
        //3. Assert.assertEquals("expected","actual")
        Assert.assertEquals("java","java");//pass
        Assert.assertEquals("java","javascript");

    }
}