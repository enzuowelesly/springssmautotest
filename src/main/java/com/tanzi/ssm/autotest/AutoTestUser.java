package com.tanzi.ssm.autotest;

import com.tanzi.ssm.utils.GetCookie;
import com.tanzi.ssm.utils.GetRandomString;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.io.IOException;

public class AutoTestUser {
    String url="http://localhost:8888/tanzi_ssm_web/";
    String username="tanzi";
    String password="tanzi";
    private CloseableHttpClient client;
    @BeforeMethod
    public void beforemethod(){
        System.out.println("beforemethod运行了");
    }
    @AfterMethod
    public void aftermethod(){
        System.out.println("aftermethod运行了");
    }
    @BeforeClass
    public void beforeclass(){
        System.out.println("beforeclass运行了");
    }
    @AfterClass
    public void afterclass(){
        System.out.println("afterclass运行了");
    }

    @BeforeTest
    public void getResource(){
         client = HttpClientBuilder.create().build();
    }
    @Test
    public void test_UserFindAll() throws IOException {
        HttpGet httpGet =new HttpGet(url+"user/findAll.do");
        httpGet.setHeader("Content-Type", "text/html;charset=UTF-8");
        httpGet.setHeader("Cookie",GetCookie.getcookie(username,password));
        HttpResponse httpResponse =client.execute(httpGet);
                System.out.println(httpResponse.getStatusLine().getStatusCode());
        Assert.assertEquals(httpResponse.getStatusLine().getStatusCode(),200);
        Reporter.log(httpResponse.toString());
    }
    @Test(enabled = false)
    public void test_findUserById( ) throws IOException {
        HttpGet httpget=new HttpGet(url+"user/findById.do?id=1");
        httpget.setHeader("Content-Type", "text/html;charset=UTF-8");
        httpget.setHeader("Cookie",GetCookie.getcookie(username,password));
        HttpResponse httpResponse =client.execute(httpget);
        System.out.println(httpResponse.getStatusLine().getStatusCode());
    }
    @Test(enabled = false)
    public void test_findUserByIdAndRole( ) throws IOException {
        HttpGet httpget=new HttpGet(url+"user/findUserByIdAndAllRole.do?id=1");
        httpget.setHeader("Content-Type", "text/html;charset=UTF-8");
        httpget.setHeader("Cookie",GetCookie.getcookie(username,password));
        HttpResponse httpResponse =client.execute(httpget);
        System.out.println(httpResponse.getStatusLine().getStatusCode());

    }
    @Test
    public void test_saveUser( ) throws IOException {
        String username= GetRandomString.getRandomUserName();
        String password="tanzi";
        String email=GetRandomString.getRadomEmail();
        String phoneNum=GetRandomString.getRandomPhoneNum();
        String status=1+"";
        String saveurl=url+"user/save.do?username="+username+"&password="+password+"&email="+email+"&phoneNum="+phoneNum+"&status="+status;
        HttpPost httppost = new HttpPost(saveurl);

        httppost.setHeader("Content-Type", "text/html;charset=UTF-8");
        httppost.setHeader("Cookie",GetCookie.getcookie(username,password));
        HttpResponse httpResponse =client.execute(httppost);
        System.out.println(httpResponse.getStatusLine().getStatusCode());
        Assert.assertEquals(httpResponse.getStatusLine().getStatusCode(),302);
        Reporter.log(httpResponse.toString()+"log日志全部" );
    }
    @Test(enabled = false)
    public void test_addRoleToUser( ) throws IOException {
        String addurl=url+"user/addRoleToUser.do?userId=15&ids=1";
        HttpPost httppost = new HttpPost(addurl);
        httppost.setHeader("Content-Type", "text/html;charset=UTF-8");
        httppost.setHeader("Cookie",GetCookie.getcookie(username,password));
        HttpResponse httpResponse =client.execute(httppost);
        System.out.println(httpResponse.getStatusLine().getStatusCode());




    }
}
