package com.imcodebased.designpatterns.behaviouralpatterns.chainofresponsiblity;

/**
 * Created by codebased on 22/1/17.
 */

public class Runner {

    public static void main(String[] str){
        Handler handler = new LegacySystemRequestHandler(new DefaultHandler());
        RequestMessage message = new RequestMessage();
        message.setClientId(100);
        handler.ProcessRequest(message);
        message.setClientId(10220);
        handler.ProcessRequest(message);
    }
}
