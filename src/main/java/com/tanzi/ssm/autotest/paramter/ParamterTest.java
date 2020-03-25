package com.tanzi.ssm.autotest.paramter;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParamterTest{
    @Parameters({"name","age"})
    @Test
    public void paramTest1(String name,int age){
        System.out.println(age);
        System.out.println(name);


    }
}
