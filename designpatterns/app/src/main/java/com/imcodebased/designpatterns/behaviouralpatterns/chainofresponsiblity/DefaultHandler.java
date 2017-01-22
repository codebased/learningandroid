package com.imcodebased.designpatterns.behaviouralpatterns.chainofresponsiblity;

/**
 * Created by codebased on 22/1/17.
 */

public class DefaultHandler extends Handler{

    @Override
    public boolean ProcessRequest(RequestMessage message) {
        System.out.println("DefaultHandler");

        return true;
    }
}