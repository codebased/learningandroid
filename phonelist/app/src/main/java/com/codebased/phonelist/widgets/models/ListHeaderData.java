package com.codebased.phonelist.widgets.models;

/**
 * Created by codebased on 14/09/16.
 */
public class ListHeaderData {

    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text.substring(0, 1).toUpperCase();
    }
}
