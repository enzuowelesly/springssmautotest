package com.tanzi.ssm.autotest.groups;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class GroupOnMethod {
    @Test(groups = "service")
    public void testGroup1(){
        System.out.println("服务端组111111111");
    }
    @Test(groups = "service")
    public void testGroup2(){
        System.out.println("服务端组222222222");
    }
    @Test(groups = "client")
    public void testGroupc1(){
        System.out.println("科幻组111111111");
    }
    @Test(expectedExceptions = RuntimeException.class)
    public void testGroupc2(){
        System.out.println("科幻组22222222222");
    }
    @BeforeGroups("service")
    public void beforegroupser1(){
        System.out.println("服务断组1前前前前前");
    }
    @AfterGroups("service")
    public void beforegroupser2(){
        System.out.println("服务断组后吼吼吼吼");
    }
    @BeforeGroups("client")
    public void beforegroupclient1(){
        System.out.println("客户端组1前前前前前");
    }
    @AfterGroups("client")
    public void beforegroupclient2(){
        System.out.println("客户端组后吼吼吼吼");
    }
}
