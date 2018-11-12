package com.bocian.service;

public class SomeRandomService {

    public SomeRandomService() {

    }

    public void init() {
        System.out.println("Initing SomeRandomService");
    }

    public void destroy() {
        System.out.println("Destroying SomeRandomService");
    }

    public double doJobA() {
        return RandomLongSumming.add();
    }

    public double doJobB() {
        return RandomLongSumming.add(10000);
    }
}
