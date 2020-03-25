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

public class AutoTestRole {
    String url = "http://localhost:8888/tanzi_ssm_web/";
    String username = "tanzi";
    String password = "tanzi";
    private CloseableHttpClient client;

    @BeforeTest
    public void getResource() {
        client = HttpClientBuilder.create().build();
    }

    @Test
    public void test_RoleFindAll() throws IOException {
        HttpGet httpGet = new HttpGet(url + "role/findAll.do");
        httpGet.setHeader("Content-Type", "text/html;charset=UTF-8");
        httpGet.setHeader("Cookie", GetCookie.getcookie(username, password));
        HttpResponse httpResponse = client.execute(httpGet);
        System.out.println(httpResponse.getStatusLine().getStatusCode());
    }

    @Test(enabled = false)
    public void test_saveRole() throws IOException {
        String roleName = "RoleName"+GetRandomString.getRandomUserName();
        String roleDesc = "RoleDesc"+GetRandomString.getRandomUserName();
        String saveurl = url + "role/save.do?roleName="+roleName+"&roleDesc="+roleDesc;
        HttpPost httppost = new HttpPost(saveurl);

        httppost.setHeader("Content-Type", "text/html;charset=UTF-8");
        httppost.setHeader("Cookie", GetCookie.getcookie(username, password));
        HttpResponse httpResponse = client.execute(httppost);
        System.out.println(httpResponse.getStatusLine().getStatusCode());
    }

    @Test(enabled = false)
    public void test_addPermissionToRole() throws IOException {
        String addurl = url + "role/addPermissionToRole.do?roleId=7&ids=1";
        HttpPost httppost = new HttpPost(addurl);
        httppost.setHeader("Content-Type", "text/html;charset=UTF-8");
        httppost.setHeader("Cookie", GetCookie.getcookie(username, password));
        HttpResponse httpResponse = client.execute(httppost);
        System.out.println(httpResponse.getStatusLine().getStatusCode());

    }
    @Test
    public void test_findRoleByIdAndAllPermission() throws IOException {
        String addurl = url + "role/findRoleByIdAndAllPermission.do?id=8";
        HttpGet httpget = new HttpGet(addurl);
        httpget.setHeader("Content-Type", "text/html;charset=UTF-8");
        httpget.setHeader("Cookie", GetCookie.getcookie(username, password));
        HttpResponse httpResponse = client.execute(httpget);
        System.out.println(httpResponse.getStatusLine().getStatusCode());

    }
}