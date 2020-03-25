package com.tanzi.ssm.utils;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.entity.mime.content.ContentBody;

public class GetRandomString {
    public  static String getRandomUserName(){
        String randomString= RandomStringUtils.random(5,true,false).toLowerCase();
        return randomString;

    }
    public  static String getRandomPhoneNum(){
        String randomNumbers="176" +RandomStringUtils.random(8,false,true);
        return randomNumbers;
    }
    public static String getRadomEmail(){
        String randomEmail =getRandomUserName() + "@tanzi.com";
        return randomEmail;

    }
    public static String getPassword(){
        //password=tanzi
        return "$2a$10$MQQxFubxyFiRNlTcWSd1SeQxx/vnUdmADsWOgC/mRwQKE8ckztqfi";

    }

}
