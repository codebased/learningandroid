package com.imcodebased.architecture.mvp;

import android.os.Handler;

import java.util.Arrays;
import java.util.List;

public class ItemServiceImpl implements ItemService {
    @Override
    public void findItems(final ItemListener listener) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                listener.onLoad(getData());
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