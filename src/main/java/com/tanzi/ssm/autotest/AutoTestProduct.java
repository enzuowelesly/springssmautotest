package com.tanzi.ssm.autotest;

import com.tanzi.ssm.utils.GetCookie;
import com.tanzi.ssm.utils.GetRandomString;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class AutoTestProduct {
    String url = "http://localhost:8888/tanzi_ssm_web/";
    String username = "tanzi";
    String password = "tanzi";
    private CloseableHttpClient client;

    @BeforeTest
    public void getResource() {
        client = HttpClientBuilder.create().build();
    }

    @Test
    public void test_ProductFindAll() throws IOException {
        HttpGet httpGet = new HttpGet(url + "product/findAll.do");
        httpGet.setHeader("Content-Type", "text/html;charset=UTF-8");
        httpGet.setHeader("Cookie", GetCookie.getcookie(username, password));
        HttpResponse httpResponse = client.execute(httpGet);
        System.out.println(httpResponse.getStatusLine().getStatusCode());
    }

    @Test
    public void test_saveProduct() throws IOException {
        String roleName = "RoleName"+ GetRandomString.getRandomUserName();
        String roleDesc = "RoleDesc"+GetRandomString.getRandomUserName();
        String saveurl = url + "product/save.do?"+"productNum=4564&productName=456&departureTime=1899-12-31+00%3A00&cityName=456&productPrice=456&productStatus=1&productDesc=456";
        HttpPost httppost = new HttpPost(saveurl);
        httppost.setHeader("Content-Type", "text/html;charset=UTF-8");
        httppost.setHeader("Cookie", GetCookie.getcookie(username, password));
        HttpResponse httpResponse = client.execute(httppost);
        System.out.println(httpResponse.getStatusLine().getStatusCode());
    }
}
