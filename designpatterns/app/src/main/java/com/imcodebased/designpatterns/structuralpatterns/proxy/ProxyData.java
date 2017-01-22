package com.imcodebased.designpatterns.structuralpatterns.proxy;

/**
 * Created by codebased on 22/1/17.
 */

public class ProxyData implements Data {
    RealData realData;

    @Override
    public String get() {
        if (realData == null) {
            realData = new RealData();
        }

        return realData.get();
    }
}
