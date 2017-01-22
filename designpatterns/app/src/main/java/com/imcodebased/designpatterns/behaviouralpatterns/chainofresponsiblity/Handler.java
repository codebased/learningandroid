package com.imcodebased.designpatterns.behaviouralpatterns.chainofresponsiblity;

/**
 * Created by codebased on 22/1/17.
 */

public abstract class Handler {
    public abstract boolean ProcessRequest(RequestMessage message);
}
