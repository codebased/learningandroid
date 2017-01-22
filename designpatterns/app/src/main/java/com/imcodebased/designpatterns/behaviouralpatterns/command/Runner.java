package com.imcodebased.designpatterns.behaviouralpatterns.command;

/**
 * Created by codebased on 22/1/17.
 */

public class Runner {
    public static void main(String[] str){
        // it is as same as Runnable defined in Java.

        // light is a receiver.
        Light light = new Light();
        LightSwitch lightSwitch = new LightSwitch();

        Command command = new ToggleCommand(light);

        lightSwitch.execute(command);
    }
}
