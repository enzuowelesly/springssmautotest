package com.tanzi.ssm.autotest;

import org.testng.annotations.*;

public class SuiteConfig {
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("beforesuite运行了");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("aftersuite运行了");
    }

    @BeforeTest
    public void beforetest(){
        System.out.println("beforetest运行了");
    }
    @AfterTest
    public void aftertest(){
        System.out.println("aftertest运行了");
    }

}
