package com.codebased.phonelist.widgets.listeners;

import com.codebased.phonelist.widgets.models.ListItemData;

public interface PhoneContactSelectorListener {
    void onInserted(ListItemData listItemData);

    void onDeleted(ListItemData listItemData);
}