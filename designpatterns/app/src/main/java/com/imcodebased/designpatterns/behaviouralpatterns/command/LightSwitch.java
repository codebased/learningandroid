package com.imcodebased.designpatterns.behaviouralpatterns.command;

/**
 * Created by codebased on 22/1/17.
 */

// invoker
public class LightSwitch {


    public void execute(Command command){
        command.Execute();

    }
}
