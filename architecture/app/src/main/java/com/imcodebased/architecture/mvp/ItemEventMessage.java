package com.imcodebased.architecture.mvp;

import java.util.List;

/**
 * Created by codebased on 18/08/16.
 */
public class ItemEventMessage {
    private final List<String> items;

    public ItemEventMessage(List<String> items){
        this.items = items;
    }

    public List<String> getItems() {
        return items;
    }
}
