package com.imcodebased.designpatterns.behaviouralpatterns.chainofresponsiblity;

/**
 * Created by codebased on 22/1/17.
 */

public class LegacySystemRequestHandler extends Handler {
    private final Handler defaultHandler;

    public LegacySystemRequestHandler (Handler defaultHandler){
        this.defaultHandler = defaultHandler;
    }
    @Override
    public boolean ProcessRequest(RequestMessage message) {
        if (message.getClientId() < 1000) {
            System.out.println("LegacySystemRequest");
            return true;
        }
        return defaultHandler.ProcessRequest(message);
    }
}
