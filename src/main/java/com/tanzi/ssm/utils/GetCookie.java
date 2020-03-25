package com.tanzi.ssm.utils;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONObject;

import java.io.IOException;

import static com.sun.org.apache.xalan.internal.lib.ExsltStrings.split;

public class GetCookie {
    public static String getcookie(String username, String password) throws IOException {
        String url = "http://localhost:8888/tanzi_ssm_web/login.do";
        CookieStore cookieStore = new BasicCookieStore();
        CloseableHttpClient httpClient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();
        HttpPost postRequest = new HttpPost(url);
        JSONObject param = new JSONObject();
        param.put("username", username);
        param.put("password", password);
        postRequest.setHeader("Content-Type", "text/html;charset=utf-8");
        postRequest.setEntity(new StringEntity(param.toString(), "utf-8"));
        HttpResponse response = httpClient.execute(postRequest);
        String[] server = response.getFirstHeader("Set-Cookie").getValue().split("; ");
        String cookie = server[0];
        return cookie;
    }

}