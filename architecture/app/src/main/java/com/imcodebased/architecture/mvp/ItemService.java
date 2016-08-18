package com.imcodebased.architecture.mvp;

import java.util.List;

public interface ItemService {

    interface ItemListener {
        void onLoad(List<String> items);
    }

    void findItems(ItemListener listener);
}