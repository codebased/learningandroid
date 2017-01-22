package com.imcodebased.designpatterns.structuralpatterns.proxy;

/**
 * Created by codebased on 22/1/17.
 */

public class RealData implements Data {
    @Override
    public String get() {
        return "real data";
    }
}
