package com.imcodebased.designpatterns.structuralpatterns.adapter;

/**
 * Created by codebased on 21/1/17.
 */

public class WebServiceAdapterEmployee implements Employee {

    private final ExternalServiceEmployee webServiceEmployee;

    WebServiceAdapterEmployee(ExternalServiceEmployee webServiceEmployee) {
        this.webServiceEmployee = webServiceEmployee;
    }


    @Override
    public int getId() {
        return webServiceEmployee.getcode();
    }
}