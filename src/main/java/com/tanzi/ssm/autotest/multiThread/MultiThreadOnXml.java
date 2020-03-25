package com.tanzi.ssm.autotest.multiThread;

import org.testng.annotations.Test;

public class MultiThreadOnXml {
    @Test
    public void multithreadxml1(){
    System.out.printf("Thread Id : %s%n",Thread.currentThread().getId());
}
    @Test
    public void multithreadxml2() {
        System.out.printf("Thread Id : %s%n",Thread.currentThread().getId());
    }
    @Test
    public void multithreadxml3() {
            System.out.printf("Thread Id : %s%n", Thread.currentThread().getId());

    }
}

