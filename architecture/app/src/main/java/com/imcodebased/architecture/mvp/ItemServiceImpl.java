package com.imcodebased.architecture.mvp;

import android.os.Handler;

import java.util.Arrays;
import java.util.List;

import de.greenrobot.event.EventBus;

public class ItemServiceImpl implements ItemService {
    @Override
    public void findItems() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                EventBus.getDefault().post(new ItemEventMessage(getData()));
            }
        }, 2000);
    }

    private List<String> getData() {
        return Arrays.asList(
                "Item 1",
                "Item 2",
                "Item 3",
                "Item 4",
                "Item 5",
                "Item 6",
                "Item 7",
                "Item 8",
                "Item 9",
                "Item 10"
        );
    }
}