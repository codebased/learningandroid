package com.imcodebased.designpatterns.behaviouralpatterns.command;

/**
 * Created by codebased on 22/1/17.
 */
public class ToggleCommand implements Command {

    private Light light;
    public ToggleCommand (Light light) {
        this.light = light;
    }


    @Override
    public void Execute() {
        this.light.on();
    }
}
