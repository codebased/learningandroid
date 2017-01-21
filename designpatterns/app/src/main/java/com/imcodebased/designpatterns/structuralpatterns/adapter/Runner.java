package com.imcodebased.designpatterns.structuralpatterns.adapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by codebased on 21/1/17.
 */

public class Runner {
    public static void main(String[] str){

        Employee dbEmployee = new DBEmployee();
        Employee  webServiceAdapterEmployee = new WebServiceAdapterEmployee(new ExternalServiceEmployee());
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(dbEmployee);
        employeeList.add(webServiceAdapterEmployee);
    }
}
