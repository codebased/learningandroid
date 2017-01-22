package com.imcodebased.designpatterns.behaviouralpatterns.chainofresponsiblity;

/**
 * Created by codebased on 22/1/17.
 */
public class RequestMessage {

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    int clientId;
}
